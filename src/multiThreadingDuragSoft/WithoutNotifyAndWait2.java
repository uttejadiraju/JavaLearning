package multiThreadingDuragSoft;

public class WithoutNotifyAndWait2 {
	public static void main(String[] args) throws InterruptedException {
		Calc1 t = new Calc1();
		t.start();
		t.join();
		System.out.println(t.total);
	}
}

class Calc1 extends Thread {
	int total = 0;

	public void run() {
		for (int i = 0; i <= 100; i++) {
			total = total + i;
		}
	}
}
