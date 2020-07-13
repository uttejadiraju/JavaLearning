package innerClasses;

public class OuterExample {
	class Inner {
		void method() {
			System.out.println("Inside inner class method");
		}
	}

	public static void main(String args[]) {
		OuterExample outer = new OuterExample();
		Inner inner = outer.new Inner();
		/** or **/
		OuterExample.Inner inner1 = outer.new Inner();

		/** or **/
		OuterExample.Inner inner2 = new OuterExample().new Inner();

		inner.method();
		inner1.method();
		inner2.method();
	}
}
