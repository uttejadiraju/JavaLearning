package multiThreadingDuragSoft;

class myRunnableThreads implements Runnable {
	public void run() {
		System.out.println("run Thread");
	}
}

public class RunnableThread {
	public static void main(String[] args) {
		myRunnableThreads r = new myRunnableThreads();
		Thread t = new Thread(r);
		Thread t1 = new Thread();
		t.start(); // New thread created. But empty output since thread class run has empty implementation
		System.out.println("Main thread");
		t.run(); // No new thread. myRunnable class run method executed.
		// r.start(); Error.
		r.run(); // Like normal method. 
		t1.start(); // creates a thread. And calls run method.
		t1.run(); // Like normal method. No thread created.
	}
}
