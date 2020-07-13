package joshuaBloschMultiThreading;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class UnmodifiableMap {
	public static void main(String[] args) {
		Map<Integer, Integer> map = getImmutable();
		map.put(5, 6);
	}
	private static Map<Integer, Integer> getImmutable() {
		HashMap<Integer,Integer> hp = new HashMap<>();
		return Collections.unmodifiableMap(hp);
	}
}
