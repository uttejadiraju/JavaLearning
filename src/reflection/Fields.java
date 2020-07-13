package reflection;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.function.Consumer;

public class Fields {
	public String name = "uttej";

	public static void main(String[] args) {
		@SuppressWarnings("unused")
		Class<?> c = Fields.class;
		Field[] fields = c.getFields();
		Arrays.asList(fields).forEach((printFieldInfo));
	}

	private static Consumer<Field> printFieldInfo = new Consumer<Field>() {
		public void accept(Field f) {
			System.out.println("Field :- " + f.getName());
			System.out.println("Type:- " + f.getType());
		}
	};
}
