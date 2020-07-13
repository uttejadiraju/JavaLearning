package joshuaBloschMultiThreading;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/***
 * Program to calculate the sum of numbers from 1.. 10 1.. 20 1.. 30 1.. 40 . .
 * . . 1.. 100
 * 
 * @author Sairam
 *
 */
public class FutureThreads {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		@SuppressWarnings("rawtypes")
		FutureTask[] randomNumberTasks = new FutureTask[101];
		for (int i = 1; i <= 10; i++) {
			FutureThread my = new FutureThread(i * 10);
			randomNumberTasks[i] = new FutureTask<>(my);
			Thread t = new Thread(randomNumberTasks[i]);
			t.start();
			// Blocking operation!!! Synchronous flow only
			// System.out.println("THE VALUE OF FUTURE THREAD = " +
			// randomNumberTasks[i].get());
		}
		System.out.println("I am done lets see results");
		for (int i = 1; i <= 10; i++) {
			System.out.println(randomNumberTasks[i].get());
		}
	}
}

class FutureThread implements Callable<Integer> {
	int x;

	public FutureThread(int x) {
		this.x = x;
	}

	int sum = 0;

	public Integer call() {
		for (int i = 1; i <= x; i++) {
			sum = sum + i;
		}
		return sum;

	}
}

/***
 * Sum = 55 Sum = 465 I am done lets see results Sum = 210 Sum = 1275 Sum = 820
 * Sum = 1830 THE VALUE OF FUTURE THREAD = 55 THE VALUE OF FUTURE THREAD = 210
 * THE VALUE OF FUTURE THREAD = 465 THE VALUE OF FUTURE THREAD = 820 THE VALUE
 * OF FUTURE THREAD = 1275 THE VALUE OF FUTURE THREAD = 1830 Sum = 2485 THE
 * VALUE OF FUTURE THREAD = 2485 Sum = 3240 Sum = 4095 Sum = 5050 THE VALUE OF
 * FUTURE THREAD = 3240 THE VALUE OF FUTURE THREAD = 4095 THE VALUE OF FUTURE
 * THREAD = 5050
 * 
 * 
 */