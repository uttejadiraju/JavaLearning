package lambdaExpressions.standardFunctionalInterfaces;

import java.util.List;

import java.util.function.Function;

import lambdaExpressions.Person;

public class FunctionInterfaceLambdaExpression {
	public static void main(String args[]) {
		List<Person> personsList = Person.getPersons();
		search(personsList, (Person p) -> p.getId());
	}

	public static void search(List<Person> person, Function<Person, String> tester) {
		for (Person p : person) {
			String data = tester.apply(p);
			System.out.println(data);
		}
	}

}
