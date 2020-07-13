package multiThreadingDuragSoft;

class MyDaemonThread extends Thread {
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println("Child Thread");
			try {
				Thread.sleep(1000);

			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}
}

public class DaemonThread {

	public static void main(String[] args) throws InterruptedException {
		MyDaemonThread mdt = new MyDaemonThread();
		mdt.setDaemon(true);
		mdt.start();
		System.out.println("Main Thread");
	}
}

/*
 * Main thread is not daemon thread. Daemon threads add support to non daemon
 * threads. Daemon threads are killed once all non daemon threads are completed.
 * So, child may execute or may not executed completely. Once main completes,
 * child exits since it is daemon thread.
 ** 
 */
