package joshuaBloschMultiThreading;

public class VisiblityProblemSolved {
	volatile static boolean stop = true;

	public static void main(String[] args) throws InterruptedException {
		Thread t1 = new Thread() {
			public void run() {
				while (stop) {
					System.out.println("I AM RUNNING!!!");
				}
			}
		};
		t1.start();
		for (int i = 0; i < 10; i++) {
			System.out.println("Not stopped!!!");
		}
		System.out.println("Stopped!!!");
		stop = false;

	}
}
