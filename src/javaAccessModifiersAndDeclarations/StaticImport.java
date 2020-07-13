package javaAccessModifiersAndDeclarations;

import static java.lang.Math.sqrt;
import static java.lang.Math.*;
import static java.lang.String.valueOf;
public class StaticImport {
	public static void main(String[] args) {
		String b = valueOf(5); // Refers to String.valueOf(). Since static import is done.
		System.out.println(b);
		
		// Static import creates confusion.
	}
}
