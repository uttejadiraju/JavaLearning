package misc;

public class IllegalInheritance {
	public static void main(String[] args) {
		Horses h = new Horses();
		// h.eat(); // Not legal because Horse didn't inherit eat()
	}
}

class Animals {
	private void eat() {
		System.out.println("Generic Animal");
	}
}

class Horses extends Animals {
}