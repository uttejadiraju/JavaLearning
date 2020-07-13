package enums;

enum Beee {
	KC(10), BR(20){
		/**
		 * Anonymous method
		 * 
		 */
		public int getValue() {
			return v*-1;
		}
	}, BL(30), KO;

	int v;

	Beee(int v) {
		System.out.println("Constructor int arg");
		this.v = v;
	}

	Beee() {
		System.out.println("Constructor no arg");
		this.v = Integer.MAX_VALUE;
	}

	public  int getValue() {
		return v;
	}
}

public class EnumMethods {
	public static void main(String args[]) {
		Beee[] b = Beee.values();
		for (Beee bee : b){
			System.out.println(bee + " === " +bee.getValue());
		}
	}
}
