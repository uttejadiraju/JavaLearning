package generics;

import java.util.Arrays;
import java.util.List;

public class UnboundedWildCards {
	public static void main(String[] args) {
		List<Integer> li = Arrays.asList(1, 2, 3);
		List<String> ls = Arrays.asList("one", "two", "three");
		printList(li);
		printList(ls);
	}

	static<T> void printList(List<T> list) {
		for (T elem : list)
			System.out.print(elem + " ");
		System.out.println();
	}
}

/***
 * The goal of printList is to print a list of any type, but it fails to achieve
 * that goal — it prints only a list of Object instances; it cannot print
 * List<Integer>, List<String>, List<Double>, and so on, because they are not
 * subtypes of List<Object>. To write a generic printList method, use List<?>:
 ***/