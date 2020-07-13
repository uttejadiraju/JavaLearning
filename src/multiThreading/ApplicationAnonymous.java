package multiThreading;

public class ApplicationAnonymous {
	public static void main(String args[]) {
		Thread t = new Thread(new Runnable() {
			public void run() {
				for (int i = 0; i <= 10; i++) {
					System.out.println("THREAD:-" + i);
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
		t.start();
	}
}