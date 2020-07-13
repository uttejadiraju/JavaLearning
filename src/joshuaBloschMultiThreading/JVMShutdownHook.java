package joshuaBloschMultiThreading;

public class JVMShutdownHook {
	public static void main(String[] args) {
		Runtime.getRuntime().addShutdownHook(new Thread() {
			public void run() {
				System.out.println("EXITING!!!");
			}
		});
		System.out.println("DO your operations!!!");
		
	}
}
