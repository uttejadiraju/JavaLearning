package exceptions;

public class ThrowsExample2 {
	public static void main(String[] args)  {
		try {
			ThrowsExample2 t = new ThrowsExample2();
			t.m1();
		} catch (ArithmeticException e) {
			System.out.println("ArithmeticException raised");
		} catch (Exception e) {
			System.out.println("Exception raised");
		}
	}


	public void m1() throws ArithmeticException {
		m2();
	}

	public void m2() throws ArithmeticException {
		System.out.println(10/0);
	}
}
