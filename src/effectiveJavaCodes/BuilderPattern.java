package effectiveJavaCodes;

public class BuilderPattern {
	private final int rollNo;
	private final String name;
	private final String dept;
	private final String address;

	public static class Builder {
		private final int rollNo;
		private final String name;

		// Optional parameters.
		private String dept;
		private String address;

		public Builder(int rollNo, String name) {
			this.rollNo = rollNo;
			this.name = name;
		}

		public Builder dept(String v) {
			dept = v;
			return this;
		}

		public Builder address(String v) {
			this.address = v;
			return this;
		}

		public BuilderPattern build() {
			return new BuilderPattern(this);
		}
	}

	private BuilderPattern(Builder builder) {
		this.rollNo = builder.rollNo;
		this.name = builder.name;
		this.dept = builder.dept;
		this.address = builder.address;
	}

	public static void main(String[] args) {
		BuilderPattern full = new BuilderPattern.Builder(82, "uttej").dept("IT").address("hyd").build();
		BuilderPattern half = new BuilderPattern.Builder(69, "manoj").dept("IT").build();
		BuilderPattern empty = new BuilderPattern.Builder(93, "vamshi").build();
	}
}
