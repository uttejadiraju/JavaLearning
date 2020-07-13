package lambdaExpressions;

import java.util.List;

public class SimpleSearchWithLocalClasses {
	public SimpleSearchWithLocalClasses() {

	}

	public static void main(String args[]) {
		List<Person> personsList = Person.getPersons();
		SimpleSearchWithLocalClasses obj = new SimpleSearchWithLocalClasses();
		search(personsList, obj.new Validator());
	}

	class Validator implements CheckPerson {
		public boolean test(Person p) {
			if (p.getId() == "69") {
				return true;
			}
			return false;
		}
	}

	public static void search(List<Person> person, CheckPerson check) {
		for (Person p : person) {
			if (check.test(p)) {
				System.out.println("Search Successfull!!!");
			}
		}
	}
}
