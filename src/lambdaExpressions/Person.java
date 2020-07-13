package lambdaExpressions;

import java.util.ArrayList;
import java.util.List;

public class Person {
	private String name, id;

	Person(String name, String id) {
		this.name = name;
		this.id = id;
	}

	public static List<Person> getPersons(){
		List<Person> personList = new ArrayList<Person>();
		personList.add(new Person("Uttej", "82"));
		personList.add(new Person("Manoj", "69"));
		return personList;
	}
	
	public void printPerson() {
		System.out.println(name);
	}
	
	public String getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
}