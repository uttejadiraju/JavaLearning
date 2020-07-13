package innerClasses;

public class CreateInnerClassObjectWithInOuterClassMethods {
	private class Inner {
		private void B() {
			System.out.println("Inside method B of inner class");
		}
	}

	private void A() {
		Inner inner = new Inner();
		inner.B();
	}

	public static void main(String[] args) {
		CreateInnerClassObjectWithInOuterClassMethods obj = new CreateInnerClassObjectWithInOuterClassMethods();
		obj.A();
	}
}
