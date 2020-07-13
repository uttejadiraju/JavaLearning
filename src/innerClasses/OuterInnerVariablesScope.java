package innerClasses;

import static java.lang.System.*;

public class OuterInnerVariablesScope {
	private int x = 10;
	private int q = 50;

	class Inner {
		private int x = 100;
		private static final int v = 100; // Only static final allowed!!!

		void method() {
			int x = 100;
			System.out.println(x); // Local x.
			System.out.println(Inner.this.x); // Inner class object x value.
			out.println(OuterInnerVariablesScope.this.x); // Outer class object x value.
			out.println(this.x); // Inner class object x value. same as Inner.this.x
			out.println(q);
		}
	}

	public static void main(String args[]) {
		OuterInnerVariablesScope outer = new OuterInnerVariablesScope();
		Inner inner = outer.new Inner();
		inner.method();
	}
}

/***
 * I guess it's for consistency. While there doesn't seem to be any technical
 * limitation for it, you wouldn't be able to access static members of the
 * internal class from the outside, i.e. OuterClass.InnerClass.i because the
 * middle step is not static.
 ***/
