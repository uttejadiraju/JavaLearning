package object;

class Tests {
	int id;

	Tests(int id) {
		this.id = id;
	}
}

class Testing implements Cloneable {
	int num;
	Tests t;

	Testing(Tests t, int num) {
		this.num = num;
		this.t = t;
	}

	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}

public class ShallowCopy {
	public static void main(String[] args) throws CloneNotSupportedException {
		Tests t1 = new Tests(5);
		Testing tes = new Testing(t1, 10);
		System.out.println(tes.t.id + " " + tes.num);

		Testing tes1 = (Testing) tes.clone();
		tes1.num = 15; // Primitive types no change.
		tes1.t.id = 20; // Object types change!!!

		System.out.println(tes.t.id + " " + tes.num);
		
		System.out.println(tes.hashCode() + " ===" + tes1.hashCode());
		
		System.out.println(tes.equals(tes1));
		
		System.out.println(tes1.equals(tes));
	}

}
