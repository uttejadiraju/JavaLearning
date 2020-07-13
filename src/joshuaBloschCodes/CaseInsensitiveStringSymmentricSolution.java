package joshuaBloschCodes;

public final class CaseInsensitiveStringSymmentricSolution {
	private final String s;

	public CaseInsensitiveStringSymmentricSolution(String s) {
		this.s = s;
	}

	// Solved symmetry!
	@Override
	public boolean equals(Object o) {

		return o instanceof CaseInsensitiveStringSymmentricSolution
				&& ((CaseInsensitiveStringSymmentricSolution) o).s.equalsIgnoreCase(s);
	}

	public static void main(String[] args) {
		CaseInsensitiveStringSymmentricSolution cis = new CaseInsensitiveStringSymmentricSolution("Polish");
		CaseInsensitiveStringSymmentricSolution cis1 = new CaseInsensitiveStringSymmentricSolution("polish");
		System.out.println(cis.equals(cis1));
		System.out.println(cis1.equals(cis));
	}

}

/**
 * Only objects of type CaseInsensitiveStringSymmentricSolution are compared
 */