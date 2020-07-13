package multiThreadingDuragSoft;

public class InfiinityExecutionPreventionWithNotifyAndWait {
	public static void main(String[] args) throws InterruptedException {
		Calc4 t = new Calc4();
		t.start();
		Thread.sleep(1000); // Main thread went to sleep. Child executes.!!!s
		synchronized (t) {
			t.wait(10); // Goes to wait. But child thread got executed & went to dead state. Still no
						// infinity wait. Since, waiting for only certain time. No foreve wait period!!!
		}
		System.out.println(t.total);
	}
}

class Calc4 extends Thread {
	int total = 0;

	public void run() {
		synchronized (this) {
			for (int i = 0; i <= 100; i++) {
				total = total + i;
			}
			System.out.println("Data processed");
			this.notify();
		}

	}
}
