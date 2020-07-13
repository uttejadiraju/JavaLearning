package joshuaBloschCodes;

public class SymmentryEquals {

	public static void main(String[] args) {
		Point p = new Point(1,2);
		PointExtended p2 = new PointExtended(1, 2, Color.RED);
		
		System.out.println(p.equals(p2));
		System.out.println(p2.equals(p));
	}
}

class Point {
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

class PointExtended extends Point {

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
		if (!(o instanceof PointExtended)) {
			return false;
		}
		PointExtended p = (PointExtended) o;
		return super.equals(o) && (p).color == color;
	}

}
