package generics;

import java.util.ArrayList;

import java.util.List;

public class UpperBoundedWildCards {
	public static void main(String[] args) {
		List<Integer> objList = new ArrayList<Integer>();
		objList.add(1);
		sumOfList(objList);
		List<Double> objList1 = new ArrayList<Double>();
		objList1.add(1.2);
		sumOfList(objList1);

		ArrayList<? extends Number> ll = new ArrayList<>();
		ArrayList<Integer> lll = new ArrayList<>();
		ll = lll;

		// Buggy code!!!
		List<Number> ll1 = new ArrayList<>();
		List<Integer> lll1 = new ArrayList<>();
		// ll1 = lll1;

	}

	public static void sumOfList(List<? extends Number> list) {
		int s = 0;
		for (Number n : list)
			s += n.intValue();
		System.out.println(s);
	}
}

/***
 * You can use an upper bounded wildcard to relax the restrictions on a
 * variable. For example, say you want to write a method that works on
 * List<Integer>, List<Double>, and List<Number>; you can achieve this by using
 * an upper bounded wildcard.
 * 
 * To declare an upper-bounded wildcard, use the wildcard character ('?'),
 * followed by the extends keyword, followed by its upper bound. Note that, in
 * this context, extends is used in a general sense to mean either "extends" (as
 * in classes) or "implements" (as in interfaces).
 * 
 * To write the method that works on lists of Number and the subtypes of Number,
 * such as Integer, Double, and Float, you would specify List<? extends Number>.
 * The term List<Number> is more restrictive than List<? extends Number> because
 * the former matches a list of type Number only, whereas the latter matches a
 * list of type Number or any of its subclasses.
 ***/