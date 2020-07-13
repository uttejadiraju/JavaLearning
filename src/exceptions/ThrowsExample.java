package exceptions;

public class ThrowsExample {
	public static void main(String[] args) throws ArithmeticException {
//		try {
//			ThrowsExample t = new ThrowsExample();
//			t.m1();
//		} catch (InterruptedException e) {
//			System.out.println("Interupted exception");
//		} catch (Exception e) {
//			System.out.println("Exception");
//		}
		new ThrowsExample().m1();
	}


	public void m1() throws ArithmeticException {
		m2();
	}

	public void m2() throws ArithmeticException {
		System.out.println(10/0);
	}
}
