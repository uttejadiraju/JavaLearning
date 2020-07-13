package joshuaBloschCodes;

public class AssertionErrorExample {
	public static void main(String[] args) {
		AssertionErrorExample aee = new AssertionErrorExample();
		aee.equals(new Object());
	}
	
	public boolean equals(Object o) {
		throw new AssertionError();
	}
}
