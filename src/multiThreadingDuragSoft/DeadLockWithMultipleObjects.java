package multiThreadingDuragSoft;

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

class ThreadDeadLock extends Thread {

	A a = new A();
	B b = new B();

	public void execute() {
		this.start();
		a.m1(b); // Main Thread
	}

	public void run() {
		b.m2(a); // Child Thread.
	}
}

public class DeadLockWithMultipleObjects {
	public static void main(String[] args) {
		ThreadDeadLock t = new ThreadDeadLock();

		t.execute();
	}
}
