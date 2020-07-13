package joshuaBloschCodes;

import java.util.ArrayList;
import java.util.Collections;

class Movies implements Comparable<Movies> {
	private int year;
	private String name;
	private int rating;

	public Movies(int year, int rating, String name) {
		this.year = year;
		this.rating = rating;
		this.name = name;
	}

	@Override
	public int compareTo(Movies o) {
		return o.year - this.year; // Decending order
	}

	public String toString() {
		return this.year + " === " + this.name + " === " + this.rating;
	}
	
}

public class ComparableExampleDecendingOrder {
	public static void main(String[] args) {
		ArrayList<Movies> al = new ArrayList<>();
		al.add(new Movies(1990, 2, "a"));
		al.add(new Movies(2001, 3, "b"));
		al.add(new Movies(1968, 4, "c"));
		al.add(new Movies(2015, 5, "d"));
		al.add(new Movies(1947, 6, "e"));
		Collections.sort(al);
		System.out.println(al);
	}
}
