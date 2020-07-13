package joshuaBloschCodes;

import java.util.HashMap;

public class Equals5 {
	private final int a, b;

	public Equals5(int a, int b) {
		this.a = a;
		this.b = b;
	}

	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o instanceof Equals5) {
			return a == ((Equals5) o).a && b == ((Equals5) o).b;
		}
		return false;
	}

	public static void main(String[] args) {
		Equals5 e = new Equals5(5, 6);
		Equals5 e1 = new Equals5(5, 6);
		Equals5 e2 = e;
		System.out.println(e.equals(e1)); // True!!!
		System.out.println(e.equals(e2)); // True
		HashMap<Integer, Integer> hp = new HashMap<Integer, Integer>();
		hp.put(new Integer(1), 5);
		System.out.println(hp.get(new Integer(1))); // 5!!!
		HashMap<Equals5, Integer> map = new HashMap<Equals5, Integer>();
		map.put(new Equals5(5, 6), 6);
		System.out.println(map.get(new Equals(5, 6))); // Null!!!
		System.out.println(map.get(e)); // Null!!!

	}
}
/**
 * HashMap.get(new Integer(1) works because, the integer class overrides the
 * hascode method. And always returns the value sent to the method as hash code
 * value. But, Equals5 dosen't override hashcode. Hence, null values are
 * returned.!!!
 */