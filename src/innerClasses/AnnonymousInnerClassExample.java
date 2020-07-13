package innerClasses;

public class AnnonymousInnerClassExample {
	public static void main(String[] args) {
		Food f = new Food();
		f.popIt();
	}
}

class Popcorn {
	public void pop() {
		System.out.println("popcorn");
	}
}

class Food {
	Popcorn p = new Popcorn() {
		public void sizzle() {
			System.out.println("anonymous sizzling popcorn");
		}
		
		@Override
		public void pop() {
			System.out.println("anonymous popcorn");
		}
	};

	public void popIt() {
		p.pop();
		// OK, Popcorn has a pop() method
		// p.sizzle(); // Not Legal! Popcorn does not have sizzle();
	}
}