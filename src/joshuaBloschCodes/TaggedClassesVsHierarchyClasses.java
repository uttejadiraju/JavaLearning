package joshuaBloschCodes;

public class TaggedClassesVsHierarchyClasses {
	enum Shape {
		RECTANGLE, CIRCLE
	};

	final Shape shape;

	double length;
	double width;

	double radius;

	TaggedClassesVsHierarchyClasses(double radius) {
		shape = Shape.CIRCLE;
		this.radius = radius;
	}

	TaggedClassesVsHierarchyClasses(double length, double width) {
		shape = Shape.RECTANGLE;
		this.length = length;
		this.width = width;
	}

	double area() {
		switch (shape) {
		case RECTANGLE:
			return length * width;
		case CIRCLE:
			return Math.PI * (radius * radius);
		default:
			throw new AssertionError(shape);
		}
	}

	public static void main(String[] args) {

	}
}

abstract class HierarchyClass {
	abstract double area();
}

class Circle extends HierarchyClass {
	final double radius;

	Circle(double radius) {
		this.radius = radius;
	}

	@Override
	double area() {
		return Math.PI * (radius * radius);
	}
}

class Rectangle extends HierarchyClass {
	final double length;
	final double width;

	Rectangle(double length, double width) {
		this.length = length;
		this.width = width;
	}

	@Override
	double area() {
		return length * width;
	}
}
