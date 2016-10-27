package sudoku;

import java.util.*;

public class Grid {
	private int[][] values;

	//
	// DON'T CHANGE THIS.
	//
	// See TestGridSupplier for examples of input.
	// Dots in input strings represent 0s in values[][].
	//
	public Grid(String[] rows) {
		values = new int[9][9];
		for (int j = 0; j < 9; j++) {
			String row = rows[j];
			char[] charray = row.toCharArray();
			for (int i = 0; i < 9; i++) {
				char ch = charray[i];
				if (ch != '.')
					values[j][i] = ch - '0';
			}
		}
	}

	//
	// DON'T CHANGE THIS.
	//
	public String toString() {
		String s = "";
		for (int j = 0; j < 9; j++) {
			for (int i = 0; i < 9; i++) {
				int n = values[j][i];
				if (n == 0)
					s += '.';
				else
					s += (char) ('0' + n);
			}
			s += "\n";
		}
		return s;
	}

	// Finds an empty member of values[][]. Returns an array list of 9 grids
	// that look like the current grid,
	// except the empty member contains 1, 2, 3 .... 9. Returns null if the
	// current grid is full.
	//
	// Example: if this grid =
	// 1........
	// .........
	// .........
	// .........
	// .........
	// .........
	// .........
	// .........
	// .........
	//
	// Then the returned array list would contain:
	//
	// 11....... 12....... 13....... 14....... and so on 19.......
	// ......... ......... ......... ......... .........
	// ......... ......... ......... ......... .........
	// ......... ......... ......... ......... .........
	// ......... ......... ......... ......... .........
	// ......... ......... ......... ......... .........
	// ......... ......... ......... ......... .........
	// ......... ......... ......... ......... .........
	// ......... ......... ......... ......... .........
	//
	public ArrayList<Grid> next9Grids() {
		// if the grid is full, returns null
		if (this.isFull())
			return null;

		ArrayList<Grid> grids = new ArrayList<Grid>(); // list that is returned

		int[][] copy = new int[values.length][values[0].length]; // copies the
																	// values
		String[] result = new String[9]; // creates grid

		System.arraycopy(this.values, 0, copy, 0, this.values.length);

		/*
		 * copies the values and puts it into the String array which is used to
		 * create a new Grid
		 */
		for (int row = 0; row < copy.length; row++) {
			for (int col = 0; col < copy[0].length; col++) {
				if (copy[row][col] == 0) {
					for (int number = 1; number < 10; number++) {
						for (int i = 0; i < result.length; i++) {
							result[i] = "";
						}

						copy[row][col] = number;

						for (int i = 0; i < copy.length; i++) {
							for (int j = 0; j < copy[0].length; j++) {
								if (copy[i][j] == 0) {
									result[i] += '.';
								} else {
									result[i] += copy[i][j];
								}
							}
						}
						grids.add(new Grid(result));

					}
					// breaks out of all loops
					row = copy.length;
					col = copy[0].length;
					break;
				}
			}
		}
		return grids;
	}

	/*
	 * Returns true if this grid is legal. A grid is legal if no row, column, or
	 * 3x3 block contains a repeated 1, 2, 3, 4, 5, 6, 7, 8, or 9.
	 */
	public boolean isLegal() {
		HashSet<Integer> checker = new HashSet<Integer>();
		/*
		 * Checks if there are any repeating numbers in each rows
		 */
		for (int row = 0; row < values.length; row++) {
			for (int col = 0; col < values[0].length; col++) {
				if (values[row][col] == 0)
					continue;
				if (checker.add(values[row][col]) == false) {
					return false;
				}
			}
			checker.clear();
		}
		/*
		 * Checks every col for a repeating number
		 */
		for (int col = 0; col < values[0].length; col++) {
			for (int row = 0; row < values.length; row++) {
				if (values[row][col] == 0)
					continue;
				if (checker.add(values[row][col]) == false) {
					return false;
				}
			}
			checker.clear();
		}
		/*
		 * Checks every 3x3 block
		 */
		int counter = 0;
		int counterRow = 0;
		for (int block = 0; block < 9; block++) {
			for (int row = 0; row < 3; row++) {
				for (int col = 0; col < 3; col++) {
					checker.add(values[counterRow][counter]);
					if (++counter > 8)
						counter = 0;
				}
				if (++counterRow > 8)
					counterRow = 0;
			}
		}
		checker.clear();
		return true;
	}

	//
	// Returns true if every cell member of values[][] is a digit from 1-9.
	//
	public boolean isFull() {
		boolean full = true;
		for (int[] e : values) {
			for (int element : e) {
				if (element == 0) {
					full = false;
					break;
				}
				//breaks out of the for loop if not full
				if (!full)
					break;
			}
		}
		return full;
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 * Returns true if x is a Grid and, for every (i,j),
	 *  x.values[i][j] == this.values[i][j].
	 */
	public boolean equals(Object x) {
		boolean result = true;
		Grid that = (Grid) x;
		if (this.values.length == that.values.length && this.values[0].length == that.values[0].length) {
			for (int i = 0; i < this.values.length; i++) {
				for (int j = 0; j < this.values[0].length; j++) {
					if (this.values[i][j] != that.values[i][j])
						result = false;
				}
			}
		} else {
			result = false;
		}
		return result;
	}
}
