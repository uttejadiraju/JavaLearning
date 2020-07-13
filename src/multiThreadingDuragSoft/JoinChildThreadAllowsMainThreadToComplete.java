package multiThreadingDuragSoft;

class MyRunnableThread extends Thread {
	static Thread t;
	public void run() {
		try {
			t.join();
		} catch (InterruptedException e) {
			
		}
		for (int i = 0; i < 10; i++) {
			System.out.println("Child Thread");
		}
	}
}
public class JoinChildThreadAllowsMainThreadToComplete {

	public static void main(String[] args) throws InterruptedException {
		
		MyRunnableThread.t = Thread.currentThread();
		MyRunnableThread r = new MyRunnableThread();
		r.start();

		// Main completes & then child get chance.
		for (int i = 0; i < 10; i++) {
			System.out.println("Main Thread");
			Thread.sleep(10000);
		}
	}
}
