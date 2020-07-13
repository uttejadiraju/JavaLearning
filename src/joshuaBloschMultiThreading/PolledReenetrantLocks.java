package joshuaBloschMultiThreading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PolledReenetrantLocks {
	private static Lock one = new ReentrantLock();
	private static Lock two = new ReentrantLock();

	public static void main(String[] args) {
		PolledReenetrantLocks obj = new PolledReenetrantLocks();
		ThreadLock my = obj.new ThreadLock();
		ThreadLock my2 = obj.new ThreadLock();
		my.setName("First");
		my2.setName("Second");
		my.start();
		my2.start();
	}

	class ThreadLock extends Thread {

		public void run() {
			one.lock();
			System.out.println("Lock one acquired by  " + Thread.currentThread().getName());
			try {
				try {
					two.lock();
					System.out.println("Lock two acquired by  " + Thread.currentThread().getName());
				} finally {
					System.out.println("Lock two released by  " + Thread.currentThread().getName());
					two.unlock();
				}
			} finally {
				System.out.println("Lock one released by  " + Thread.currentThread().getName());
				one.unlock();
			}
		}
	}

}

/***
 * Lock one acquired by Second Lock two acquired by Second Lock two released by
 * Second Lock one released by Second Lock one acquired by First Lock two
 * acquired by First Lock two released by First Lock one released by First
 * Note:- Output varies
 * 
 * A ReentrantLock is owned by the thread last successfully locking, but not yet
 * unlocking it. A thread invoking lock will return, successfully acquiring the
 * lock, when the lock is not owned by another thread. The method will return
 * immediately if the current thread already owns the lock.
 ***/
