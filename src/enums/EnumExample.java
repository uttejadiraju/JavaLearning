package enums;

enum Beer {
	KC, BR, BL, KO;

	public String toString() {
		switch (this) {
		case KC:
			return "kc";
		case BR:
			return "br";
		case BL:
			return "bl";
		case KO:
			return "ko";
		}
		return "undefined";
	}
}

public class EnumExample {
	public static void main(String args[]) {
		Beer b = Beer.BL;
		System.out.println(b);
	}
}
