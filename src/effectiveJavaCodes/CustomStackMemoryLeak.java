package effectiveJavaCodes;

import java.util.Arrays;
import java.util.Collections;
import java.util.EmptyStackException;
import java.util.Stack;

public class CustomStackMemoryLeak {
	class StackCustom {
		private Object[] elements;
		private int size = 0;
		private static final int DEFAULT_INITIAL_CAPACITY = 16;

		public StackCustom() {
			this.elements = new Object[StackCustom.DEFAULT_INITIAL_CAPACITY];
		}

		public void push(Object e) {
			ensureCapacity();
			elements[size++] = e;
		}

		private void ensureCapacity() {
			if (elements.length == size) {
				elements = Arrays.copyOf(elements, size * 2 + 1);
			}
		}

		public Object pop() {
			if (size == 0) {
				throw new EmptyStackException();
			}
			return elements[--size];
			/**
			 * public Object pop() { if (size == 0) throw new EmptyStackException(); Object
			 * result = elements[--size]; elements[size] = null; // Eliminate obsolete
			 * reference return result; }
			 */
		}
	}

	public static void main(String[] args) {
		CustomStackMemoryLeak c = new CustomStackMemoryLeak();
		StackCustom obj = c.new StackCustom();
		obj.push(12);
		for (Object o : obj.elements) {
			System.out.println(o);
		}
		Stack<Integer> stac = new Stack<Integer>();
		Collections.sort(stac);
		stac.push(5);
		for (int v : stac) {
			System.out.println(v);
		}
	}
}

/**
 * So where is the memory leak? If a stack grows and then shrinks, the objects
 * that were popped off the stack will not be garbage collected, even if the
 * program using the stack has no more references to them. This is because the
 * stack maintains obsolete references to these objects. An obsolete reference
 * is 46 simply a reference that will never be dereferenced again. In this case,
 * any references outside of the “active portion” of the element array are
 * obsolete. The active portion consists of the elements whose index is less
 * than size. Memory leaks in garbage-collected languages (more properly known
 * as unintentional object retentions) are insidious. If an object reference is
 * unintentionally retained, not only is that object excluded from garbage
 * collection, but so too are any objects referenced by that object, and so on.
 * Even if only a few object references are unintentionally retained, many, many
 * objects may be prevented from being garbage collected, with potentially large
 * effects on performance. The fix for this sort of problem is simple: null out
 * references once they become obsolete. In the case of our Stack class, the
 * reference to an item becomes obsolete as soon as it’s popped off the stack.
 **/