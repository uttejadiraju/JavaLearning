package generics;

import java.util.ArrayList;
import java.util.List;

public class WildCardInheritance {
	class A {
		/* ... */ }

	class B extends A {
		/* ... */ }

	B b = new B();
	A a = b;

	List<B> lb = new ArrayList<>();
	// List<A> la = lb; // compile-time error

	List<? extends Integer> intList = new ArrayList<>();

	List<? extends Number> numList = intList;
}

/***
 * Because Integer is a subtype of Number, and numList is a list of Number
 * objects, a relationship now exists between intList (a list of Integer
 * objects) and numList. The following diagram shows the relationships between
 * several List classes declared with both upper and lower bounded wildcards.
 * 
 * diagram showing that List<Integer> is a subtype of both List<? extends
 * Integer> and List<?super Integer>. List<? extends Integer> is a subtype of
 * List<? extends Number> which is a subtype of List<?>. List<Number> is a
 * subtype of List<? super Number> and List>? extends Number>. List<? super
 * Number> is a subtype of List<? super Integer> which is a subtype of List<?>.
 ***/