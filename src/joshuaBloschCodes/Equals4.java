package joshuaBloschCodes;

import java.util.HashMap;

public class Equals4 {
	private final int a, b;

	public Equals4(int a, int b) {
		this.a = a;
		this.b = b;
	}

	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o instanceof Equals4) {
			return a == ((Equals4) o).a && b == ((Equals4) o).b;
		}
		return false;
	}

	public static void main(String[] args) {
		Equals4 e = new Equals4(5, 6);
		Equals4 e1 = new Equals4(5, 6);
		Equals4 e2 = e;
		System.out.println(e.equals(e1)); // True!!!
		System.out.println(e.equals(e2)); // True
		HashMap<Integer, Integer> hp = new HashMap<Integer, Integer>();
		hp.put(new Integer(1), 5);
		System.out.println(hp.get(new Integer(1))); // 5!!!
	}
}
/**
 * HashMap.get(new Integer(1) works because, the integer class overrides the
 * hascode method. And always returns the value sent to the method as hash code
 * value
 */