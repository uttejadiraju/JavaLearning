package joshuaBloschMultiThreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExecutorServiceThreadInterrupt {
	public static void main(String[] args) {
		System.out.println(Runtime.getRuntime().availableProcessors());
		ExecutorService exs = Executors.newFixedThreadPool(5);
		for (int i = 1; i <= 100000; i++) {
			exs.submit(new TaskIn(i));
		}
		System.out.println("Trying to shutting down!!!");
		exs.shutdown(); // Disable new tasks from being submitted
		System.out.println("Shutting down!!!");
		try {
			// Wait a while for existing tasks to terminate
			if (!exs.awaitTermination(60, TimeUnit.SECONDS)) {
				exs.shutdownNow(); // Cancel currently executing tasks
				// Wait a while for tasks to respond to being cancelled
				if (!exs.awaitTermination(60, TimeUnit.SECONDS))
					System.err.println("exs did not terminate");
			}
		} catch (InterruptedException ie) {
			// (Re-)Cancel if current thread also interrupted
			exs.shutdownNow();
			// Preserve interrupt status
			Thread.currentThread().interrupt();
		}
	}
}

class TaskIn implements Runnable {
	int x;

	TaskIn(int x) {
		this.x = x;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			int sum = 0;
			for (int i = 1; i <= x; i++) {
				sum = sum + i;
			}
			Thread.sleep(10);
			System.out.println(x);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

		}
	}
}
