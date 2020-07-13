package exceptions;

public class TryCatch {
	public static void main(String[] args) {
		try {
			System.out.println(10/0);
		} catch (ArithmeticException e) {
			
		} catch (Exception e) {
			// catch (ArithmeticException() invalid.
		}
		
	}
}


/** try {
	}
	catch (child) {
	}
	catch (parent) {
	}
only valid
**/