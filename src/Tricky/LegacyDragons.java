package Tricky;

import java.util.ArrayList;
import java.util.List;

class Dragon {
}

class Unicorn {
}

public class LegacyDragons {
	public static void main(String[] args) {
		List unicorns = new ArrayList();
		unicorns.add(new Unicorn());
		printDragons(unicorns);
	}

	private static void printDragons(List<Dragon> dragons) {
		
		java.util.List numbers = new java.util.ArrayList();
		numbers.add(5);
		//int result = numbers.get(0); // DOES NOT COMPILE
		
		
		java.util.List<Integer> numbers1 = new java.util.ArrayList<Integer>();
		numbers1.add(5);
		int result = numbers1.get(0); // Compiles successfully.
		
		List<Object> obj = new ArrayList<Object>();
		obj.add("string");
		
		
		for (Dragon dragon : dragons) { // ClassCastException
			System.out.println(dragon);
		}
	}
}