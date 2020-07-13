package multiThreadingDuragSoft;

public class VisiblityProblemEvenWithVolatile {
	class Counter {
		volatile int c = 0;

		public void increment(String thread) {
			c++;
			System.out.println(c + " by thread " + thread);
		}
	}

	public static void main(String[] args) throws InterruptedException {

		VisiblityProblemEvenWithVolatile v = new VisiblityProblemEvenWithVolatile();
		Counter obj = v.new Counter();
		Thread t1 = new Thread() {
			public void run() {
				obj.increment("Thread 1");
			}
		};

		Thread t2 = new Thread() {
			public void run() {
				obj.increment("Thread 2");
			}

		};
		t1.start();
		t2.start();
	}
}
/**
 * 2 by thread Thread 2 2 by thread Thread 1
 **/
/**
 * 1 by thread Thread 2 1 by thread Thread 1
 **/
