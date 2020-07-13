package exceptions;


public class FullyCheckedExceptionExample {
	public static void main(String[] args) throws Exception {
		try {
			System.out.println("hello");
		} catch (Exception e) {
			// valid
		}
		/**
		 * Fully checked exceptions must have logic to try to throw an exception in try
		 * block. Hence, invalid. Exception = Partially checked exception. Runtime &
		 * Error = unchecked exception.
		 * 
		 * 
		 */

		/**
		 * Invalid
		 * 
		 * try { System.out.println("hello"); } catch (IOException e) { // invalid } }
		 **/
	}
}
