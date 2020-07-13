package lambdaExpressions;

import java.util.List;

public class SimpleSearchWithAnonymousClass {
	public SimpleSearchWithAnonymousClass() {

	}

	public static void main(String args[]) {
		List<Person> personsList = Person.getPersons();
		search(personsList, new CheckPerson() {
			public boolean test(Person p) {
				if (p.getId() == "82") {
					return true;
				}
				return false;
			}
		});
		personsList.stream().filter(p -> p.getId() != "").map(p -> p.getName()).forEach(name -> System.out.println(name));
	}


	private static void search(List<Person> person, CheckPerson check) {
		for (Person p : person) {
			if (check.test(p)) {
				System.out.println("Search Successfull!!!");
			}
		}
	}
}
