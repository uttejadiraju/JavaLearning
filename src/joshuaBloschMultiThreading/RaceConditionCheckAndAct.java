package joshuaBloschMultiThreading;

public class RaceConditionCheckAndAct {
	public static void main(String[] args) {
		Thread t1 = new Thread() {
			public void run() {
				int value = SingleTonInstance.getInstance().hashCode();
				System.out.println("value by thread 1= " + value);
			}
		};

		Thread t2 = new Thread() {
			public void run() {
				int value = SingleTonInstance.getInstance().hashCode();
				System.out.println("value by thread 2= " + value);
			}
		};

		t1.start();
		t2.start();
	}

}

class SingleTonInstance {
	private static SingleTonInstance instance = null;

	public static SingleTonInstance getInstance() {
		if (instance == null) {
			System.out.println("Trying to get isntance!!!");
			instance = new SingleTonInstance();
		}
		return instance;
	}
}
/***
 * value by thread 2= 1177982570 value by thread 1= 962867702
 ***/