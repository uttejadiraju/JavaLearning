package protectedTestingOther;

import protectedTesting.Parent;

class Child extends Parent {
	public void testIt() {
		System.out.println("x is " + x); // No problem; Child // inherits x
		@SuppressWarnings("unused")
		Parent p = new Parent();
		// Can we access x
		// using // the p reference?
		// Compiler error! System.out.println("X in parent is " + p.x);
	}
}

/***
 * But there's still one more issue we haven't looked at: What does a protected
 * member look like to other classes trying to use the
 * subclass-outside-the-package to get to the subclass' inherited protected
 * superclass member? For example, using our previous Parent/Child classes, what
 * happens if some other class—Neighbor, say—in the same package as the Child
 * (subclass), has a reference to a Child instance and wants to access the
 * member variable x ? In other words, how does that protected member behave
 * once the subclass has inherited it? Does it maintain its protected status,
 * such that classes in the Child's package can see it? No! Once the
 * subclass-outside-the-package inherits the protected member, that member (as
 * inherited by the subclass) becomes private to any code outside the subclass,
 * with the exception of subclasses of the subclass. So if class Neighbor
 * instantiates a Child object, then even if class Neighbor is in the same
 * package as class Child, class Neighbor won't have access to the Child's
 * inherited (but protected) variable x
 ***/