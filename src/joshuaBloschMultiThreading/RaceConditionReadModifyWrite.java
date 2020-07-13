package joshuaBloschMultiThreading;

public class RaceConditionReadModifyWrite {
	public static void main(String[] args) {
		RaceConditionReadModifyWrite r = new RaceConditionReadModifyWrite();
		Count c = r.new Count();
		Thread t1 = new Thread() {
			public void run() {
				int value = c.getCount();
				System.out.println("value by thread 1= " + value);
			}
		};

		Thread t2 = new Thread() {
			public void run() {
				int value = c.getCount();
				System.out.println("value by thread 2= " + value);
			}
		};

		t1.start();
		t2.start();
	}

	class Count {
		private int count = 0;

		public int getCount() {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			count++;
			return count;
		}
	}
}

/***
 * value by thread 2= 1 value by thread 1= 1
 **/
