package exceptions;

public class CheckedExceptionExample {
	public static void main(String[] args) throws Exception  {
		throw new Exception(); // Checked exceptions must be thrown or handled with try/catch.
	}
}
