package staticClasses;


public class ExampleStatic {
	static int x  = 0;
	final static int y  = 0;
	public static void main(String[] args) {
		ExampleStatic s = new ExampleStatic();
		s.x = 5;
		ExampleStatic s1 = new ExampleStatic();
		System.out.println(s1.x);
		s1.x = 15;
		System.out.println(s.x);
		
		//s.y = 5; Error.
		System.out.println(s1.y);
		// s1.y = 15; Error.
		System.out.println(s.y);
	}
}
