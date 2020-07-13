package innerClasses;

public class OuterExample1 {
	class Inner {
		void method() {
			System.out.println("Inside inner class method");
		}
	}
	
	private void createInner() {
		Inner one = new Inner();
		one.method();
	}

	public static void main(String args[]) {
		OuterExample1 outer = new OuterExample1();
		Inner inner = outer.new Inner();
		/** or **/
		OuterExample1.Inner inner1 = outer.new Inner();

		/** or **/
		OuterExample1.Inner inner2 = new OuterExample1().new Inner();

		inner.method();
		inner1.method();
		inner2.method();
		
		outer.createInner();
	}
}
