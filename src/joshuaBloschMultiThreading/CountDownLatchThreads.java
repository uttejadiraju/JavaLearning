package joshuaBloschMultiThreading;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchThreads {
	public static void main(String args[]) throws InterruptedException {
		CountDownLatch latch = new CountDownLatch(4);
		Worker first = new Worker(latch, "WORKER-1");
		Worker second = new Worker(latch, "WORKER-2");
		Worker third = new Worker(latch, "WORKER-3");
		Worker fourth = new Worker(latch, "WORKER-4");
		first.start();
		second.start();
		third.start();
		fourth.start();

		latch.await();
		System.out.println("hero");
	}
}

class Worker extends Thread {
	private CountDownLatch latch;

	public Worker(CountDownLatch latch, String name) {
		super(name);
		this.latch = latch;
	}

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + " finished");
		latch.countDown();
	}
}