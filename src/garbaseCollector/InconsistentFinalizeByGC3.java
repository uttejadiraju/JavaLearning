package garbaseCollector;

public class InconsistentFinalizeByGC3 {
	static int count = 0;

	class Test {
		public void finalize() {
			System.out.println("Finalize method called!!!");
			++count;
		}

	}

	public static void main(String[] args) throws InterruptedException {
		InconsistentFinalizeByGC3 obj = new InconsistentFinalizeByGC3();
		System.out.println("TOTAL MEMORY = " + Runtime.getRuntime().totalMemory());
		System.out.println("FREE MEMORY= " + Runtime.getRuntime().freeMemory());
		for (int i = 0; i < 10; i++) {
			Test t = obj.new Test();
			t = null;
		}
		System.gc();
		System.out.println("TOTAL MEMORY = " + Runtime.getRuntime().totalMemory());
		System.out.println("FREE MEMORY= " + Runtime.getRuntime().freeMemory()); // change in free memory!!! If
																					// System.gc() is used!!!
	}
}
