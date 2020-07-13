package exceptions;

public class ThrowsExample3 {
	public static void main(String[] args)  {
		try {
			ThrowsExample3 t = new ThrowsExample3();
			t.m1();
		} catch (ArithmeticException e) {
			System.out.println("ArithmeticException raised");
		}
	}


	public void m1() throws ArithmeticException {
		m2();
	}

	public void m2() throws ArithmeticException {
		throw new ArithmeticException();
	}
}
