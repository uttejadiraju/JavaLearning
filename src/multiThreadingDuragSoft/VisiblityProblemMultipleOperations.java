package multiThreadingDuragSoft;

public class VisiblityProblemMultipleOperations {
	static boolean stop = true;

	public static void main(String[] args) throws InterruptedException {

		Thread t1 = new Thread() {
			public void run() {
				while (stop) {
					System.out.println("I AM RUNNING!!!");
				}
			}
		};
		t1.start();
		System.out.println("MAIN THREAD ENTERED!!!");
		System.out.println("STOPPING THE THREAD EXECUTION");
		stop = false;
	}
}
