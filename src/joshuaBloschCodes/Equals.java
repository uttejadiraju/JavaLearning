package joshuaBloschCodes;

public class Equals {
	private final int a, b;

	public Equals(int a, int b) {
		this.a = a;
		this.b = b;
	}

	public static void main(String[] args) {
		Equals e = new Equals(5, 6);
		Equals e1 = new Equals(5, 6);
		System.out.println(e.equals(e1)); // False
	}
}
