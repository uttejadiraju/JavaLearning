package javaAccessModifiersAndDeclarations;

import java.lang.String; // Not required to import.
import java.util.*; // 3rd priority - Implicit.
import java.sql.Date; // 1St priority. - Explicit
public class PriorityOfImports {
	public static void main(String[] args) {
		/** Date d = new Date(); **/ // Error ambiguity. Date comes from sql & util.
		java.util.Date d = new java.util.Date(); // Accepted.
		Date d1 = new Date(0); // SQL date
		System.out.println(d1.getClass());
		
		
		// Priority :- Explicit, Current package class & Implicit.
		
		// All classes present in java.lang & CWD are needed to import.
		
		// Fully qualifed names best performace. ( compile time )
		// Implicit & explicit names low performance. ( compile time).
		// At runtime, no change in performace. Both are same.
		
		// Loading a java class is load on demand. Only when needed, packages are imported. (i.e Dynamic include)
	}
}
