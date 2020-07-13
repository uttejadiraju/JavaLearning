package multiThreadingDuragSoft;

public class Interrupt {
	class myRunnable implements Runnable {
		public void run() {
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

	public static void main(String[] args) {
		myRunnable r = new Interrupt().new myRunnable();
		Thread t = new Thread(r);
		t.start();
		t.interrupt(); // Stops execution of child thread if the child is in "sleeping or waiting
						// state".
		for (int i = 0; i < 10; i++) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Main Thread");
		}
	}
}
