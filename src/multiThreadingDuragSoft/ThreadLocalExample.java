package multiThreadingDuragSoft;

public class ThreadLocalExample {
	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			Thread t = new Thread() {
				public void run() {
					System.out.println(new ThreadLocalExample().getRandom());
				}
			};
			t.start();
		}
	}
	
	public String getRandom() {
		return ThreadLocalCreator.threadLocal.get();
	}
}

class ThreadLocalCreator {
	public  static ThreadLocal<String> threadLocal = new ThreadLocal<String>() {
		@Override
		public String initialValue() {
			return String.valueOf(Math.random());
		}
	};
}