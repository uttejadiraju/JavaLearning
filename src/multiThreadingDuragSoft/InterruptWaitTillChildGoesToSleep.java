package multiThreadingDuragSoft;

public class InterruptWaitTillChildGoesToSleep {
	class myRunnable implements Runnable {
		public void run() {
			for (int i = 0; i < 10; i++) {
				System.out.println("I am Lazy Child Thread");
			}
			System.out.println("Child entering sleep state");
			try {
				for (int i = 0; i < 10; i++) {
					System.out.println("I am lazy child Thread");
					Thread.sleep(10000);
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				System.out.println("Child thread interrupted");
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {
		myRunnable r = new InterruptWaitTillChildGoesToSleep().new myRunnable();
		Thread t = new Thread(r);
		t.start();
		t.interrupt(); // Stops execution of child thread if the child is in sleeping or waiting state.
		for (int i = 0; i < 10; i++) {
			System.out.println("Main Thread");
		}
	}
}
