package lambdaExpressions;

import java.util.List;

public class SimpleSearchWithLambdaExpression {
	public SimpleSearchWithLambdaExpression() {

	}

	public static void main(String args[]) {
		List<Person> personsList = Person.getPersons();
		search(personsList, (Person p) -> p.getId() == "82");
	}


	public static void search(List<Person> person, CheckPerson check) {
		for (Person p : person) {
			if (check.test(p)) {
				System.out.println("Search Successfull!!!");
			}
		}
	}
}
