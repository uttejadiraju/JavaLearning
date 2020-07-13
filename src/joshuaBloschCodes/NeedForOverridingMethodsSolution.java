package joshuaBloschCodes;

import java.util.HashSet;
import java.util.Set;

public class NeedForOverridingMethodsSolution {
	private final char first;
	private final char second;

	public NeedForOverridingMethodsSolution(char first, char second) {
		this.first = first;
		this.second = second;
	}

	@Override
	public boolean equals(Object b) {
		if (!(b instanceof NeedForOverridingMethodsSolution)) {
			return false;
		}
		NeedForOverridingMethodsSolution bb = (NeedForOverridingMethodsSolution) b;
		return bb.first == first && bb.second == second;
	}

	public int hashCode() {
		return 31 * first + second;
	}

	public static void main(String[] args) {
		Set<NeedForOverridingMethodsSolution> s = new HashSet<>();
		for (int i = 0; i < 10; i++)
			for (char ch = 'a'; ch <= 'z'; ch++)
				s.add(new NeedForOverridingMethodsSolution(ch, ch));
		System.out.println(s.size());
	}
}

/***
 * You might expect the program to print 26, as sets cannot contain duplicates.
 * If you try running the program, you�ll find that it prints not 26 but 260.
 * What is wrong with it? the author of the Bigram class intended to override
 * the equals method (Item 10) and even remembered to override hashCode in
 * tandem (Item 11). Unfortunately, our hapless programmer failed to override
 * equals, overloading it instead (Item 52). To override Object.equals, you must
 * define an equals method whose parameter is of type Object, but the parameter
 * of Bigram�s equals method is not of type Object, so Bigram inherits the
 * equals method from Object. This equals method tests for object identity, just
 * like the == operator. Each of the ten copies of each bigram is distinct from
 * the other nine, so they are deemed unequal by Object.equals, which explains
 * why the program prints 260. Luckily, the compiler can help you find this
 * error, but only if you help it by telling it that you intend to override
 * Object.equals. To do this, annotate Bigram.equals with @Override,
 ***/