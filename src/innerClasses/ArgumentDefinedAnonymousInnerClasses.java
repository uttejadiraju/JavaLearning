package innerClasses;

public class ArgumentDefinedAnonymousInnerClasses {
	public static void main(String[] args) {
		BooImplementer b = new BooImplementer();
		b.Booos(new Boo() {
			public void B() {
				System.out.println("Implemented Boo method B inside anony inner class");
			}
		});
	}
}

interface Boo {
	public void B();
}

class BooImplementer {
	public void Booos(Boo b) {
		b.B();
	}
}