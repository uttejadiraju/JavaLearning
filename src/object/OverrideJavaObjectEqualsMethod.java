package object;

public class OverrideJavaObjectEqualsMethod {
	int rollNo;
	String name;
	
	public OverrideJavaObjectEqualsMethod(int rollNo, String name) {
		this.rollNo = rollNo;
		this.name = name;
	}
	
	public String toString() {
		return this.rollNo + " " + this.name;
	}
	
	public int hashCode() {
		return rollNo;
	}
	static public void main(String args[]) {
		OverrideJavaObjectEqualsMethod obj = new OverrideJavaObjectEqualsMethod(55, "Manoj");
		System.out.println(obj.toString());
		System.out.println(obj.hashCode());
	}
}
