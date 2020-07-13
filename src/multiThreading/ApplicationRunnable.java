package multiThreading;

class Runner2 implements Runnable {
	public void run() {
		for (int i = 0; i <= 10; i++) {
			System.out.println("THREAD:-" + i);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

public class ApplicationRunnable {
	public static void main(String args[]) {
		Thread t = new Thread(new Runner2());
		t.start();
		
		Thread t1 = new Thread(new Runner2());
		t1.start();
	}
}