package generics;

import java.util.ArrayList;

import java.util.List;

public class LowerBoundedWildCards {
	public static void main(String[] args) {
		List<Object> objList = new ArrayList<Object>();
		objList.add("String1");
		objList.add("String2");
		objList.add("String3");
		objList.add(1);
		addNumbers(objList);

	}

	public static void addNumbers(List<? super Integer> list) {
		for (int i = 1; i <= 10; i++) {
			list.add(i);
		}
		System.out.println(list.toString());
	}
}

/***
 * Say you want to write a method that puts Integer objects into a list. To
 * maximize flexibility, you would like the method to work on List<Integer>,
 * List<Number>, and List<Object> — anything that can hold Integer values.
 * 
 * To write the method that works on lists of Integer and the supertypes of
 * Integer, such as Integer, Number, and Object, you would specify List<? super
 * Integer>. The term List<Integer> is more restrictive than List<? super
 * Integer> because the former matches a list of type Integer only, whereas the
 * latter matches a list of any type that is a supertype of Integer.
 ***/