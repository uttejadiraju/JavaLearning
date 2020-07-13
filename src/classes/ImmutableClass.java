package classes;

public final class ImmutableClass {
	private final int rollNo;
	private final String name;

	public ImmutableClass(int rollNo, String name) {
		this.rollNo = rollNo;
		this.name = name;
	}

	public int getRollNo() {
		return rollNo;
	}

	public String getName() {
		return name;
	}

	public static void main(String args[]) {
		ImmutableClass obj1 = new ImmutableClass(55, "Manoj");
		obj1 = new ImmutableClass(66, "Sai");
		System.out.println(obj1.getName() + " " + obj1.getRollNo());
		
	}
}
