package innerClasses;

interface A {
	public void B();
	public void C();
}

public class AnonymousInterfaceImplementers {

	public static void main(String[] args) {
		
		A a = new A() {
			int v = 5;
			public void B() {
				System.out.println("A interface anonymous implementer");
				System.out.println(v);
			}
			public void C() {
				System.out.println("B interface anonymous implementer");
			}
		};
		a.B();
		a.C();
		
	}
}
