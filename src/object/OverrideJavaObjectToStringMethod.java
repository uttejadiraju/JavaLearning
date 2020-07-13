package object;

public class OverrideJavaObjectToStringMethod {
	int rollNo;
	String name;
	
	public OverrideJavaObjectToStringMethod(int rollNo, String name) {
		this.rollNo = rollNo;
		this.name = name;
	}
	
	public String toString() {
		return this.rollNo + " " + this.name;
	}
	
	public int hashCode() {
		return rollNo;
	}
	
	public boolean equals(Object o) {
		if (this == o) {
			// Both references pointing to same object. Huge performance time can be saved.
			return true;
		}
		if (o instanceof OverrideJavaObjectToStringMethod) {
			OverrideJavaObjectToStringMethod obj = (OverrideJavaObjectToStringMethod) o;
			return (this.name.equals(obj.name) && this.rollNo == obj.rollNo);
		}
		return false;
	}
	static public void main(String args[]) {
		OverrideJavaObjectToStringMethod obj = new OverrideJavaObjectToStringMethod(55, "Manoj");
		OverrideJavaObjectToStringMethod obj1 = new OverrideJavaObjectToStringMethod(55, "Manoj");
		System.out.println(obj == obj1);
		System.out.println(obj.equals(obj1));
		String a="a";
		System.out.println(a);
		String b=a;
		System.out.println(b);
		a.concat("abc");
		System.out.println(a);
		System.out.println(b);
		
		StringBuilder sb = new StringBuilder("i am not changed!!!");
		StringBuilder sbCopy = sb;
		System.out.println(sb);
		System.out.println("I Depend on sb. My value = " + sbCopy);
		sb.deleteCharAt(0);
		System.out.println(sb);
		System.out.println("sb:- i am changed sorry!!!");
		System.out.println("I am changed now!!! sbCopy =" +sbCopy);
	}
}
