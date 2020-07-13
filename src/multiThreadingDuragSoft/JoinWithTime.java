package multiThreadingDuragSoft;

public class JoinWithTime {
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
		myRunnable r = new JoinWithTime().new myRunnable();
		Thread t = new Thread(r);
		t.start();

		t.join(10000); // Called by main thread. Waits only for 10000 milliseconds & control goest to main thread.

		for (int i = 0; i < 10; i++) {
			System.out.println("Main Thread");
		}
	}
}
