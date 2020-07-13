package lambdaExpressions;

import java.util.List;

public class SimpleSearch {
	public SimpleSearch() {

	}

	public static void main(String args[]) {
		List<Person> personsList = Person.getPersons();
		search(personsList, "69");
	}
	
	public static void search(List<Person> person, String key) {
		for (Person p : person) {
	        if (p.getId() == key) {
	            p.printPerson();
	        }
	    }
	}
}


