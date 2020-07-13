package joshuaBloschCodes;

public class GenericArrayCreationIllegal {
	public static void main(String[] args) {
		// // Why generic array creation is illegal - won't compile!
		// List<String>[] stringLists = new List<String>[1];
		// List<Integer> intList = new ArrayList<>();
		// intList.add(4);
		// Object[] objects = stringLists;
		// objects[0] = intList;
		// String s = stringLists[0].get(0);
	}
}

/***
 * Let’s pretend that line 1, which creates a generic array, is legal. Line 2
 * creates and initializes a List<Integer> containing a single element. Line 3
 * stores the List<String> array into an Object array variable, which is legal
 * because arrays are covariant. Line 4 stores the List<Integer> into the sole
 * element of the Object array, which succeeds because generics are implemented
 * by erasure: the runtime type of a List<Integer> instance is simply List, and
 * the runtime type of a List<String>[] instance is List[], so this assignment
 * doesn’t generate an ArrayStoreException. Now we’re in trouble. We’ve stored a
 * List<Integer> instance into an array that is declared to hold only
 * List<String> instances. In line 5, we retrieve the sole element from the sole
 * list in this array. The compiler automatically casts the retrieved element to
 * String, but it’s an Integer, so we get a ClassCastException at runtime. In
 * order to prevent this from happening, line 1 (which creates a generic array)
 * must generate a compile-time error.
 ***/

/***
 * In summary, arrays and generics have very different type rules. Arrays are
 * covariant and reified; generics are invariant and erased. As a consequence,
 * arrays provide runtime type safety but not compile-time type safety, and vice
 * versa for generics. As a rule, arrays and generics don’t mix well. If you
 * find yourself mixing them and getting compile-time errors or warnings, your
 * first impulse should be to replace the arrays with lists.
 ***/