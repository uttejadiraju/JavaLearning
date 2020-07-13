package misc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FinalTesting {

	public static void main(String args[]) {
		ArrayList al = new ArrayList();
		ArrayList a = new ArrayList();
		a = al;
		a.add("hello");
		System.out.println(al.toString());
		ArrayList b = new ArrayList();
		a = b;
		System.out.println(al.toString());
		System.out.println(a.toString());
	}
}
