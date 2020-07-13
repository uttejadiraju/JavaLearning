package multiThreadingDuragSoft;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceExample {
	public static void main(String[] args) {
		PrintJob[] prints = { new PrintJob("uttej"), new PrintJob("manoj"), new PrintJob("pabba"),
				new PrintJob("vamshi"), new PrintJob("balu"), new PrintJob("srinivas"), new PrintJob("uttej"), new PrintJob("manoj"), new PrintJob("pabba"),
				new PrintJob("vamshi"), new PrintJob("balu"), new PrintJob("srinivas"),new PrintJob("uttej"), new PrintJob("manoj"), new PrintJob("pabba"),
				new PrintJob("vamshi"), new PrintJob("balu"), new PrintJob("srinivas"), new PrintJob("uttej"), new PrintJob("manoj"), new PrintJob("pabba"),
				new PrintJob("vamshi"), new PrintJob("balu"), new PrintJob("srinivas"),new PrintJob("uttej"), new PrintJob("manoj"), new PrintJob("pabba"),
				new PrintJob("vamshi"), new PrintJob("balu"), new PrintJob("srinivas"), new PrintJob("uttej"), new PrintJob("manoj"), new PrintJob("pabba"),
				new PrintJob("vamshi"), new PrintJob("balu"), new PrintJob("srinivas"),new PrintJob("uttej"), new PrintJob("manoj"), new PrintJob("pabba"),
				new PrintJob("vamshi"), new PrintJob("balu"), new PrintJob("srinivas"), new PrintJob("uttej"), new PrintJob("manoj"), new PrintJob("pabba"),
				new PrintJob("vamshi"), new PrintJob("balu"), new PrintJob("srinivas") };
		System.out.println(prints.length);
		ExecutorService exe = Executors.newFixedThreadPool(40);
		System.out.println(Runtime.getRuntime().availableProcessors());
		for (PrintJob p : prints) {
			exe.submit(p);
		}
		exe.shutdown();
	}
}

class PrintJob implements Runnable {

	String name;

	PrintJob(String name) {
		this.name = name;
	}

	@Override
	public void run() {
		System.out.println(name + " job started by thread" + Thread.currentThread().getName());
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {

		}
		System.out.println();
		System.out.println(name + " job completed by thread " + Thread.currentThread().getName());
	}

}