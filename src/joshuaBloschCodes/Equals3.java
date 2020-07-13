package joshuaBloschCodes;

public class Equals3 {
	private final int a, b;

	public Equals3(int a, int b) {
		this.a = a;
		this.b = b;
	}

	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o instanceof Equals3) {
			return a == ((Equals3) o).a && b == ((Equals3) o).b;
		}
		return false;
	}

	public static void main(String[] args) {
		Equals3 e = new Equals3(5, 6);
		Equals3 e1 = new Equals3(5, 6);
		Equals3 e2 = e;
		System.out.println(e1.equals(e)); // True!!!
		System.out.println(e.equals(e1)); // True!!!
		System.out.println(e.equals(e2)); // True
	}
}
