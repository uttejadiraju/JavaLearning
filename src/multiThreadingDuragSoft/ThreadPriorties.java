package multiThreadingDuragSoft;

public class ThreadPriorties {
	class myRunnable1 implements Runnable {
		public void run() {
			for (int i = 0; i < 10; i++) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Child Thread");
			}
		}
	}

	public static void main(String[] args) {
		ThreadPriorties tp = new ThreadPriorties();
		myRunnable1 r = tp.new myRunnable1();
		Thread t = new Thread(r);
		t.setPriority(10);
		System.out.println(t.getPriority() + " Thread Priority Child");
		System.out.println(Thread.currentThread().getPriority() + " Thread Priority Parent");
		t.start();
		for (int i = 0; i < 10; i++) {
			System.out.println("Main Thread");
		}
	}
}

/**
 * Some OS may not give support for thread priority. Output can be inconsistent
 **/
