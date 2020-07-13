package enums;

enum Beers1 {
	KC, BR, BL, KO
}

enum B {

}

enum C {
	;
}

enum D {
	BB;
	public void hello() {

	}
}

public class EnumValid {
	public static void main(String args[]) {
		Beers1 b = Beers1.BL;
		System.out.println(b);
	}
}
