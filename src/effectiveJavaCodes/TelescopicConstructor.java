package effectiveJavaCodes;

public class TelescopicConstructor {
	private final String name;
	private final int rollNo;

	public TelescopicConstructor(String name, int rollNo) {
		this.name = name;
		this.rollNo = rollNo;
	}

	public TelescopicConstructor(String name) {
		this(name, 0);
	}

	public TelescopicConstructor(int rollNo) {
		this(null, rollNo);
	}

	public TelescopicConstructor() {
		this(null, 0);
	}

	public static void main(String[] args) {
		TelescopicConstructor full = new TelescopicConstructor("uttej", 82);
		TelescopicConstructor halfOne = new TelescopicConstructor("manoj");
		TelescopicConstructor halfSecond = new TelescopicConstructor(69);
	}
}
