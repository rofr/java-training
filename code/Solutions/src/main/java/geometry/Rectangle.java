package geometry;

public class Rectangle extends Shape {
	private final int width;
	private final int height;
	
	public Rectangle(Point location, int w, int h) {
		super(location);
		width = w;
		height = h;
	}
	
	public double area() {
		return width * height;
	}

	@Override
	public String toString() {
		return "Rectangle [width=" + width + ", height=" + height + ", location=" + location + "]";
	}
}
