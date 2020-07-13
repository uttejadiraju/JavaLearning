package classes;

public class InheritanceExampleWithThis {
	public static void main(String args[]) {
		B b = new B();
	}
}

class A {
	public void Hello() {

	}
	
	private void helloPrivate() {
		
	}
}

class B extends A {
	B() {
		this.Hello();
	}
	
	B(int a){
		Hello();
	}
	
	public static void main(String args[]) {
	}
}
