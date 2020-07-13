package joshuaBloschCodes;

public class IncorrectEqualsMethod {
	private final String s;

	public IncorrectEqualsMethod(String s) {
		this.s = s;
	}

	public boolean equals(IncorrectEqualsMethod o) {
		return s.equals(o);
	}

	public static void main(String[] args) {
		IncorrectEqualsMethod str = new IncorrectEqualsMethod("hi");
		String s = "hi";
		System.out.println(str.equals(s)); // Returns false!!!
		System.out.println(s.equals(str)); // Returns false!!!
	}
}
/**
 * The problem is that this method does not override Object.equals, whose
 * argument is of type Object, but overloads it instead (Item 52). It is
 * unacceptable to provide such a “strongly typed” equals method even in
 * addition to the normal one, because it can cause Override annotations in
 * subclasses to generate false positives and provide a false sense of security.
 **/