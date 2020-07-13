package enums;

enum A {
	B("b", 1);
	public String name;
	private int number;

	A(String name, int number) {
		this.name = name;
		this.number = number;

	}

	public void print() {
		System.out.println(name + " " + number);
	}
}

public class Planet {
	public static void main(String[] args) {
		A.B.print();
	}
}