package joshuaBloschCodes;

import java.util.HashMap;
import java.util.Objects;

public class Equals7 {
	private final String a, b;

	public Equals7(String a, String b) {
		this.a = a;
		this.b = b;
	}

	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o instanceof Equals7) {
			return a == ((Equals7) o).a && b == ((Equals7) o).b;
		}
		return false;
	}

	public int hashCode() {
		return Objects.hash(a, b);
	}

	public static void main(String[] args) {
		Equals7 e = new Equals7("a", "b");
		HashMap<Integer, Integer> hp = new HashMap<Integer, Integer>();
		hp.put(new Integer(1), 5);
		System.out.println(hp.get(new Integer(1))); // 5!!!
		HashMap<Equals7, Integer> map = new HashMap<Equals7, Integer>();
		map.put(new Equals7("a", "b"), 6);
		System.out.println(map.get(new Equals7("a", "b")));
		System.out.println(map.get(e));

	}
}
/**
 * HashMap.get(new Integer(1) works because, the integer class overrides the
 * hascode method. And always returns the value sent to the method as hash code
 * value. Equals7 also overrides hashCode, hence correct hashCodes are passed to
 * the hashmap.!!!
 */