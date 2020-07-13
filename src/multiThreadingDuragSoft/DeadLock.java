package multiThreadingDuragSoft;

class DeadLockThread extends Thread {

	static Thread t;

	public DeadLockThread() {
		t = Thread.currentThread();
	}

	public void run() {
		try {
			t.join(); // Child thread calls join. So child waits till main completes.
		} catch (InterruptedException e) {

		}
		for (int i = 0; i < 10; i++) {
			System.out.println("Child Thread");
		}
	}
}

public class DeadLock {

	public static void main(String[] args) throws InterruptedException {
		DeadLockThread r = new DeadLockThread();
		r.start();
		r.join(); // Main thread calls join. So main waits till child completes.

		// Main completes & then child get chance.
		for (int i = 0; i < 10; i++) {
			System.out.println("Main Thread");
			Thread.sleep(10000);
		}
	}
}

/** This code runs forever **/
