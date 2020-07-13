package lambdaExpressions.standardFunctionalInterfaces;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

import lambdaExpressions.Person;

public class InterfacesInLambdaExpression {
	public static void main(String args[]) {
		List<Person> personsList = Person.getPersons();
		search(personsList, Person::getId, (Person p) -> p.getId() == "69",
				(String result) -> System.out.println(result));
	}

	public static void search(List<Person> person, Function<Person, String> func, Predicate<Person> pred,
			Consumer<String> cons) {
		for (Person p : person) {
			if (pred.test(p)) {
				String data = func.apply(p);
				cons.accept(data);
				System.out.println(data);
			}

		}
	}

}
