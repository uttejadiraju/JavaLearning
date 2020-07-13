package object;

class Cat {
	int id;

	Cat(int id) {
		this.id = id;
	}
}

class Dog implements Cloneable {
	int num;
	Cat c;

	Dog(Cat c, int num) {
		this.num = num;
		this.c = c;
	}

	public Object clone() throws CloneNotSupportedException {
		Cat c1 = new Cat(c.id);
		Dog d2 = new Dog(c1, num);
		return d2;
	}
}

public class DeepCopy {
	public static void main(String[] args) throws CloneNotSupportedException {
		Cat cat = new Cat(5);
		Dog dog = new Dog(cat, 10);
		System.out.println(dog.c.id + " " + dog.num);

		Dog d2 = (Dog) dog.clone();
		d2.num = 15; // Primitive types no change.
		d2.c.id = 20; // Object types change!!!
		System.out.println(dog.c.id + " " + dog.num); // But values remain same!!!
	}

}
