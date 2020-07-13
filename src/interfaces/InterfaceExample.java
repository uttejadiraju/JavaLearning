package interfaces;

interface interFace {
	abstract public void m1(); // Always abstract public

	public void m2(); // Accepted. Also void m2();

	int x = 5; // Always public static final
}

abstract class First implements interFace {
	public void m1() {

	}
}

class Second extends First {
	public void m2() {

	}
}

public class InterfaceExample {

	public static void main(String[] args) {
		interFace i = new Second();
		int x  = 5; // Local variable
		System.out.println(i.x);
	}
}
