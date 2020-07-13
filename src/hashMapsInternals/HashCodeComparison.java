package hashMapsInternals;

import java.util.HashMap;
import java.util.Objects;

public class HashCodeComparison {
	public static void main(String[] args) {
		String str1 = "John Smith";
		String str2 = "Sandra Dee";
		int h1 = str1.hashCode();
		int h2 = str2.hashCode();
		System.out.println(h1 ^ (h1 >>> 16));
		System.out.println(h2 ^ (h2 >>> 16));
	}
}
