package joshuaBloschMultiThreading;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutorServiceThreads {
	public static void main(String[] args) {
		java.util.concurrent.ScheduledExecutorService exs = Executors.newScheduledThreadPool(10);
		exs.schedule(new Tasks("Once only Five Seconds delay"), 5, TimeUnit.SECONDS);
		exs.scheduleAtFixedRate((Runnable) new Tasks("Run repeatedly every 10 seconds"), 10, 10, TimeUnit.SECONDS);
		exs.scheduleWithFixedDelay((Runnable) new Tasks("Run repeatedly 10 seconds after previous tasks complete"), 15,
				10, TimeUnit.SECONDS);
	}
}

class Tasks implements Runnable {
	String x;

	Tasks(String x) {
		this.x = x;
	}

	@Override
	public void run() {
		System.out.println(x);
	}
}
