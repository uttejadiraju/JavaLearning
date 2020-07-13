package enums;

enum Bee {
	KC(10), BR(20), BL(30), KO;

	int v;

	Bee(int v) {
		System.out.println("Constructor int arg");
		this.v = v;
	}

	Bee() {
		System.out.println("Constructor no arg");
		this.v = Integer.MAX_VALUE;
	}

	public int getValue() {
		return v;
	}
}

public class EnumConstructor {
	public static void main(String args[]) {
		Bee[] b = Bee.values();
		for (Bee bee : b){
			System.out.println(bee + " === " +bee.getValue());
		}
		
		Bee[] b1 = Bee.values();
		for (Bee bee : b1){
			System.out.println(bee + " === " +bee.getValue());
		}
		Bee bb = Bee.KC;
		System.out.println(bb.getValue());
	}
}
