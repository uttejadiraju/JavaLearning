package multiThreadingDuragSoft;

class Display1 {
	public synchronized void  wish(String name){
		for (int i = 0; i < 10; i++) {
			System.out.println("Good Morining --" +name);
		}
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
class myRunnable2 extends Thread {
	Display1 d;
	String name;

	myRunnable2(Display1 d, String name) {
		this.d = d;
		this.name = name;
	}

	public void run() {
		d.wish(name);
	}
}
public class SynchronizedWithIrregularOutput {

	public static void main(String[] args) throws InterruptedException {
		Display1 d = new Display1();
		myRunnable2 t1 = new myRunnable2(d, "dhoni");
		myRunnable2 t2 = new myRunnable2(new Display1(), "raina"); // Different objects of display. Irregular output
		t1.start();
		t2.start();
	}
}
