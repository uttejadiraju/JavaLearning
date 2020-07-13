package object;

public class OverrideJavaObjectHashCodeMethod {
	int rollNo;
	String name;
	
	public OverrideJavaObjectHashCodeMethod(int rollNo, String name) {
		this.rollNo = rollNo;
		this.name = name;
	}
	
	public String toString() {
		return this.rollNo + " " + this.name;
	}
	static public void main(String args[]) {
		OverrideJavaObjectHashCodeMethod obj = new OverrideJavaObjectHashCodeMethod(55, "Manoj");
		System.out.println(obj.toString());
	}
}
