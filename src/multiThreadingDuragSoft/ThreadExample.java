package multiThreadingDuragSoft;

public class ThreadExample {
	public static void main(String[] args) {
		child m = new child();
		m.setName("child");
		m.start();
	}
}

class child extends Thread {

	public child() {
		System.out.println("name : " + Thread.currentThread().getName()); // main
	}

	@Override
	public void run() {
		System.out.println("name : " + Thread.currentThread().getName()); // child
	}
}
