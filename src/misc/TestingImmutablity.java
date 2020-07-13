package misc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestingImmutablity {
	private static Integer v = 1;
	private static final List<Integer> immutableArrayList = Arrays.asList(v);
	private static final List<Integer> nonImmutableArrayList = new ArrayList<Integer>();

	public static void main(String args[]) {
		nonImmutableArrayList.add(10);
		try {
			immutableArrayList.add(5);
		} catch (UnsupportedOperationException e) {
			System.out.println("Threw exception");
		}

		try {
			System.out.println("\n" + immutableArrayList.toString());
			List<Integer> list = immutableArrayList;
			list.add(5);
		} catch (UnsupportedOperationException e) {
			System.out.println("Threw exception");
		}

		try {
			List<Integer> list = nonImmutableArrayList;
			list.add(145);
		} catch (Exception e) {
			System.out.println("Hello!!!");
		}

		try {
			System.out.println("\n" + immutableArrayList.toString());
			List<Integer> list = immutableArrayList;
			System.out.println("NO error!!!");
		} catch (UnsupportedOperationException e) {
			System.out.println("Threw exception");
		}

	}
}
