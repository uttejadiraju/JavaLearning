package garbaseCollector;

public class InconsistentFinalizeByGC {
	static int count = 0;
	class Test {
		public void finalize() {
			//System.out.println("Finalize method called!!!");
			++count;
		}
		
	}
	public static void main(String[] args) throws InterruptedException{
		InconsistentFinalizeByGC obj = new InconsistentFinalizeByGC();
		System.out.println("TOTAL MEMORY = " + Runtime.getRuntime().totalMemory());
		System.out.println("FREE MEMORY= " + Runtime.getRuntime().freeMemory());
		for (int i = 0; i < 10; i++) {
			Test t = obj.new Test();
			t = null;
		}
		System.out.println("TOTAL MEMORY = " + Runtime.getRuntime().totalMemory()); 
		System.out.println("FREE MEMORY= " + Runtime.getRuntime().freeMemory()); // No change in free memory!!!
	}
}
