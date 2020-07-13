package lambdaExpressions.standardFunctionalInterfaces;

import java.util.List;
import java.util.function.Predicate;

import lambdaExpressions.Person;

public class PredicateInterfaceLambdaExpression {
	public static void main(String args[]) {
		List<Person> personsList = Person.getPersons();
		search(personsList, (Person p) -> p.getId() == "69");
	}

	public static void search(List<Person> person, Predicate<Person> tester) {
		for (Person p : person) {
			if (tester.test(p)) {
				System.out.println("Search Successfull!!!");
			}
		}
	}

}
