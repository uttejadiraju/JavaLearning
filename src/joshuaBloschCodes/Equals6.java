package joshuaBloschCodes;

import java.util.HashMap;
import java.util.Objects;

public class Equals6 {
	private final int a, b;

	public Equals6(int a, int b) {
		this.a = a;
		this.b = b;
	}

	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o instanceof Equals6) {
			return a == ((Equals6) o).a && b == ((Equals6) o).b;
		}
		return false;
	}

	public int hashCode() {
		return a + b;
	}

	public static void main(String[] args) {
		Equals6 e = new Equals6(5, 6);
		Equals6 e1 = new Equals6(5, 6);
		Equals6 e2 = e;
		System.out.println(e.equals(e1)); // True!!!
		System.out.println(e.equals(e2)); // True
		HashMap<Integer, Integer> hp = new HashMap<Integer, Integer>();
		hp.put(new Integer(1), 5);
		System.out.println(hp.get(new Integer(1))); // 5!!!
		HashMap<Equals6, Integer> map = new HashMap<Equals6, Integer>();
		map.put(new Equals6(5, 6), 6);
		System.out.println(map.get(e)); // 6!!!
		System.out.println(map.get(new Equals6(5, 6))); // 6!!!

	}
}
/**
 * HashMap.get(new Integer(1) works because, the integer class overrides the
 * hascode method. And always returns the value sent to the method as hash code
 * value. But, Equals5 dosen't override hashcode. Hence, null values are
 * returned.!!!
 */