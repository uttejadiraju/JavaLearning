package multiThreadingDuragSoft;

class MyThread2 extends Thread {
	public void run() {

		System.out.println("run Thread");
	}

	public void start() {
		super.start();
		System.out.println("start method"); // Executed by main thread. Not by child thread
	}
}

public class ExtendsThread3 {
	public static void main(String[] args) {
		MyThread2 t = new MyThread2();
		t.start();
		t.start(); // Exception. 

		System.out.println("Main Thread");
	}
}
