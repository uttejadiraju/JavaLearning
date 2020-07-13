package lambdaExpressions.standardFunctionalInterfaces;

import java.util.function.*;
import java.util.*;

public class Functionalintefaces {
	private static Supplier<Integer> getRandom = () -> {
		return getValue();
	};
	

	public static void main(String[] args) {
		Supplier<String> sup = new BB();
		Custom.c();
		Custom d = () -> System.out.println("hero");
		d.b();
		d.e();
		System.out.println(sup.get());
		CustomPredicate pre = (input) -> input.contains("hey");
		pre.testing("heyyy");
		Functionalintefaces f = new Functionalintefaces();
		Supplier<Integer> my = () -> { return f.getValues();};
		Supplier<StringBuilder> s1 = StringBuilder::new;
		Supplier<StringBuilder> s2 = () -> new StringBuilder();
		System.out.println(s1.get().hashCode());
		System.out.println(s2.get().hashCode());
		s1.get().append("hello");

		StringBuilder sb = s2.get();
		System.out.println(sb.hashCode());

		System.out.println(getRandom.get());
		System.out.println(getRandom.get());
		System.out.println(getRandom.get());

		Consumer<String> c1 = System.out::println;
		Consumer<String> c2 = x -> System.out.println(x);

		c1.accept("Annie");
		c2.accept("Annie");

		Map<String, Integer> map = new HashMap<>();
		BiConsumer<String, Integer> b1 = map::put;
		BiConsumer<String, Integer> b2 = (k, v) -> map.put(k, v);

		b1.accept("chicken", 7);
		b2.accept("chick", 1);

		System.out.println(map);

		Predicate<String> p1 = String::isEmpty;
		Predicate<String> p2 = x -> x.isEmpty();
		System.out.println(p1.test(""));
		System.out.println(p2.test(""));

		Predicate<String> egg = s -> s.contains("egg");
		Predicate<String> brown = s -> s.contains("brown");

		// This works, but it’s not great. It’s a bit long to read, and it contains
		// duplication.
		Predicate<String> brownEggs = s -> s.contains("egg") && s.contains("brown");
		Predicate<String> otherEggs = s -> s.contains("egg") && !s.contains("brown");

		// Easy way

		Predicate<String> brownEggs1 = egg.and(brown);
		Predicate<String> otherEggs1 = egg.and(brown.negate());

		BiPredicate<String, String> b11 = String::startsWith;
		BiPredicate<String, String> b22 = (string, prefix) -> string.startsWith(prefix);
		System.out.println(b11.test("chicken", "chick"));
		System.out.println(b22.test("chicken", "chick"));

		Function<String, Integer> f1 = String::length;
		Function<String, Integer> f2 = x -> x.length();
		System.out.println(f1.apply("cluck")); // 5
		System.out.println(f2.apply("cluck")); // 5

		BiFunction<String, String, String> b111 = String::concat;
		BiFunction<String, String, String> b222 = (string, toAdd) -> string.concat(toAdd);
		System.out.println(b111.apply("baby ", "chick")); // baby chick
		System.out.println(b222.apply("baby ", "chick")); // baby chick

		UnaryOperator<String> u1 = String::toUpperCase;
		UnaryOperator<String> u2 = x -> x.toUpperCase();
		System.out.println(u1.apply("chirp"));
		System.out.println(u2.apply("chirp"));

		BinaryOperator<String> bu1 = String::concat;
		BinaryOperator<String> bu2 = (string, toAdd) -> string.concat(toAdd);
		System.out.println(bu1.apply("baby ", "chick")); // baby chick
		System.out.println(bu2.apply("baby ", "chick")); // baby chick
	}

	private static Integer getValue() {
		return 200;
	}
	
	private Integer getValues() {
		return 200;
	}
}

class BB implements Supplier<String> {

	@Override
	public String get() {
		return null;
	}
	
} 

@FunctionalInterface
interface Custom {
	abstract void b();
	static void c() {
		
	}
	default void e() {
		
	}
}

@FunctionalInterface
interface CustomPredicate {
	abstract boolean testing(String s);
	
}
/***
 * A Supplier is used when you want to generate or supply values without taking
 * any input.
 * 
 * Predicate is often used when filtering or matching. Both are very common
 * operations. A BiPredicate is just like a Predicate except that it takes two
 * parameters instead of one.
 * 
 * You use a Consumer when you want to do something with a parameter but not
 * return anything. BiConsumer does the same thing except that it takes two
 * parameters.
 * 
 * A Function is responsible for turning one parameter into a value of a
 * potentially different type and returning it.
 * 
 * Similarly, a BiFunction is responsible for turning two parameters into a
 * value and returning it.
 * 
 * UnaryOperator and BinaryOperator are a special case of a function. They
 * require all type parameters to be the same type. A UnaryOperator transforms
 * its value into one of the same type. For example, incrementing by one is a
 * unary operation. In fact, UnaryOperator extends Function. A BinaryOperator
 * merges two values into one of the same type. Adding two numbers is a binary
 * operation. Similarly, BinaryOperator extends BiFunction.
 **/
