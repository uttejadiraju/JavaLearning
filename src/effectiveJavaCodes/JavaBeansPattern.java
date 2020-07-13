package effectiveJavaCodes;

public class JavaBeansPattern {
	private String name;
	private int rollNo;

	public String getName() {
		return name;
	}

	public int getRollNo() {
		return rollNo;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}

	public static void main(String[] args) {
		JavaBeansPattern full = new JavaBeansPattern();
		full.setName("uttej");
		full.setRollNo(82);

		JavaBeansPattern half = new JavaBeansPattern();
		half.setName("manoj");

		JavaBeansPattern empty = new JavaBeansPattern();
	}
}

/**
 * a JavaBean may be in an inconsistent state partway through its construction.
 * The class does not have the option of enforcing consistency merely by
 * checking the validity of the constructor parameters. Attempting to use an
 * object when it’s in an inconsistent state may cause failures that are far
 * removed from the code containing the bug and hence difficult to debug. A
 * related disadvantage is that the JavaBeans pattern precludes the possibility
 * of making a class immutable and requires added effort on the part of the
 * programmer to ensure thread safety.
 */