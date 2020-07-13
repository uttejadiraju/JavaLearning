package multiThreadingDuragSoft;

public class SynchronizedThreadInterference {
	class Counter {
		private int c = 0;

		public synchronized void increment() {
			c++;
		}

		public synchronized void decrement() {
			c--;
		}

		public synchronized int value() {
			return c;
		}
		
		public synchronized void done() {
			System.out.println("I Completed!!!");
		}

	}

	class Thread1 extends Thread {
		Counter obj;

		Thread1(Counter obj) {
			this.obj = obj;
		}

		public void run() {
			obj.increment();
			System.out.println("Thread one incremented!!!");
			System.out.println("Thread one value after incrementing= " + obj.value());

			obj.decrement();
			System.out.println("Thread one decremented!!!");
			System.out.println("Thread one value after decrementing= " + obj.value());
			
			obj.done();
		}
	}

	class Thread2 extends Thread {
		Counter obj;

		Thread2(Counter obj) {
			this.obj = obj;
		}
		

		public void run() {
			obj.increment();
			System.out.println("Thread two incremented!!!");
			System.out.println("Thread two value after incrementing = " + obj.value());
			
			obj.decrement();
			System.out.println("Thread two decremented!!!");
			System.out.println("Thread two value after decrementing = " + obj.value());
			
			obj.done();
		}
	}

	public static void main(String[] args) {
		SynchronizedThreadInterference ti = new SynchronizedThreadInterference();
		Counter obj = ti.new Counter();
		Thread1 t1 = ti.new Thread1(obj);
		Thread2 t2 = ti.new Thread2(obj);
		t1.start();
		t2.start();
	}
}
