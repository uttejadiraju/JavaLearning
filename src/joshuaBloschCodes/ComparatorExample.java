package joshuaBloschCodes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Move {
	public int year;
	public String name;
	public int rating;

	public Move(int year, int rating, String name) {
		this.year = year;
		this.rating = rating;
		this.name = name;
	}

	public String toString() {
		return this.year + " === " + this.name + " === " + this.rating;
	}

}

class RatingCompDec implements Comparator<Move> {
	public int compare(Move o1, Move o2) {
		return o2.rating - o1.rating; // Decending order.
	}

}

class RatingCompAsc implements Comparator<Move> {
	public int compare(Move o1, Move o2) {
		return o2.rating - o1.rating; // Decending order.
	}

}

class NameComp implements Comparator<Move> {
	public int compare(Move o1, Move o2) {
		return o1.name.compareTo(o2.name); // Ascending order.
	}

}

class NameCompDes implements Comparator<Move> {
	public int compare(Move o1, Move o2) {
		return o2.name.compareTo(o1.name); // Decending order.
	}

}

public class ComparatorExample {
	public static void main(String[] args) {
		ArrayList<Move> al = new ArrayList<>();
		al.add(new Move(1990, 2, "a"));
		al.add(new Move(2001, 3, "b"));
		al.add(new Move(1968, 4, "c"));
		al.add(new Move(2015, 5, "d"));
		al.add(new Move(1947, 6, "e"));
		Collections.sort(al, new RatingCompDec());
		System.out.println(al);
		Collections.sort(al, new RatingCompAsc());
		System.out.println(al);
		Collections.sort(al, new NameComp());
		System.out.println(al);
		Collections.sort(al, new NameCompDes());
		System.out.println(al);

		String str = "hello";
		str.hashCode();
		str.hashCode();
		str = "hello";
		str.hashCode();
		str = "hh";
		str.hashCode();

		System.out.println(al);

	}
}
