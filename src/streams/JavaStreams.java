package streams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.TreeSet;
import java.util.function.Predicate;
import java.util.stream.*;

public class JavaStreams {
	public static void main(String[] args) {
		Stream<String> empty = Stream.empty(); // count = 0
		Stream<Integer> singleElement = Stream.of(1); // count = 1
		Stream<Integer> fromArray = Stream.of(1, 2, 3); // count = 2

		// Infinite streams
		Stream<Double> randoms = Stream.generate(Math::random);
		Stream<Integer> oddNumbers = Stream.iterate(1, n -> n + 2);

		Stream<String> s = Stream.of("monkey", "gorilla", "bonobo");
		System.out.println(s.count()); // 3

		Stream<String> ss = Stream.of("monkey", "ape", "bonobo");
		Optional<String> min = ss.min((s1, s2) -> s1.length() - s2.length());
		min.ifPresent(System.out::println); // ape

		Optional<?> minEmpty = Stream.empty().min((s1, s2) -> 0);
		System.out.println(minEmpty.isPresent()); // false

		Stream<String> sss = Stream.of("monkey", "gorilla", "bonobo");
		Stream<String> infinite = Stream.generate(() -> "chimp");
		sss.findAny().ifPresent(System.out::println); // monkey
		infinite.findAny().ifPresent(System.out::println); // chimp

		List<String> list = Arrays.asList("monkey", "2", "chimp");
		Stream<String> infinites = Stream.generate(() -> "chimp");
		Predicate<String> pred = x -> Character.isLetter(x.charAt(0));
		System.out.println(list.stream().anyMatch(pred)); // true
		System.out.println(list.stream().allMatch(pred)); // false
		System.out.println(list.stream().noneMatch(pred)); // false
		System.out.println(infinites.anyMatch(pred)); // true

		Stream<String> s1 = Stream.of("Monkey", "Gorilla", "Bonobo");
		s1.forEach(System.out::print); // MonkeyGorillaBonobo

		Stream<String> stream = Stream.of("w", "o", "l", "f");
		String word = stream.reduce("", (ss1, c) -> ss1 + c);
		System.out.println(word); // wolf

		Stream<String> streams = Stream.of("w", "o", "l", "f");
		String words = streams.reduce("", String::concat);
		System.out.println(words); // wolf

		Stream<String> streamTree = Stream.of("w", "o", "l", "f");
		TreeSet<String> set = streamTree.collect(TreeSet::new, TreeSet::add, TreeSet::addAll);
		System.out.println(set); // [f, l, o, w]

		Stream<String> s2 = Stream.of("monkey", "gorilla", "bonobo");
		s2.filter(x -> x.startsWith("m")).forEach(System.out::print); // monkey

		Stream<String> s3 = Stream.of("duck", "duck", "duck", "goose");
		s3.distinct().forEach(System.out::print); // duckgoose

		Stream<Integer> s4 = Stream.iterate(1, n -> n + 1);
		s4.skip(5).limit(2).forEach(System.out::print); // 67

		Stream<String> s5 = Stream.of("monkey", "gorilla", "bonobo");
		s5.map(String::length).forEach(System.out::print); // 676

		/**
		 * Output:- Bonobo Mama Gorilla Baby Gorilla
		 */
		List<String> zero = Arrays.asList();
		List<String> one = Arrays.asList("Bonobo");
		List<String> two = Arrays.asList("Mama Gorilla", "Baby Gorilla");
		Stream<List<String>> animals = Stream.of(zero, one, two);
		animals.flatMap(l -> l.stream()).forEach(System.out::println);

	}
}
