package multiThreadingDuragSoft;

public class InfinityExecutionWithNotifyAndWait {
	public static void main(String[] args) throws InterruptedException {
		Calc3 t = new Calc3();
		t.start();
		Thread.sleep(1000); // Main thread went to sleep. Child executes.!!!s
		synchronized (t) {
			t.wait(); // Goes to wait. But child thread got executed & went to dead state.
		}
		System.out.println(t.total);
	}
}

class Calc3 extends Thread {
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
