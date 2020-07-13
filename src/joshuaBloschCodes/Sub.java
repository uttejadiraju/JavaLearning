package joshuaBloschCodes;

import java.time.Instant;

class Super {
	public Super() {
		overrideMe();
	}

	public void overrideMe() {
		System.out.println("Parent");
	}
}

public final class Sub extends Super {
	private final Instant instant;

	Sub() {
		instant = Instant.now();
	}

	public void overrideMe() {
		System.out.println(instant);
	}

	public static void main(String[] args) {
		Sub sub = new Sub();
		sub.overrideMe();
	}
}

interface A {
	public void b();
}