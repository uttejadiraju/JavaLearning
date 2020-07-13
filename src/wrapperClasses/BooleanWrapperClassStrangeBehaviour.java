package wrapperClasses;

import static java.lang.System.out;
public class BooleanWrapperClassStrangeBehaviour {
	public static void main(String[] args) {
		Boolean b = new Boolean("left");
		Boolean b1 = new Boolean("right");
		out.println(b == b1); // false
		out.println(b.equals(b1)); // true!!!
		
		/**
		 * Java boolean class treats all strings supplied to constructor as true if case insensitive true("True",
		 * or "TRUe"..) are given. In case of "left" & "right", they are not true. Hence, b == false & b1 == false.
		 * Hence, equals = true;
		 */
		out.println(b.booleanValue());
		out.println(b1.booleanValue());
	}
}
