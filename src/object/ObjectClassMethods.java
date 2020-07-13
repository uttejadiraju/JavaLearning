package object;

import java.lang.reflect.*;

public class ObjectClassMethods {
	public static void main(String args[]) throws Exception {
		Class c = Class.forName("java.lang.Object");
		Method[] m = c.getDeclaredMethods();
		for (Method method : m) {
			System.out.println(method);
		}
	}
}
