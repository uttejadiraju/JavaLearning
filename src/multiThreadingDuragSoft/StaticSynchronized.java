package multiThreadingDuragSoft;

class Display2 {
	public static synchronized void  wish(String name){
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
class myRunnable3 extends Thread {
	Display2 d;
	String name;

	myRunnable3(Display2 d, String name) {
		this.d = d;
		this.name = name;
	}

	public void run() {
		d.wish(name);
	}
}
public class StaticSynchronized {

	public static void main(String[] args) throws InterruptedException {
		Display2 d = new Display2();
		myRunnable3 t1 = new myRunnable3(d, "dhoni");
		myRunnable3 t2 = new myRunnable3(new Display2(), "raina"); // Different objects of display. Regular output because of static synchronized
		t1.start();
		t2.start();
	}
}
