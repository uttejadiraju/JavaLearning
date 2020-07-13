package innerClasses;

class Person {
	public void taste() {
		System.out.println("Bitter");
	}
}

public class AnonymousClass {
	public static void main(String[] args) {
		Person p = new Person() {
			public void taste() {
				System.out.println("Sour");
			}
		};
		p.taste();
		System.out.println(p.getClass().getName());
	}
}
