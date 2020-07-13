package joshuaBloschMultiThreading;

import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorServiceThreads {
	public static void main(String[] args) {
		final long startTime = System.nanoTime();
		System.out.println(Runtime.getRuntime().availableProcessors());
		ExecutorService exs = Executors.newFixedThreadPool(5);
		ArrayList<Future<Integer>> futureList = new ArrayList<Future<Integer>>();
		for (int i = 1; i <= 100; i++) {
			Future<Integer> future = exs.submit(new Task(i * 10));
			futureList.add(future);
		}
		exs.shutdown();
		for (Future<Integer> f : futureList) {
			try {
				System.out.println(f.get());
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}
		}
		final long duration = System.nanoTime() - startTime;
		System.out.println(duration);
	}
}

class Task implements Callable<Integer> {
	int x;

	Task(int x) {
		this.x = x;
	}

	@Override
	public Integer call() throws Exception {
		int sum = 0;
		for (int i = 1; i <= x; i++) {
			sum = sum + i;
		}
		System.out.println(sum + " === " + sum);
		return sum;
	}
}
