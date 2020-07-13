package multiThreadingDuragSoft;

import java.util.concurrent.atomic.AtomicInteger;

public class VisiblityProblemSolvedWithAtomicVariables {
	class Counter {
		AtomicInteger c = new AtomicInteger(0);

		public void increment(String thread) {
			System.out.println(c.getAndIncrement() + " by thread" + thread);
		}
	}

	public static void main(String[] args) throws InterruptedException {

		VisiblityProblemSolvedWithAtomicVariables v = new VisiblityProblemSolvedWithAtomicVariables();
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
