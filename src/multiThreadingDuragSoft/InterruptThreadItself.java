package multiThreadingDuragSoft;

public class InterruptThreadItself {
	public static void main(String[] args) {
		My m = new My();
		m.setName("child");
		m.start();
		try {
			m.join();
		} catch (InterruptedException e) {
			System.out.println("Child distructed itself!!!");
			e.printStackTrace();
		}
	}
}

class My extends Thread {

	public My() {
	}

	@Override
	public void run() {
		Thread.currentThread().interrupt();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			System.out.println("I distructed myself");
			e.printStackTrace();
		}
	}
}
