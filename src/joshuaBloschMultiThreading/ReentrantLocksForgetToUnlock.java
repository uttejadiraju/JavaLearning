package joshuaBloschMultiThreading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLocksForgetToUnlock {
	public static final Lock foreverLock = new ReentrantLock();

	public static void main(String[] args) throws InterruptedException {
		ReentrantLocksForgetToUnlock obj = new ReentrantLocksForgetToUnlock();
		ThreadLockForgot myThread = obj.new ThreadLockForgot();
		myThread.start();
		ThreadLockForgot myThread1 = obj.new ThreadLockForgot();
		myThread1.start();
	}

	class ThreadLockForgot extends Thread {
		public void run() {
			System.out.println("AQUIRING LOCK");
			foreverLock.lock();
			try {
				
			} finally {
				// Not leaving the lock!!!.
				// foreverLock.unlock();
			}
		}
	}
}
