package joshuaBloschMultiThreading;

public class DeadLockExample {
	public static void main(String[] args) {
		A a = new A();
		B b = new B();
		Thread t = new Thread() {
			public void run() {
				a.m1(b);
			}
		};

		Thread t1 = new Thread() {
			public void run() {
				b.m2(a);
			}
		};
		t.start();
		t1.start();
	}
}

class A {
	public synchronized void m1(B b) {
		System.out.println("Inside m1 with lock on object b");
		b.methodB();
	}

	public synchronized void methodA() {
		System.out.println("Inside method A");
	}
}

class B {
	public synchronized void m2(A a) {
		System.out.println("Inside m2 with lock on object a");
		a.methodA();
	}

	public synchronized void methodB() {
		System.out.println("Inside method B");
	}

}