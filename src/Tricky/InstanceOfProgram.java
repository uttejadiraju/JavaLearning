package Tricky;

public class InstanceOfProgram {
	public static void main(String[] args) {
		A a = new A();
		B b = new B();
		A aa = new B();
		System.out.println(a instanceof Object);
		System.out.println(a instanceof B); // False !!!
		System.out.println(a instanceof A);
		
		
		System.out.println(b instanceof Object);
		System.out.println(b instanceof A);
		System.out.println(b instanceof B);
		
		System.out.println(aa instanceof Object);
		System.out.println(aa instanceof A);
		System.out.println(aa instanceof B);
		
		A aaa = new B();
		
		A aaaa = (A) aaa;
		
		B bbbb = (B) aaa;
		
	}
}

class A {
	
}

class B extends A {
	
}
