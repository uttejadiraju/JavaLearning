package multiThreadingDuragSoft;

public class WithNotifyAndWait {
	public static void main(String[] args) throws InterruptedException {
		Calc2 t = new Calc2();
		t.start();
		synchronized (t) {
			t.wait();
		}
		System.out.println(t.total);
	}
}

class Calc2 extends Thread {
	int total = 0;

	public void run() {
		synchronized (this) {
			for (int i = 0; i <= 100; i++) {
				total = total + i;
			}
			System.out.println("Data processed");
			notify();
		}

	}
}
