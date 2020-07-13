package multiThreadingDuragSoft;

public class Yield {
	class myRunnable implements Runnable {
		public void run() {
			for (int i = 0; i < 10; i++) {
				System.out.println("Child Thread");
				Thread.yield(); // Leaves processor. Goes to waiting state, if another thread is found with same
								// priority.
			}
		}
	}

	public static void main(String[] args) {
		myRunnable r = new Yield().new myRunnable();
		Thread t = new Thread(r);
		t.start();
		for (int i = 0; i < 10; i++) {
			System.out.println("Main Thread");
		}
	}
}
