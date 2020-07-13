package misc;

class Shadowing {
	static int size = 7;

	static void changeIt(int size) {
		size = size + 200;
		System.out.println("size in changeIt is " + size);
	}

	public static void main(String[] args) {
		Shadowing f = new Shadowing();
		System.out.println("size = " + size);
		changeIt(size);
		System.out.println("size after changeIt is " + size);
		f.b();
		System.out.println("size after changeIt is " + size);
	}

	public void b() {
		this.size = 1000;
	}
}
/**
 * Just when you think you've got it all figured out, you see a piece of code
 * with variables not behaving the way you think they should. You might have
 * stumbled into code with a shadowed variable. You can shadow a variable in
 * several ways. We'll look at one way that might trip you up: hiding a static
 * variable by shadowing it with a local variable. Shadowing involves reusing a
 * variable name that's already been declared somewhere else. The effect of
 * shadowing is to hide the previously declared variable in such a way that it
 * may look as though you're using the hidden variable, but you're actually
 * using the shadowing variable. You might find reasons to shadow a variable
 * intentionally, but typically it happens by accident and causes hard-to-find
 * bugs. On the exam, you can expect to see questions where shadowing plays a
 * role. You can shadow a variable by declaring a local variable of the same
 * name, either directly or as part of an argument:
 **/