package multiThreadingDuragSoft;

public class WithoutNotifyAndWait {
	public static void main(String[] args) {
		Calc t = new Calc();
		t.start();
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(t.total);
	}
}

class Calc extends Thread {
	int total = 0;
	public void run() {
		for (int i = 0; i <= 100; i++) {
			total = total + i;
		}
	}
}
