package reflection;

import java.lang.reflect.Field;
import java.util.Arrays;

public class GetAndSetOnFields {
	public String name = "uttej";
	@SuppressWarnings("unused")
	private char arr[] = { 'a' };
	@SuppressWarnings("unused")
	private final int rollNo = 82;

	public static void main(String[] args) {
		Class<GetAndSetOnFields> c = GetAndSetOnFields.class;
		Field[] fields = c.getDeclaredFields();
		GetAndSetOnFields obj = new GetAndSetOnFields();
		Arrays.asList(fields).forEach((element) -> {
			try {
				System.out.println("Before!!! :- ");
				System.out.println(element.getName());
				System.out.println(element.get(obj));
				// For final fields, we have to set element.setAcc..(true). since,
				// element.isACC..() is false.
				element.setAccessible(element.isAccessible() == true ? false : true);
			} catch (IllegalArgumentException | IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		Arrays.asList(fields).forEach((element) -> {
			try {
				System.out.println("After!!! :- ");
				System.out.println(element.getName());
				if (element.getName() == "name") {
					element.set(obj, "manoj");
					System.out.println(element.get(obj));
				} else if (element.getName() == "arr") {
					char[] v = { 'b' };
					element.set(obj, v);
					v = (char[]) element.get(obj);
					System.out.println(v[0]);
				} else {
					element.set(obj, 69);
					System.out.println(element.get(obj));
				}

			} catch (IllegalArgumentException | IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
	}
}
