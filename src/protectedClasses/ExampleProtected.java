package protectedClasses;

class P {
	void m1() {
		
	}
	
	protected void m2() {
		// Can be accessed with both parent & child reference in current package.
		// But if outside, only child reference needed!!!.
	}
	
	public void m3() {
		System.out.println("m3 inside P");
	}
}

class C extends P {
	public void m3(int x) {
		System.out.println("m3 inside C");
	}
	
	public void m5() {
		System.out.println("m5 inside C");
	}
	
	public void m3() {
		System.out.println("m3 inside C");
	}
}
public class ExampleProtected {
	public static void main(String[] args) {
		P p = new P();
		p.m1();
		p.m2();
		p.m3();
		
		C c = new C();
		c.m1();
		c.m2();
		c.m3();
		c.m3(1);
		c.m5();
		
		P pc = new C();
		pc.m1();
		pc.m2();
		pc.m3();
		/** pc.m5(); **/ // Only methods of type P possible possible!!!
	}
}
