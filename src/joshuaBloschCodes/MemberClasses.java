package joshuaBloschCodes;

import java.util.ArrayList;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class MemberClasses {
	public static void main(String[] args) {
		// Non static member classes example:-
		ArrayList<Integer> al = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			al.add(i);
		}
		@SuppressWarnings("unused")
		Iterator<Integer> it = new ArrayList<Integer>().iterator();

		// Static member classes example:-
		LinkedHashMap<String, Integer> m = new LinkedHashMap<String, Integer>();

		m.put("1 - Bedroom", 25000);
		m.put("2 - Bedroom", 50000);
		m.put("3 - Bedroom", 75000);
		m.put("1 - Bedroom - hall", 65000);
		m.put("2 - Bedroom - hall", 85000);
		m.put("3 - Bedroom - hall", 105000);

		Set<Map.Entry<String, Integer>> s = m.entrySet();
	}
}
