package joshuaBloschMultiThreading;

import java.util.Date;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierThreads {
	private static CyclicBarrier cb = new CyclicBarrier(3);

	public static void main(String[] args) {
		ServiceOne ser1 = new ServiceOne(cb);
		ServiceTwo ser2 = new ServiceTwo(cb);
		Thread t1 = new Thread(ser1);
		Thread t2 = new Thread(ser2);
		System.out.println("Starting both the services at" + new Date());
		t1.start();
		t2.start();
		try {
			cb.await();
		} catch (InterruptedException e) {
			System.out.println("Main Thread interrupted!");
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			System.out.println("Main Thread interrupted!");
			e.printStackTrace();
		}
		System.out.println("Ending both the services at" + new Date());
	}
}

class ServiceOne implements Runnable {
	CyclicBarrier cb;

	public ServiceOne(CyclicBarrier cb) {
		this.cb = cb;
	}

	public void run() {
		System.out.println("Waiting for other threads to start!!! --- service one");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			cb.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			e.printStackTrace();
		}
		System.out.println("Waiting completed i am finished --- service one");
	}

}

class ServiceTwo implements Runnable {
	CyclicBarrier cb;

	public ServiceTwo(CyclicBarrier cb) {
		this.cb = cb;
	}

	public void run() {
		System.out.println("Waiting for other threads to start!!! --- service two");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			cb.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			e.printStackTrace();
		}
		System.out.println("Waiting completed i am finished --- service two");
	}

}
