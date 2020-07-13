package multiThreadingDuragSoft;

public class InterruptThreadItselfExplanation {
	public static void main(String[] args) {
		MyThread t = new MyThread();
		t.start();
		try {
			t.join();
			System.out.println("Hello!!!");
		} catch (Exception ex) {
			System.out.println("Now it works:");
			ex.printStackTrace();
		}
	}

	private static class MyThread extends Thread {

		private final Thread parentThread;

		public MyThread() {
			parentThread = Thread.currentThread();
		}

		@Override
		public void run() {
			parentThread.interrupt(); // Call on main thread!!!
		}
	}
}

/**
 * Thread.interrupt() does not throw any exceptions by itself. It does two
 * things: First it simply sets an internal interrupted-flag and then it checks
 * if the thread that it was called on is currently blocking on an activity like
 * wait(), sleep(), or join(). If it finds one, then it wakes up that method and
 * causes that method to throw the exception inside the thread it was called on
 * (not from).
 * 
 * In the case where you call interrupt() from the thread itself, that thread
 * obviously can't itself be currently blocking on one of those calls as it is
 * currently executing your interrupt() call. So, only the internal
 * interrupted-flag is set and no exception is thrown at all.
 * 
 * The next time you call one of the blocking methods (like sleep()
 * in @OldCurmudgeon's example) from that thread, that method will notice the
 * interrupted-flag and throw the InterruptedException.
 * 
 * If you don't ever call any of those methods, your thread will simply continue
 * running until it terminates some other way and will never throw an
 * InterruptedException. This is true even if you call interrupt() from a
 * different thread.
 * 
 * So, to notice that your thread has been interrupted, you either need to
 * frequently use one of the blocking methods that throws an
 * InterruptedException and then quit when you receive one of those exceptions,
 * or you need to frequently call Thread.interrupted() to check the internal
 * interrupted-flag yourself and quit if it ever returns true. But you are also
 * free to simply ignore the exception and the result from Thread.interrupted()
 * completely and keep the thread running. So, interrupt() might be a little bit
 * ambiguously named. It doesn't necessarily "interrupt" (as in "terminate") the
 * Thread at all, it simply sends a signal to the thread that the thread can
 * handle or ignore as it pleases. Much like a hardware interrupt signal on a
 * CPU (which is probably where the name comes from).
 **/	