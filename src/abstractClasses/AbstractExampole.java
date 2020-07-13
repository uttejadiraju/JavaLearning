package abstractClasses;


abstract class P {
	protected abstract void m1();

	public abstract void m2();

	static void m9() {
		System.out.println("m9 inside P");
	}

	public final void m5() {
		System.out.println("Abstract class can contain final method");
	}

	public void m6() {
		System.out.println("Inside P m6");
	}

	public void m3() {
		System.out.println("Inside P m3");
	}
	
	public abstract void m11();
}

abstract class E extends P {
	public void m2() {
		System.out.println("Inside E m2");
	}
	
	protected void m1() {
		System.out.println("Inside E m1");
	}

}

class Z extends E {

	public void m3() {
		System.out.println("Inside Z m3");
	}

	@Override
	protected void m1() {
		// TODO Auto-generated method stub
		System.out.println("Inside Z m1");

	}
	
	public void m11() {
		
	}

}

public class AbstractExampole {
	public static void main(String[] args) {
		E z = new Z();
		z.m1();
		z.m2();
		z.m5();
		z.m3();
		z.m6();
		P.m9();
		z.m9();

		Z z1 = new Z();
		z1.m11(); // Possible. Not for z.m1()
	}

	public void m1() {

	}
}
