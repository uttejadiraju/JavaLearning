package generics;

import java.util.ArrayList;
import java.util.List;

public class WildcardCaptureAndHelperMethods {

	class WildcardError {

		void foo(List<?> i) {
			// Error. i.set(0, i.get(0));
		}
		/***
		 * In this example, the compiler processes the i input parameter as being of
		 * type Object. When the foo method invokes List.set(int, E), the compiler is
		 * not able to confirm the type of object that is being inserted into the list,
		 * and an error is produced. When this type of error occurs it typically means
		 * that the compiler believes that you are assigning the wrong type to a
		 * variable. Generics were added to the Java language for this reason — to
		 * enforce type safety at compile time.
		 */
	}

	
	
	public static void main(String[] args) {
		List<Integer> ll = new ArrayList<Integer>();
		ll.add(5);
		WildcardFixed obj = new WildcardFixed();
		obj.foo(ll);
	}
	
	
}
class WildcardFixed {

	void foo(List<?> i) {
		if (i instanceof Object) {
			System.out.println("object");
		}
		fooHelper(i);
	}

	// Helper method created so that the wildcard can be captured
	// through type inference.
	private <T> void fooHelper(List<T> l) {
		l.set(0, l.get(0));
	}

}