package innerClasses;

public class Outer {
	class Inner {
		/**
		 * The method v cannot be declared static; static methods can only be declared in a static or top level type
		 */
//		static void v() {
//			
//		}
	}
	public static void main(String[] args) {
		System.out.println("Inside outer class");
	}
}
