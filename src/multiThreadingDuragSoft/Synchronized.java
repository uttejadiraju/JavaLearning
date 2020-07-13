package multiThreadingDuragSoft;

class Display {
	public synchronized void wish(String name) {
		for (int i = 0; i < 10; i++) {
			System.out.println("Good Morining --" + name);
		}
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

class myRunnable extends Thread {
	Display d;
	String name;

	myRunnable(Display d, String name) {
		this.d = d;
		this.name = name;
	}

	public void run() {
		d.wish(name);
	}
}

public class Synchronized {

	public static void main(String[] args) throws InterruptedException {
		Display d = new Display();
		myRunnable t1 = new myRunnable(d, "dhoni");
		myRunnable t2 = new myRunnable(d, "raina");
		myRunnable t3 = new myRunnable(d, "kohli");
		t1.start();
		t2.start();
		t3.start();
	}
}
