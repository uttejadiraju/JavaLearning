package garbaseCollector;

public class MakeObjectEligilbleForGC {
	class Test {
		public void finalize() {
			System.out.println("Finalize method called");
		}
	}

	public static void main(String[] args) {
		MakeObjectEligilbleForGC obj = new MakeObjectEligilbleForGC();
		Test t = obj.new Test();
		t = null;
		System.gc();
	}
}
