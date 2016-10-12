package movies;

import java.util.ArrayList;
import java.util.TreeSet;

public class ListFilmArchive extends ArrayList<Movie> implements FilmArchive {

	/*
	 * (non-Javadoc)
	 * 
	 * @see movies.FilmArchive#getSorted()
	 */
	@Override
	public ArrayList<Movie> getSorted() {
		// TODO Auto-generated method stub
		TreeSet<Movie> list = new TreeSet(this);
		ArrayList<Movie> organizedList = new ArrayList<Movie>(list);
		return organizedList;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.ArrayList#add(java.lang.Object)
	 */
	@Override
	public boolean add(Movie m) {
		for (Movie element : this) {
			if (element.equals(m)) {
				return false;
			}
		}
		super.add(m);
		return true;
	}

	/*
	 * MAIN METHOD
	 */
	public static void main(String[] args) {
		ListFilmArchive archive = new ListFilmArchive();
		for (Movie m : Movie.getTestMovies()) {
			archive.add(m);
		}
		for (Movie m : archive) {
			System.out.println(m);
		}
		System.out.println("-----------------");
		ArrayList<Movie> list = archive.getSorted();
		for (Movie m : list) {
			System.out.println(m);
		}
	}
}
