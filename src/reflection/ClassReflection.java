package reflection;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.function.Consumer;

public class ClassReflection {
	public static void main(String[] args) {
		Class<ClassReflection> c = ClassReflection.class;
		System.out.println(c.getName());
		Method[] methods = c.getMethods();
		// Get all public methods from base to parent class.
		System.out.println("Methods from ClassReflection and Object class");
		Arrays.asList(methods).forEach((print));
	}

	private static Consumer<Method> print = new Consumer<Method>() {

		@Override
		public void accept(Method m) {
			System.out.println("Method :- " + m.getName());
			System.out.println("From Class:- " + m.getDeclaringClass());
			System.out.println("From Runtime Class:- " + m.getClass());
		}

	};

	private void method() {

	}

	public void method1() {

	}
}
