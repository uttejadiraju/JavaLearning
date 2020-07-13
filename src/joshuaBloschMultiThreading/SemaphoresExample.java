package joshuaBloschMultiThreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class SemaphoresExample {
	private static Semaphore sem = new Semaphore(4);

	public static void main(String[] args) {
		ExecutorService exe = Executors.newFixedThreadPool(10);
		for (int i = 0; i < 100; i++) {
			Sem ob = new Sem(sem, String.valueOf(i));
			exe.submit(ob);
		}
		exe.shutdown();
	}
}

class Sem implements Runnable {
	Semaphore s;
	String name;

	public Sem(Semaphore s, String name) {
		this.s = s;
		this.name = name;
	}

	public void run() {
		try {
			s.acquire();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Semaphore acquired by thread " + name);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		s.release();
		System.out.println("================ =============== \n Semaphore released by thread " + name);
	}
}
