package innerClasses;

public class MethodLocalInnerClasses {
	public void outerClassMethod() { // Method inside method not possible in java. So, class inside method. !!!
		class Inner {
			void method() {
				System.out.println("method inside inner class inside method of outer class!!!");
			}
		}
		Inner i = new Inner();
		i.method();
	}

	public static void main(String args[]) {
		MethodLocalInnerClasses outer = new MethodLocalInnerClasses();
		outer.outerClassMethod();
	}
}
/** Outside method outerClassMethod(), we cannot access class Inner. **/
