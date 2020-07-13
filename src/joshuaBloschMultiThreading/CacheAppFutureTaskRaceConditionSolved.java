package joshuaBloschMultiThreading;

import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

class Cache11 implements Calc11 {

	@Override
	public int compute(int search) {
		System.out.println("Not Inside cache!!!" + search);
		return search;
	}
}

interface Calc11 {
	public int compute(int search);
}

class CacheData11 {
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private final Map<Integer, Future<Integer>> map = new ConcurrentHashMap();

	public int computeCache(int search) throws InterruptedException, ExecutionException {
		Future<Integer> f = map.get(search);
		if (f == null) {
			Callable<Integer> callable = new Callable<Integer>() {
				public Integer call() {
					return c.compute(search);
				}
			};
			FutureTask<Integer> futureTask = new FutureTask<Integer>(callable);
			f = map.putIfAbsent(search, futureTask);
			if (f == null) {
				f = futureTask;
				futureTask.run();
			}
		}
		return f.get();
	}

	private Calc11 c;

	public CacheData11(Calc11 c) {
		this.c = c;
	}
}

public class CacheAppFutureTaskRaceConditionSolved {
	public static void main(String[] args) {

		Thread[] threads = new Thread[1000];
		CacheData11 cache = new CacheData11(new Cache11());

		for (int i = 0; i < threads.length; i++) {
			final int v = i;
			threads[i] = new Thread() {
				public void run() {
					try {
						cache.computeCache(v % 2);
					} catch (InterruptedException | ExecutionException e) {
						e.printStackTrace();
					}
				}
			};
			threads[i].start();
		}
	}
}
