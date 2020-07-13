package joshuaBloschMultiThreading;

public class VisiblityProblemAgain {
	static int x = 0;

	public static void main(String[] args) throws InterruptedException {
		VisiblityProblemAgain v = new VisiblityProblemAgain();
		Thread t1 = new Thread() {
			public void run() {
				write(v);
			}
		};
		t1.start();

		Thread t2 = new Thread() {
			public void run() {
				read(v);
			}
		};
		t2.start();
	}

	public static void write(VisiblityProblemAgain v) {
		x = 1;
	}

	public static void read(VisiblityProblemAgain v) {
		int r = x;
		System.out.println(r);
	}
}
