package enums;

enum Beers {
	KC, BR, BL, KO
}
public class EnumValues {
	public static void main(String args[]) {
		Beers[] b = Beers.values();
		System.out.println(b[1]);
	}
}
