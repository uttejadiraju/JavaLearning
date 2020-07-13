package joshuaBloschMultiThreading;

import java.util.Iterator;

public class ConcurrentModifiedException {
	private static java.util.ArrayList<Integer> list = new java.util.ArrayList<>();

	public static void main(String[] args) throws InterruptedException {
		Thread t = new Thread() {
			public void run() {
				updateList();
			}
		};
		t.start();
		t.join();
		Thread t1 = new Thread() {
			public void run() {
				removeList();
			}
		};
		t1.start();
		Iterator<Integer> it = list.iterator();
		while (it.hasNext()) {
			Thread.sleep(1000);
			System.out.println(it.next());
		}
	}

	private static void updateList() {
		for (int i = 0; i < 5; i++) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			list.add(5);
		}
	}

	private static void removeList() {
		try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		list.remove(0);
	}
}
