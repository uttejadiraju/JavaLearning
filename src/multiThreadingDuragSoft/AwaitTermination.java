package multiThreadingDuragSoft;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class AwaitTermination {
	public static void main(String[] args) {
		ExecutorService exe = Executors.newFixedThreadPool(5);
		for (int i = 0; i < 100; i++) {
			exe.submit(new ThreadT(String.valueOf(i)));
		}
		System.out.println("Trying to shutdown!!!");
		exe.shutdown();
		try {
			if (!exe.awaitTermination(5, TimeUnit.SECONDS)) {
				exe.shutdownNow();
			}
		} catch (InterruptedException ex) {
		}
	}
}

class ThreadT extends Thread {
	public ThreadT(String name) {
		super(name);
	}

	public void run() {
		try {
			System.out.println(Thread.currentThread().getName() + "started!!!");
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
