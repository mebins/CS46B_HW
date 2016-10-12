package movies;

import java.util.ArrayList;
import java.util.TreeSet;

public class TreeFilmArchive extends TreeSet<Movie> implements FilmArchive {

	/*
	 * (non-Javadoc)
	 * 
	 * @see movies.FilmArchive#getSorted()
	 */
	@Override
	public ArrayList<Movie> getSorted() {
		ArrayList<Movie> organizedList = new ArrayList<Movie>(this);

		return organizedList;
	}

	/*
	 * MAIN METHOD
	 */
	public static void main(String[] args) {
		TreeFilmArchive archive = new TreeFilmArchive();
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
