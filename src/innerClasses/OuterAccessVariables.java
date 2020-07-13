package innerClasses;

public class OuterAccessVariables {
	private class Inner {
		private int x = 10;
		static final int y = 10; // Only static final permitted.!!!

		void method() {
			System.out.println(x + " " + y);
		}
	}

	public static void main(String args[]) {
		OuterAccessVariables outer = new OuterAccessVariables();
		Inner inner = outer.new Inner();
		inner.method();
	}
}

/***
 * If you declare a member class that does not require access to an enclosing
 * instance, always put the static modifier in its declaration, making it a
 * static rather than a nonstatic member class. If you omit this modifier, each
 * instance will have a hidden extraneous reference to its enclosing instance.
 * As previously mentioned, storing this reference takes time and space. More
 * seriously, it can result in the enclosing instance being retained when it
 * would otherwise be eligible for garbage collection (Item 7). The resulting
 * memory leak can be catastrophic. It is often difficult to detect because the
 * reference is invisible.
 ***/