package reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;

public class DynamicMethodInvocation {
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Class<DynamicMethodInvocation> c = DynamicMethodInvocation.class;
		try {
			Object o = c.newInstance();
			Method[] methods = c.getDeclaredMethods();
			Arrays.asList(methods).forEach((element) -> {
				try {
					String name = element.getName();
					if (name.equals("main")) {
						// No execution!!!
					} else if (name.equals("methodTry")){
						Object dmi = element.invoke(o, "hello", "world");
						if (dmi instanceof ArrayList) {
							System.out.println("Private method executed successfully!!!");
						}
					}
				} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
					e.printStackTrace();
				}

			});
		} catch (InstantiationException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@SuppressWarnings("unused")
	private ArrayList<String> methodTry(String a, String b) {
		ArrayList<String> list = new ArrayList<String>();
		list.add(a);
		list.add(b);
		return list;
	}
}
