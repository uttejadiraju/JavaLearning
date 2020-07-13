package javaAccessModifiersAndDeclarations;

import java.util.ArrayList; // Explicit.
import java.util.ArrayList.*; // Implicit. Never recommended. Bad practice !!! May create confusion to search
							  // Reduces readability.
import java.util.ArrayList.*; // No use. No classes inside ArrayList !!!.
// After package name class is needed.  or *  is needed import java.util;
// After class name semicolon is needed
public class ExplicitAndImplicitClassImport {
	public static void main(String[] args) {
		java.util.ArrayList<Integer> al = new java.util.ArrayList<Integer>(); // Fully Qualified name.
		
	}
	
	class child extends java.rmi.ServerError { // No error. no package import necessary.. used fully qualified name;

		public child(String s, Error err) {
			super(s, err);
			// TODO Auto-generated constructor stub
		}
		
	}
}
