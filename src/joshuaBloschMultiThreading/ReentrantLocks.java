package joshuaBloschMultiThreading;

public class ReentrantLocks {
	public static void main(String[] args) {
		Child c = new Child();
		Thread t = new Thread() {
			public void run() {
				c.doSomething();
			}
		};
		t.start();

		Recursion r = new Recursion();

		Thread t1 = new Thread() {
			public void run() {
				r.recurse(5);
			}
		};
		t1.start();
	}
}

class Parent {
	public synchronized void doSomething() {
		System.out.println("Parent doing something");
	}
}

class Child extends Parent {
	public synchronized void doSomething() {
		System.out.println("Child doing something");
		super.doSomething();
	}
}

class Recursion {
	public synchronized void recurse(int x) {
		if (x == 0) {
			return;
		}
		recurse(--x);
	}
}

/***
 * All java object locks are by default intrinsic. Thread acquiring lock which
 * it already holds is reentrancy. Hence reentrancy prevents deadlocks. Since, t
 * got lock on childDoSomething & with the same lock trying to acquire lock on
 * parent doSomething!!! Request fails :- Thread trying to acquire lock which is
 * already acquired by some other thread. Request success;- Thread trying to
 * acquire lock which is already acquired by the same thread. eg:- Recursion.
 */