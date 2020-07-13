package joshuaBloschMultiThreading;

import java.util.concurrent.*;

public class ThreadDeadlock {
	ExecutorService exec = Executors.newSingleThreadExecutor();

	public class LoadFileTask implements Callable<String> {
		private final String fileName;

		public LoadFileTask(String fileName) {
			this.fileName = fileName;
		}

		public String call() throws Exception {
			// Here's where we would actually read the file
			return "hero";
		}
	}

	public class RenderPageTask implements Callable<String> {
		public String call() throws Exception {
			Future<String> header, footer;
			header = exec.submit(new LoadFileTask("header.html"));
			footer = exec.submit(new LoadFileTask("footer.html"));
			String page = "  ";
			// Will deadlock -- task waiting for result of subtask
			return header.get() + page + footer.get();
		}

	}

	public void startThreadDeadlock() throws Exception {
		Future<String> wholePage = exec.submit(new RenderPageTask());
		System.out.println("Content of whole page is " + wholePage.get());
	}

	public static void main(String[] st) throws Exception {
		ThreadDeadlock tdl = new ThreadDeadlock();
		tdl.startThreadDeadlock();
	}
}

/**
 * Steps that leading to deadLock:
 * 
 * Task is submitted to exec for Rendering the page via Callable implemented
 * class RenderPageTask. exec started the RenderPageTask in separate Thread ,
 * the only Thread that would execute other tasks submitted to exec sequentially
 * . Inside call() method of RenderPageTask two more tasks are submitted to exec
 * . First is LoadFileTask("header.html") and second is
 * LoadFileTask("footer.html"). But since the the ExecutorService exec obtained
 * via code Executors.newSingleThreadExecutor(); as mentioned here uses a single
 * worker thread operating off an unbounded queueThread and the thread is
 * already allocated to RenderPageTask , So LoadFileTask("header.html") and
 * LoadFileTask("footer.html") will be en queued to the unbounded queue waiting
 * for there turn to be executed by that Thread. RenderPageTask is returning a
 * String containing the concatenation of output of LoadFileTask("header.html")
 * , body of page and output of LoadFileTask("footer.html"). Out of these three
 * parts page is obtained successfully by RenderPageTask . But other two parts
 * can only be obtained after both tasks are executed by the single Thread
 * allocated by ExecutorService . And Thread will be free only after call()
 * method of RenderPageTask returns . But call method of RenderPageTask will
 * return only after LoadFileTask("header.html") and LoadFileTask("footer.html")
 * is returned. So Not letting LoadFileTask to execute is leading to Starvation
 * . And each task waiting for other task for completion is leading to DeadLock
 * 
 * I hope this makes clear of why thread starvation deadlock is occurring in
 * above code.
 *
 **/