package joshuaBloschCodes;

import java.util.ArrayList;

class Person implements Cloneable {
	int rollNo;
	String name;
	int phoneNo;
	ArrayList<Integer> al;

	Person(int rollNo, String name, int phoneNo, ArrayList<Integer> al) {
		this.rollNo = rollNo;
		this.name = name;
		this.phoneNo = phoneNo;
		this.al = al;
	}

	Person(Person p) {
		ArrayList<Integer> temp = new ArrayList<Integer>();
		this.rollNo = p.rollNo;
		this.name = p.name;
		for (int v : p.al) {
			temp.add(v);
		}
		this.al = temp;
		this.phoneNo = p.phoneNo;

	}

	public String toString() {
		return rollNo + " " + name + " " + phoneNo + " " + al.toString();
	}

	public Person clone() {
		Person c = null;
		try {
			c = (Person) super.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return c;
	}
}

public class CloneVsCopyConstructor {
	public static void main(String[] args) {
		
		// Shallow Copy Example:-
		ArrayList<Integer> aa = new ArrayList<>();
		aa.add(55);
		aa.add(56);
		aa.add(66);
		Person p = new Person(82, "uttej", 80, aa);
		Person clone = p.clone();
		p.name = "manoj";
		p.phoneNo = 90;
		p.al.add(76);
		System.out.println(p);
		System.out.println(clone);
		
		System.out.println();
		// Deep Copy Example:-
		
		ArrayList<Integer> aa1 = new ArrayList<>();
		aa1.add(55);
		aa1.add(56);
		aa1.add(66);
		Person p1 = new Person(82, "uttej", 80, aa1);
		Person deepClone = new Person(p1);
		p1.name = "manoj";
		p1.phoneNo = 90;
		p1.al.add(76);
		System.out.println(p1);
		System.out.println(deepClone);
		
		System.out.println();
		
		
		deepClone.al.add(100);
		
		System.out.println(p1);
		System.out.println(deepClone);
	}
}
