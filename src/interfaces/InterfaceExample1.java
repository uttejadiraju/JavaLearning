package interfaces;

abstract interface interFace1 {

	public void m2();

	public void m1(int x);

	int x = 5;
}

interface interFace2 {
	public void m2();

	public void m1();
}

class First1 implements interFace1, interFace2 { // Can contain single method if same method in both interfaces
	public void m2() {

	}

	public void m1() {

	}

	public void m1(int x) {

	}

	public void m1(float y) {

	}

}

public class InterfaceExample1 {

	public static void main(String[] args) {
		interFace1 i = new First1();
		int x = 5; // Local variable
		System.out.println(i.x);
	}
}
