package joshuaBloschMultiThreading;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteReentrantLockProgram {
	private static ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
	private static AtomicInteger  count = new AtomicInteger(0);

	public static void main(String[] args) {
		ReadWriteReentrantLockProgram obj = new ReadWriteReentrantLockProgram();
		ReadThread r = obj.new ReadThread();
		ReadThread r1 = obj.new ReadThread();
		WriteThread w = obj.new WriteThread();
		WriteThread w1 = obj.new WriteThread();
		r.setName("Read one");
		r1.setName("Read two");
		w.setName("Write one");
		w1.setName("Write two");
		r.start();
		r1.start();
		w.start();
		w1.start();
	}

	class ReadThread extends Thread {

		public void run() {
			readWriteLock.readLock().lock();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Reading threads!!!");
			readWriteLock.readLock().unlock();
		}
	}

	class WriteThread extends Thread {

		public void run() {
			readWriteLock.writeLock().lock();
			System.out.println("Writing threads!!!");
			readWriteLock.writeLock().unlock();
		}
	}

}
/**
 * 
 * Open Declaration java.util.concurrent.locks.ReadWriteLock
 * 
 * 
 * A ReadWriteLock maintains a pair of associated locks, one for read-only
 * operations and one for writing.The read lock may be held simultaneously
 * bymultiple reader threads, so long as there are no writers. The write lock is
 * exclusive.
 * 
 * All ReadWriteLock implementations must guarantee thatthe memory
 * synchronization effects of writeLock operations(as specified in the Lock
 * interface) also hold with respectto the associated readLock. That is, a
 * thread successfullyacquiring the read lock will see all updates made upon
 * previousrelease of the write lock.
 * 
 * A read-write lock allows for a greater level of concurrency inaccessing
 * shared data than that permitted by a mutual exclusion lock.It exploits the
 * fact that while only a single thread at a time (a writer thread) can modify
 * the shared data, in many cases anynumber of threads can concurrently read the
 * data (hence readerthreads).In theory, the increase in concurrency permitted
 * by the use of a read-writelock will lead to performance improvements over the
 * use of a mutualexclusion lock. In practice this increase in concurrency will
 * only be fullyrealized on a multi-processor, and then only if the access
 * patterns forthe shared data are suitable.
 * 
 * Whether or not a read-write lock will improve performance over the useof a
 * mutual exclusion lock depends on the frequency that the data isread compared
 * to being modified, the duration of the read and writeoperations, and the
 * contention for the data - that is, the number ofthreads that will try to read
 * or write the data at the same time.For example, a collection that is
 * initially populated with data andthereafter infrequently modified, while
 * being frequently searched(such as a directory of some kind) is an ideal
 * candidate for the use ofa read-write lock. However, if updates become
 * frequent then the dataspends most of its time being exclusively locked and
 * there is little, if anyincrease in concurrency. Further, if the read
 * operations are too shortthe overhead of the read-write lock implementation
 * (which is inherentlymore complex than a mutual exclusion lock) can dominate
 * the executioncost, particularly as many read-write lock implementations still
 * serializeall threads through a small section of code. Ultimately, only
 * profilingand measurement will establish whether the use of a read-write lock
 * issuitable for your application.
 * 
 * Although the basic operation of a read-write lock is straight-forward,there
 * are many policy decisions that an implementation must make, whichmay affect
 * the effectiveness of the read-write lock in a given application.Examples of
 * these policies include: •Determining whether to grant the read lock or the
 * write lock, whenboth readers and writers are waiting, at the time that a
 * writer releasesthe write lock. Writer preference is common, as writes are
 * expected to beshort and infrequent. Reader preference is less common as it
 * can lead tolengthy delays for a write if the readers are frequent and
 * long-lived asexpected. Fair, or "in-order" implementations are also possible.
 * •Determining whether readers that request the read lock while areader is
 * active and a writer is waiting, are granted the read lock.Preference to the
 * reader can delay the writer indefinitely, whilepreference to the writer can
 * reduce the potential for concurrency. •Determining whether the locks are
 * reentrant: can a thread with thewrite lock reacquire it? Can it acquire a
 * read lock while holding thewrite lock? Is the read lock itself reentrant?
 * •Can the write lock be downgraded to a read lock without allowingan
 * intervening writer? Can a read lock be upgraded to a write lock,in preference
 * to other waiting readers or writers? You should consider all of these things
 * when evaluating the suitabilityof a given implementation for your
 * application.Since:1.5Author:Doug LeaSee
 * Also:ReentrantReadWriteLockLockReentrantLock
 **/