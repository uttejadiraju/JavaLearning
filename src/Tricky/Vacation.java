package Tricky;

enum DaysOff {
	Thanksgiving, PresidentsDay, ValentinesDay
}

public class Vacation {
	public static void main(String... unused) {
		final DaysOff input = DaysOff.Thanksgiving;
		switch (input) {
		default:
		case DaysOff.ValentinesDay:
			System.out.print("1");
		case DaysOff.PresidentsDay:
			System.out.print("2");
		}
	}
}