package movies;

/*
 * Holds Information about Movies
 */
public class Movie implements Comparable<Movie> {

	private String title;
	private int year;

	/*
	 * CONSTRUCTOR
	 * @param title Title of the movie
	 * @param year Year which the movie was made
	 */
	public Movie(String title, int year) {
		this.title = title;
		this.year = year;
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(Movie m) {
		if (title.compareTo(m.title) == 0) {
			if (year == m.year) {
				return 0;
			} else {
				return year - m.year;
			}
		} else {
			return title.compareTo(m.title);
		}
	}

	/*
	 * See's if two objects are the exact same.
	 * @param m The Movie Object that is being compared
	 */
	public boolean equals(Movie m) {
		if (m.title.equals(title) && m.year == year) {
			return true;
		}
		return false;
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return ("Movie " + title + " (" + year + ")");
	}

	/*
	 * TESTER
	 */
	public static Movie[] getTestMovies() {
		Movie[] list = new Movie[10];
		list[0] = new Movie("The Thomas Crown Affair", 1968);
		list[1] = new Movie("The Thomas Crown Affair", 1999);
		list[2] = new Movie("The Martian", 2015);
		list[3] = new Movie("Bridge of Spies", 2015);
		list[4] = new Movie("Suicide Squad", 2016);
		list[5] = new Movie("Suicide Squad", 2016);
		list[6] = new Movie("The Magnificent Seven", 2016);
		list[7] = new Movie("Casablanca", 1942);
		list[8] = new Movie("Gone with the Wind", 1939);
		list[9] = new Movie("The Maltese Falcon", 1941);

		return list;
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() {
		return title.hashCode() + year;
	}

}
