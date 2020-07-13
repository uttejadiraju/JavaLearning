package joshuaBloschMultiThreading;

public class ReentrantLockCustom {
	public static void main(String[] args) {
		MyReentrantLock LockCustom = new MyReentrantLock();
		ReentrantRunnable myRunnable = new ReentrantRunnable(LockCustom);
		new Thread(myRunnable, "Thread-1").start();
		new Thread(myRunnable, "Thread-2").start();
	}
}

interface customLock {
	public boolean tryLock();

	public void lock();

	public void unLock();
}

class MyReentrantLock implements customLock {
	int lockCount;
	long currentThreadId;

	public MyReentrantLock() {
		lockCount = 0;
	}

	@Override
	public synchronized boolean tryLock() {
		if (lockCount == 0) {
			lock();
			return true;
		}
		return false;
	}

	@Override
	public synchronized void lock() {
		if (lockCount == 0) {
			lockCount++;
			currentThreadId = Thread.currentThread().getId();
		} else if (lockCount > 0 && currentThreadId == Thread.currentThread().getId()) {
			lockCount++;
		} else {
			try {
				wait();
				lockCount++;
				currentThreadId = Thread.currentThread().getId();
			} catch (Exception e) {

			}
		}
	}

	@Override
	public synchronized void unLock() {
		if (lockCount == 0) {
			throw new IllegalMonitorStateException();
		} else {
			lockCount--;
			if (lockCount == 0) {
				notify();
			}
		}

	}

}

class ReentrantRunnable implements Runnable {
	customLock locking;

	public ReentrantRunnable(customLock locking) {
		this.locking = locking;
	}

	public void run() {
		System.out.println(Thread.currentThread().getName() + " is Waiting to acquire LockCustom");

		locking.lock();

		System.out.println(Thread.currentThread().getName() + " has acquired LockCustom.");

		try {
			Thread.sleep(5000);
			System.out.println(Thread.currentThread().getName() + " is sleeping.");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println(Thread.currentThread().getName() + " has released LockCustom.");

		locking.unLock();
	}
}