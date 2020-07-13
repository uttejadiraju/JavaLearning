package Tricky;

public class Snippet {
	List<String> list = new LinkedList<>();
	list.add("Archie");
	list.add("X-Men");
	Stream<String> s = list.stream();
	
	
	
	
	ArrayDeque<Integer> dice = new ArrayDeque<>();
	dice.offer(3);
	dice.offer(2);
	dice.offer(4);
	System.out.print(dice.stream().filter(n -> n != 4));
	s.forEach(System.out::println);
	s.forEach(System.out::println);
}
