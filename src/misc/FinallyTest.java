package misc;

public class FinallyTest {
	public static void main(String[] args) {
		try {
			System.exit(1);
		} catch (Exception e) {
			
		} finally {
			System.out.println("Bye");
		}
	}
}
