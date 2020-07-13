package joshuaBloschMultiThreading;

interface ReadWriteLocks {

	public ReentrantReadWriteLocks.WriteLock writeLock();

	public ReentrantReadWriteLocks.ReadLock readLock();

}

class ReentrantReadWriteLocks implements ReadWriteLocks {

	// Variables to maintain read and write lock count.
	private int readLockCount;
	private int writeLockCount;

	/* Inner class providing readlock */
	private final ReentrantReadWriteLocks.ReadLock readerLock;

	/* Inner class providing writelock */
	private final ReentrantReadWriteLocks.WriteLock writerLock;

	public ReentrantReadWriteLocks.WriteLock writeLock() {
		return writerLock;
	}

	public ReentrantReadWriteLocks.ReadLock readLock() {
		return readerLock;
	}

	/**
	 * Constructor
	 */
	public ReentrantReadWriteLocks() {
		readerLock = new ReadLock();
		writerLock = new WriteLock();
	}

	/**
	 * More than one threads can acquire readLock at a time, provided no other
	 * thread is acquiring writeLock at same time.
	 */
	public class ReadLock {

		public synchronized void lock() {
			/*
			 * More than one threads can acquire readLock at a time, provided no other
			 * thread is acquiring writeLock at same time.
			 */
			if (writeLockCount == 0) {
				readLockCount++;
			}
			/*
			 * if some other thread is acquiring write lock at that time, than current
			 * thread waits.
			 */
			else {
				try {
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}

		public synchronized void unlock() {
			readLockCount--; // decrement readLockCount.

			/*
			 * If readLockCount has become 0, all threads waiting to write will be notified
			 * and can acquire lock.
			 */
			if (readLockCount == 0)
				notify();
		}

	}

	/**
	 * Only one threads can acquire writeLock at a time. Means writeLock can only be
	 * obtained if no other thread is acquiring read or write lock at that time.
	 */
	public class WriteLock {

		public synchronized void lock() {
			/*
			 * writeLock can only be obtained if no other thread is acquiring read or write
			 * lock at that time.
			 */
			if (writeLockCount == 0 && readLockCount == 0) {
				writeLockCount++;
			}
			/*
			 * if some other thread is acquiring read or write lock at that time, than
			 * current thread waits.
			 */
			else {
				try {
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}

		public synchronized void unlock() {
			writeLockCount--; // decrement writeLockCount.
			notify(); // notify all waiting threads.
		}

	}

}