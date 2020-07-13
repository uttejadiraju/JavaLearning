package joshuaBloschMultiThreading;

public class LockOrderingDeadLock {
	private final Object left = new Object();
	private final Object right = new Object();

	public static void main(String[] args) {
		LockOrderingDeadLock obj = new LockOrderingDeadLock();
		Thread t = new Thread() {
			public void run() {
				obj.leftRight();
			}
		};
		Thread t1 = new Thread() {
			public void run() {
				obj.rightLeft();
			}
		};
		t.start();
		t1.start();

	}

	private void leftRight() {
		synchronized (left) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			synchronized (right) {
				System.out.println("Left right");
			}
		}
	}

	private void rightLeft() {
		synchronized (right) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			synchronized (left) {
				System.out.println("Right left");
			}
		}
	}
}
