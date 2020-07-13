package wrapperClasses;

public class AutoBoxing {
	public static void main(String args[]) {
		int i = 10;
		Integer I = i; // Internally, Integer I = Integer.valueOf(i);
		System.out.println(I);

		Integer Y = 10;
		/**
		 * !!! It's true. Since. JVM maintains buffer for wrapper classes like Integer,
		 * Character, Byte, Long, Short. IF value exists in buffer, then no new object
		 * created!!!
		 **/
		System.out.println(I == Y); // True.

		Integer Z = 1000;
		Integer W = 1000;
		System.out.println(Z == W); // Out of range in buffer. New object created.
		System.out.println(Z.equals(W));
	}
}
