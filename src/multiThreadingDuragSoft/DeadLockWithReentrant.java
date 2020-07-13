package multiThreadingDuragSoft;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DeadLockWithReentrant {
	private Lock a = new ReentrantLock();
	private Lock b = new ReentrantLock();

	public static void main(String[] args) {
		DeadLockWithReentrant d = new DeadLockWithReentrant();
		new Thread() {
			public void run() {
				d.executeThis();
			}
		}.start();

		new Thread() {
			public void run() {
				d.executeThat();
			}
		}.start();
		Thread t = new Thread() {
			public void run() {
				while (true) {
					if (detectLock()) {
						System.out.println("Dead lock found");
						break;
					}
				}

			}
		};
		t.setDaemon(true);
		t.start();
	}

	public void executeThis() {
		a.lock();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		b.lock();

		a.unlock();
		b.unlock();
	}

	public void executeThat() {
		b.lock();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		a.lock();

		b.unlock();
		a.unlock();
	}

	private static boolean detectLock() {
		ThreadMXBean bean = ManagementFactory.getThreadMXBean();
		long[] ids = bean.findDeadlockedThreads();
		return ids != null && ids.length > 0;
	}
}
