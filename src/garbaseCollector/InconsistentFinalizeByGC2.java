package garbaseCollector;

public class InconsistentFinalizeByGC2 {
	static int count = 0;

	class Test {
		public void finalize() {
			//System.out.println("Finalize method called!!!");
			++count;
		}

	}

	public static void main(String[] args) {
		InconsistentFinalizeByGC2 obj = new InconsistentFinalizeByGC2();
		System.out.println("TOTAL MEMORY = " + Runtime.getRuntime().totalMemory());
		System.out.println("FREE MEMORY= " + Runtime.getRuntime().freeMemory());
		for (int i = 0; i < 1000000; i++) {
			Test t = obj.new Test();
			t = null;
		}
		System.gc();
		System.out.println("TOTAL MEMORY = " + Runtime.getRuntime().totalMemory());
		System.out.println("FREE MEMORY= " + Runtime.getRuntime().freeMemory());
	}
}
