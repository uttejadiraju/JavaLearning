package joshuaBloschMultiThreading;

import java.util.concurrent.Semaphore;

/***
 * Program to calculate the sum of numbers from 1.. 10 1.. 20 1.. 30 1.. 40 . .
 * . . 1.. 100
 * 
 * @author Sairam
 *
 */
public class Semaphores {
	private static Semaphore sem = new Semaphore(1);

	public static void main(String[] args) {
		Semaphores s = new Semaphores();
		for (int i = 1; i <= 10; i++) {
			final int index = i;
			MyThread m = s.new MyThread(i * 10);
			Thread t = new Thread() {
				public void run() {
					int res = m.sums();
					System.out.println("Sum == " + res + " by thread = " + index);
				}
			};
			t.setName(String.valueOf(i));
			t.start();

		}
	}

	class MyThread {
		int x;

		public MyThread(int x) {
			this.x = x;
		}

		int sum = 0;

		@SuppressWarnings("finally")
		public Integer sums() {
			try {
				sem.acquire();
				System.out.println("Thread " + Thread.currentThread().getName() + " acquired semaphore");
				for (int i = 1; i <= x; i++) {
					sum = sum + i;
				}

			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				sem.release();
				System.out.println("Thread " + Thread.currentThread().getName() + " released semaphore");
				return sum;
			}

		}
	}

}
