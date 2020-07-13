package misc;

public class ChangeParentClassAccessModifierLevel {
	public static void main(String[] args) {
		Animal a = new Animal();
		Animal b = new Horse(); // Animal ref, but a Horse object
		a.eat(); // Runs the Animal version of eat()
		b.eat(); // Runs the Horse version of eat()
	}
}

class Animal {
	public void eat() {
		System.out.println("Generic Animal Eating Generically");
	}
}

class Horse extends Animal {
	/*
	 * private void eat() { // whoa! - it's private!
	 * System.out.println("Horse eating hay, oats, " +
	 * "and			// horse treats"); } } If this code compiled (which it doesn't),
	 * the following // would fail at runtime: }
	 */
}

/**
 * The variable b is of type Animal, which has a public eat() method. But
 * remember that at runtime, Java uses virtual method invocation to dynamically
 * select the actual version of the method that will run, based on the actual
 * instance. An Animal reference can always refer to a Horse instance, because
 * Horse IS-A(n) Animal. What makes that superclass reference to a subclass
 * instance possible is that the subclass is guaranteed to be able to do
 * everything the superclass can do. Whether the Horse instance overrides the
 * inherited methods of Animal or simply inherits them, anyone with an Animal
 * reference to a Horse instance is free to call all accessible Animal methods.
 * For that reason, an overriding method must fulfill the contract of the
 * superclass.
 **/