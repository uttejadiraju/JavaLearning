package joshuaBloschMultiThreading;

import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

class Cache1 implements Calc1 {

	@Override
	public int compute(int search) {

		System.out.println("Not Inside cache!!!" + search);
		return search;
	}
}

interface Calc1 {
	public int compute(int search);
}

class CacheData1 {
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
			f = futureTask;
			map.put(search, futureTask);
			futureTask.run();
		}
		return f.get();
	}

	private Calc1 c;

	public CacheData1(Calc1 c) {
		this.c = c;
	}
}

public class CacheAppFutureTaskRaceCondition {
	public static void main(String[] args) {

		Thread[] threads = new Thread[1000];
		CacheData1 cache = new CacheData1(new Cache1());

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
