package innerClasses;

public class MethodLocalInnerClassesVariables {
	int i = 0;

	public void outerClassMethod() { // Method inside method not possible in java. So, class inside method. !!!
		int x = 10;
		final int y = 60;
		class Inner {
			int z = 40;

			void method() {
				/** not valid. x = 5; n final or effective final permitted !!! From Java 8. **/
				System.out.println("method inside inner class inside method of outer class!!!");
				System.out.println(x);
				System.out.println(z);
				System.out.println(i);
				System.out.println(y);
			}
		}
		Inner i = new Inner();
		i.method();
	}

	public static void main(String args[]) {
		MethodLocalInnerClassesVariables outer = new MethodLocalInnerClassesVariables();
		outer.outerClassMethod();
	}
}
/** Outside method outerClassMethod(), we cannot access class Inner. **/
/**
 * However, the inner class object cannot use the local variables of the method
 * the inner class is in. Why not? Think about it. The local variables of the
 * method live on the stack and exist only for the lifetime of the method. You
 * already know that the scope of a local variable is limited to the method the
 * variable is declared in. When the method ends, the stack frame is blown away
 * and the variable is history. But even after the method completes, the inner
 * class object created within it might still be alive on the heap if, for
 * example, a reference to it was passed into some other code and then stored in
 * an instance variable. Because the local variables aren't guaranteed to be
 * alive as long as the method-local inner class object is, the inner class
 * object can't use them. Unless the local variables are marked final!
 **/
