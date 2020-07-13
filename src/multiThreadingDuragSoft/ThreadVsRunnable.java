package multiThreadingDuragSoft;

class ImplementsRunnable implements Runnable {

	private int counter = 0;

	public void run() {
		counter++;
		System.out.println("ImplementsRunnable : Counter : " + counter);
	}
}

// Extend Thread class...
class ExtendsThreads extends Thread {

	private int counter = 0;

	public void run() {
		counter++;
		System.out.println("ExtendsThreads : Counter : " + counter);
	}
}

// Use the above classes here in main to understand the differences more
// clearly...
public class ThreadVsRunnable {

	public static void main(String args[]) throws Exception {
		// Multiple threads share the same object.
		ImplementsRunnable rc = new ImplementsRunnable();
		Thread t1 = new Thread(rc);
		t1.start();
		Thread.sleep(1000); // Waiting for 1 second before starting next thread
		Thread t2 = new Thread(rc);
		t2.start();
		Thread.sleep(1000); // Waiting for 1 second before starting next thread
		Thread t3 = new Thread(rc);
		t3.start();

		// Creating new instance for every thread access.
		ExtendsThreads tc1 = new ExtendsThreads();
		tc1.start();
		Thread.sleep(1000); // Waiting for 1 second before starting next thread
		ExtendsThreads tc2 = new ExtendsThreads();
		tc2.start();
		Thread.sleep(1000); // Waiting for 1 second before starting next thread
		ExtendsThreads tc3 = new ExtendsThreads();
		tc3.start();
	}
}