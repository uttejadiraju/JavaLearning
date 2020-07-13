package strings;

public class StringComparisonExamples {
	public static void main(String[] args) {
		// Strange example
		String str1 = "abc";
		String str2 = "ab";
		str2 = str2 + "c"; // Here new string object is created as "+" operator means contantination
							// (create new reference).
							// So, str2 is changed.
		System.out.println("str1 :" + str1 + ", str2 :" + str2);
		System.out.println(str1 == str2);
		System.out.println(str2.equals(str1));

		String s11 = "abc";
		// Once a string is created, it is
		// stored in the string pool. If another
		// string is about to be created, it is checked in the string pool.
		// If it exits, that reference is returned!!!. This can be applied for s2
		// instance of string.
		String s22 = "abc";
		String s33 = "abcd";
		System.out.println(s22 == s33);

		String s1 = "Rakesh"; // this always create a new String object on the heap and add "Rakesh" to the
								// pool(if not present).
		String s2 = "Rakesh";
		System.out.println("EQUAL!!!");
		System.out.println(s1 == s2);
		String s3 = "Rakesh".intern();
		String s4 = new String("Rakesh"); // the string "Rakesh" is created in the intern pool (if not already present)
											// and a copy of "Rakesh" is created out of intern pool
		String s5 = new String("Rakesh").intern();
		String s6 = new String("Rakesh").intern();// returns an intern copy of that string if present in the intern
													// pool. If not add that string to the intern pool and returns the
													// new copy.

		/**
		 * String intern method:- When the intern method is invoked, if the pool already
		 * contains a string equal to this String object as determined by the
		 * equals(Object) method, then the string from the pool is returned. Otherwise,
		 * this String object is added to the pool and a reference to this String object
		 * is returned. Note: to create a String and don't add it to the intern pool you
		 * can use an array of chars as parameter of String constructor: char[]
		 * helloArray = { 'h', 'e', 'l', 'l', 'o', '.' }; String helloString = new
		 * String(helloArray);
		 */

		/**
		 * When the intern() method is invoked on a String object it looks the string
		 * contained by this String object in the pool, if the string is found there
		 * then the string from the pool is returned. Otherwise, this String object is
		 * added to the pool and a reference to this String object is returned.
		 */

		if (s1 == s2) {
			System.out.println("s1 and s2 are same");
		}

		if (s1 == s3) {
			System.out.println("s1 and s3 are same");
		}

		if (s1 == s4) {
			System.out.println("s1 and s4 are same");
		}

		if (s1 == s5) {
			System.out.println("s1 and s5 are same");
		}

		System.out.println(s1 == s6);
		System.out.println(s5 == s6);

		// Memory calculations:-
		long beforeUsage = Runtime.getRuntime().freeMemory();
		System.out.println(beforeUsage + " before");

		String str = new String("manojeeee");
		long afterUsage = Runtime.getRuntime().freeMemory();
		System.out.println(afterUsage + " after");

	}
}
