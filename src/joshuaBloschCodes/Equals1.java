package joshuaBloschCodes;

public class Equals1 {
	private final int a, b;

	public Equals1(int a, int b) {
		this.a = a;
		this.b = b;
	}

	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		Equals1 e = new Equals1(5, 6);
		Equals1 e1 = new Equals1(5, 6);
		Equals1 e2 = e;
		System.out.println(e.equals(e1)); // False
		System.out.println(e.equals(e2)); // True
	}
}
