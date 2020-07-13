package multiThreadingDuragSoft;

public class VisiblityProblemSolved {
	class Counter {
		int c = 1;

		public synchronized void increment(String thread) {
			c++;
			System.out.println(c + " by thread " + thread);
		}
	}

	public static void main(String[] args) throws InterruptedException {

		VisiblityProblemSolved v = new VisiblityProblemSolved();
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
