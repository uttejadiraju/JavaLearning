package multiThreadingDuragSoft;

public class DeadLock2 {

	public static void main(String[] args) throws InterruptedException {
		Thread.currentThread().join();
	}
}

/** This code runs forever **/