package misc;

public class TestingInheritance {
	int v = 0;
	public static void main(String[] args) {
		AA a = new BB();
		a.AAA();
		// Not possible !!! a.c();
		BB b = new BB();
		AA aa = new AA();
		System.out.println(a instanceof BB);
		System.out.println(a instanceof AA);
		System.out.println(b instanceof BB);
		System.out.println(b instanceof AA);
		System.out.println(aa instanceof BB);
		System.out.println(aa instanceof AA);

		Foo f = new Foo();
		f.go();
		Foo fg = new Bar();
		f.go();
		Bar Bb = new Bar();
		Bb.go();
		Bb.go(1);
	}
}

class AA {
	public void AAA() {

	}
}

class BB extends AA {
	public void c() {
	}
}

class Foo {
	void go() {
	}
}

class Bar extends Foo {
	String go(int x) {
		return null;
	}

	// Not possible. Can't change return type
	// String go() {

	// }
}
