package joshuaBloschMultiThreading;

public class LockOrderingDeadLockSolved {
	private final Object left = new Object();
	private final Object right = new Object();
	private final Object tieLock = new Object();

	public static void main(String[] args) {

		LockOrderingDeadLockSolved obj = new LockOrderingDeadLockSolved();
		int leftHash = System.identityHashCode(obj.left);
		int rightHash = System.identityHashCode(obj.right);
		System.out.println(leftHash + " --- " + rightHash);
		Thread t = new Thread() {
			public void run() {
				if (leftHash < rightHash)
					obj.leftRight();
				else if (leftHash > rightHash)
					obj.rightLeft();
				else
					obj.tieLockMethod();
			}
		};
		Thread t1 = new Thread() {
			public void run() {
				if (leftHash < rightHash)
					obj.leftRight();
				else if (leftHash > rightHash)
					obj.rightLeft();
				else
					obj.tieLockMethod();
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
				System.out.println("Left right -- left right lock");
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
				System.out.println("Right left -- right left lock");
			}
		}
	}

	private void tieLockMethod() {
		synchronized (tieLock) {
			synchronized (left) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				synchronized (right) {
					System.out.println("Right left --- tie lock");
				}
			}
		}
	}
}
