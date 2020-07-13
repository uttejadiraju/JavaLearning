package misc;

import java.util.Date;

public class LocalObjectReferences {
	public static void main(String[] args) {
		Date date;
		// if (date == null)
		// System.out.println("date is null");
	}
}
/**
 * Instance variable references are always given a default value of null, until
 * they are explicitly initialized to something else. But local references are
 * not given a default value; in other words, they aren't null. If you don't
 * initialize a local reference variable, then by default, its value is—well
 * that's the whole point: it doesn't have any value at all! So we'll make this
 * simple: Just set the darn thing to null explicitly, until you're ready to
 * initialize it to something else. The following local variable will compile
 * properly: Date date = null; // Explicitly set the local reference // variable
 * to null
 **/