package reflection;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Consumer;

public class ClassForName {
	public static void main(String[] args)
			throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Class<?> c = Class.forName("java.util.ArrayList");
		@SuppressWarnings({ "unchecked", "unused" })
		ArrayList<Integer> al = (ArrayList<Integer>) c.newInstance();
		// Get all public and object class methods.
		Method[] methods = c.getMethods();
		System.out.println("Public methods from ArrayList and Object class");
		Arrays.asList(methods).forEach((printMethodInfo));
		
		System.out.println("======================== ============================");
		System.out.println("Private methods from ArrayList and Object class");
		Method[] m = c.getDeclaredMethods();
		Arrays.asList(m).forEach((printMethodInfo));
	}

	private static Consumer<Method> printMethodInfo = new Consumer<Method>() {
		public void accept(Method m) {
			System.out.println("Method :- " + m.getName());
			System.out.println("From Class:- " + m.getDeclaringClass());
			System.out.println("From Runtime Class:- " + m.getClass());
		}
	};
	
	
}
