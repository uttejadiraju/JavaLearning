package effectiveJavaCodes;

public class SingleTonApp2 {
	private static final SingleTonApp2 obj = new SingleTonApp2();

	public SingleTonApp2 getInstance() {
		return obj;
	}

	private SingleTonApp2() {

	}

	public static void main(String[] args) {

	}
}
