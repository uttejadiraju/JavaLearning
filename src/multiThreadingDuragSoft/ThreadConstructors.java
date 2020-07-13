package multiThreadingDuragSoft;

class myRunnable1 implements Runnable {
	public void run() {
		System.out.println("Child thread");
	}
}

public class ThreadConstructors {
	public static void main(String[] args) throws InterruptedException {
		myRunnable1 r = new myRunnable1();
		Thread t = new Thread(r);
		t.start();
		Thread.sleep(1000);
		System.out.println(Thread.currentThread().getName());
		System.out.println(t.getName());
		System.out.println("Main thread");
	}
}
