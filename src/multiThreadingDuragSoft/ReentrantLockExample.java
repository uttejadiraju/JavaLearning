package multiThreadingDuragSoft;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockExample {
	public static void main(String[] args) {
		Displays d = new Displays();
		MyThreads m1 = new MyThreads(d, "uttej");
		MyThreads m2 = new MyThreads(d, "manoj");
		m1.start();
		m2.start();
	}
}

class Displays {
	ReentrantLock lock = new ReentrantLock();
	public void disp(String name) {
		lock.lock();
		for (int i = 0; i < 10; i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(name);
		}
		lock.unlock();
	}
}

class MyThreads extends Thread {
	Displays d;
	String name;

	public MyThreads(Displays d, String name) {
		this.d = d;
		this.name = name;
	}

	public void run() {
		d.disp(name);
	}
}