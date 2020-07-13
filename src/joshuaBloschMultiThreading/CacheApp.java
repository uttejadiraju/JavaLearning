package joshuaBloschMultiThreading;

import java.util.HashMap;
import java.util.Map;

class Cache implements Calc {

	@Override
	public int compute(int search) {

		System.out.println("Not Inside cache!!!" + search);
		return search;
	}
}

interface Calc {
	public int compute(int search);
}

class CacheData {
	private final Map<Integer, Integer> map = new HashMap<>();

	public synchronized int computeCache(int search) {
		if (map.get(search) == null) {
			map.put(search, c.compute(search));
			return map.get(search);
		}
		return map.get(search);
	}

	private Calc c;

	public CacheData(Calc c) {
		this.c = c;
	}
}

public class CacheApp {
	public static void main(String[] args) {
		
		Thread[] threads = new Thread[1000];
		CacheData cache = new CacheData(new Cache());
		
		for (int i = 0; i < threads.length; i++) {
			final int v = i;
			threads[i] = new Thread() {
				public void run() {
					cache.computeCache(v % 2);
				}
			};
			threads[i].start();
		}
	}
}
