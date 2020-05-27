package geometry;

public class Circle extends Shape {

	private final double radius;
	
	public Circle(Point location, double radius) {
		super(location);
		this.radius = radius;
	}

	@Override
	public String toString() {
		return "Circle [radius=" + radius + ", location=" + location + "]";
	}


	public double area() {
		return Math.PI * radius * radius;
	}
	
	
}
