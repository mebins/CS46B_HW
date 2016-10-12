package movies;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.TreeSet;

public class HashFilmArchive extends HashSet<Movie> implements FilmArchive {

	/*
	 * (non-Javadoc)
	 * 
	 * @see movies.FilmArchive#getSorted()
	 */
	@Override
	public ArrayList<Movie> getSorted() {
		TreeSet<Movie> list = new TreeSet<Movie>(this);
		ArrayList<Movie> organizedList = new ArrayList<Movie>(list);
		return organizedList;
	}

	/*
	 * MAIN METHOD
	 */
	public static void main(String[] args) {
		HashFilmArchive archive = new HashFilmArchive();
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
