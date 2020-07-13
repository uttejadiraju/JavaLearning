package classes;

public class NonStaticBlock {
	{
		System.out.println("Hello!!!");
	}

	public NonStaticBlock() {
		System.out.println("INside cosntructor");
	}

	public static void main(String[] args) {
		System.out.println("BEFORE OBJECT CREATION!!");
		NonStaticBlock b = new NonStaticBlock();
	}
}
/**
 * The non-static initializer block is when the object is constructed but before
 * any properties are injected. The non-static initializer block is actually
 * copied to the constructor.
 **/