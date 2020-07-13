package object;

class Test implements Cloneable {
	int id;

	Test(int id) {
		this.id = id;
	}
	
	public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

public class ObjectCloneMethod  {
	public static void main(String[] args) throws CloneNotSupportedException {
		Test t1 = new Test(5);
		System.out.println(t1.id);
		Test t2 = (Test) t1.clone();
		t2.id = 15;
		System.out.println(t2.id);
		System.out.println(t1.id);
	}

}
