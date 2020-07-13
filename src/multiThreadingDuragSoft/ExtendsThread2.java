package multiThreadingDuragSoft;

class MyThread1 extends Thread {
	public void run() {
		System.out.println("run Thread");
	}

	public void start() {
		super.start();
		System.out.println("start method"); // Executed by main thread. Not by child thread
	}
}

public class ExtendsThread2 {
	public static void main(String[] args) {
		MyThread1 t = new MyThread1();
		t.start();

		System.out.println("Main Thread");
	}
}
