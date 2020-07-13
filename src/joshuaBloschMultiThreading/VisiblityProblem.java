package joshuaBloschMultiThreading;

public class VisiblityProblem {
	static boolean stop = true;

	public static void main(String[] args) throws InterruptedException {
		Thread t1 = new Thread() {
			public void run() {
				while (stop) {
					System.out.println("I AM RUNNING!!!");
				}
			}
			
			public void b() {
				
			}
		};
		t1.start();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		stop = false;
		System.out.println("Stopped!!!");

	}
}
