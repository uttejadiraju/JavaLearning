package multiThreadingDuragSoft;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ClientSideLocking {

	public static void main(String[] args) throws InterruptedException {
		Thread threads[] = new Thread[10000];
		
		for (int i = 0; i < 10000; i++) {
			threads[i] = new Thread() {
				public void run() {
					ListHelper l = new ListHelper();
					l.ifAbsent(5);

				}
			};
			threads[i].setName("Thread " + i);
			threads[i].run();
		}

	}
}

class ListHelper {
	public List list = Collections.synchronizedList(new ArrayList());

	public synchronized boolean ifAbsent(int v) {
		boolean abs = !list.contains(v);
		if (abs) {

			
			list.add(v);
			System.out.println(list);
		}
		return abs;
	}
}
