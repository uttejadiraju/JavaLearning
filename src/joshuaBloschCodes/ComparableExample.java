package joshuaBloschCodes;

import java.util.ArrayList;
import java.util.Collections;

class Movie implements Comparable<Movie> {
	private int year;
	private String name;
	private int rating;

	public Movie(int year, int rating, String name) {
		this.year = year;
		this.rating = rating;
		this.name = name;
	}

	@Override
	public int compareTo(Movie o) {
		return this.year - o.year; // Ascending order
	}

	public String toString() {
		return this.year + " === " + this.name + " === " + this.rating;
	}
	
}
public class ComparableExample {
	public static void main(String[] args) {
		ArrayList<Movie> al = new ArrayList<>();
		al.add(new Movie(1990, 2, "a"));
		al.add(new Movie(2001, 3, "b"));
		al.add(new Movie(1968, 4, "c"));
		al.add(new Movie(2015, 5, "d"));
		al.add(new Movie(1947, 6, "e"));
		Collections.sort(al);
		System.out.println(al);
	}
}
