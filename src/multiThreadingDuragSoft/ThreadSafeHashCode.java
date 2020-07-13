package multiThreadingDuragSoft;

import java.util.Arrays;

public class ThreadSafeHashCode {
	private final char value[];
	private int hash; // Default to 0

	public ThreadSafeHashCode(char[] value) {
		this.value = Arrays.copyOf(value, value.length);
	}

	public static void main(String[] args) throws InterruptedException {
		ThreadSafeHashCode obj = new ThreadSafeHashCode("uttej".toCharArray());
		ThreadSafeHashCode obj1 = new ThreadSafeHashCode("uttej".toCharArray());
		Thread t = new Thread() {
			public void run() {
				obj1.hashCode();
			}
		};
		t.setName("Child");
		t.start();
		t.setPriority(10);
		Thread.sleep(1000);
		obj.hashCode();
	}

	public int hashCode() {
		int h = hash;
		if (h == 0 && value.length > 0) {
			char val[] = value;

			for (int i = 0; i < value.length; i++) {

				h = 31 * h + val[i];
			}
			hash = h;

		}
		System.out.println(Thread.currentThread().getName() + " " + h);
		return h;
	}
}
