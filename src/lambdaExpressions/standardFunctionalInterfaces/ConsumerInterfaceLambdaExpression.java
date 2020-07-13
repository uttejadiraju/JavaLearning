package lambdaExpressions.standardFunctionalInterfaces;

import java.util.List;
import java.util.function.Consumer;

import lambdaExpressions.Person;

public class ConsumerInterfaceLambdaExpression {
	public static void main(String args[]) {
		List<Person> personsList = Person.getPersons();
		personsList.stream().forEach(Person::printPerson);
		System.out.println();
		search(personsList, (p) -> System.out.println(p));
	}

	public static void search(List<Person> person, Consumer<Person> tester) {
		for (Person p : person) {
			tester.accept(p);
		}
	}

}
