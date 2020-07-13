package joshuaBloschCodes;

enum Operation {
	PLUS("+") {
		public double apply(double x, double y) {
			return x + y;
		}
	},
	MINUS("-") {
		public double apply(double x, double y) {
			return x - y;
		}
	},
	TIMES("*") {
		public double apply(double x, double y) {
			return x * y;
		}
	},
	DIVIDE("/") {
		public double apply(double x, double y) {
			return x / y;
		}
	};
	/**
	 * The enum constant MOD must implement the abstract method apply(double,
	 * double) MOD("%") {
	 * 
	 * };
	 **/
	private final String symbol;

	Operation(String symbol) {
		this.symbol = symbol;
	}

	@Override
	public String toString() {
		return symbol;
	}

	public abstract double apply(double x, double y);
}

public class EnumOperationExample {
	public static void main(String[] args) {
		double x = Double.parseDouble("1.1");
		double y = Double.parseDouble("1.2");
		for (Operation op : Operation.values())
			System.out.printf("%f	%s	%f	=	%f%n", x, op, y, op.apply(x, y));
	}
}
