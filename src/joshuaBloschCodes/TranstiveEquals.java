package joshuaBloschCodes;

public class TranstiveEquals {

	static class Point {
		int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public boolean equals(Object o) {
			if (o == null) {
				return false;
			}
			if (this == o) {
				return true;
			}
			if (!(o instanceof Point)) {
				return false;
			}

			Point p = (Point) o;
			return p.x == x && p.y == y;
		}
	}

	enum Color {
		RED, GREEN, BLUE;
	}

	static class PointExtended extends Point {

		Color color;

		public PointExtended(int x, int y, Color color) {
			super(x, y);
			this.color = color;
		}

		public boolean equals(Object o) {
			if (o == null) {
				return false;
			}
			if (this == o) {
				return true;
			}

			if (o instanceof Point) {
				return o.equals(this);
			}

			if (!(o instanceof PointExtended)) {
				return false;
			}

			return super.equals(o) && ((PointExtended) o).color == color;
		}

	}

	public static void main(String[] args) {
		Point p = new Point(1, 2);
		PointExtended p1 = new PointExtended(1, 2, Color.RED);
		PointExtended p2 = new PointExtended(1, 2, Color.BLUE);
		
		// x == y && y == x
		System.out.println(p.equals(p1));
		System.out.println(p1.equals(p));
		
		// y == z && z == y
		System.out.println(p1.equals(p2));
		System.out.println(p2.equals(p1));
		
		
		System.out.println(p.equals(p1));
		System.out.println(p1.equals(p));
	}
}
