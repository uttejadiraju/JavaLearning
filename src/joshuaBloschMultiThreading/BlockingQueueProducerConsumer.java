package joshuaBloschMultiThreading;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueProducerConsumer {
	public static void main(String[] args) {
		BlockingQueue<Integer> bq = new ArrayBlockingQueue<>(5);
		Thread t = new Thread() {
			public void run() {
				produce(bq);
			}
		};
		
		Thread t1 = new Thread() {
			public void run() {
				consume(bq);
			}
		};

		t1.start();
		t.start();
	}

	private static void produce(BlockingQueue<Integer> bq) {
		for (int i = 0; i < 100; i++) {
			try {
				System.out.println("Producing value!!!");
				bq.put(i);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	private static void consume(BlockingQueue<Integer> bq) {
		while (true) {
			try {
				System.out.println("Consuming value!!!");
				System.out.println(bq.take());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
