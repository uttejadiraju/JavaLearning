package multiThreadingDuragSoft;

public class Join {
	class myRunnable implements Runnable {
		public void run() {
			for (int i = 0; i < 10; i++) {
				System.out.println("Child Thread");
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {
		myRunnable r = new Join().new myRunnable();
		Thread t = new Thread(r);
		t.start();

		t.join(); // Called by main thread. Waits till thread t completes.

		for (int i = 0; i < 10; i++) {
			System.out.println("Main Thread");
		}
	}
}