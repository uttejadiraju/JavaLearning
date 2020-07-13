package misc;

public class MethodOverloading {
	public void doStuff(Hor h) {
		System.out.println("In the Horse version");
	}

	public void doStuff(Ani h) {
		System.out.println("In the Animal version");
	}

	public static void main(String[] args) {
		MethodOverloading ua = new MethodOverloading();
		Ani animalObj = new Ani();
		Hor horseObj = new Hor();
		Ani aniHor = new Hor();
		ua.doStuff(animalObj);
		ua.doStuff(horseObj);
		ua.doStuff(aniHor);
	}
}

class Ani {
}

class Hor extends Ani {
}