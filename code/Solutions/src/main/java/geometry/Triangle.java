package geometry;

public class Triangle extends Shape {

	private int width;
	private int height;
	
	
	public Triangle(Point location, int width, int height) {
		super(location);
		this.width = width;
		this.height = height;
	}

	@Override
	public double area() {
		return (width * height) / 2;
	}

	@Override
	public String toString() {
		return "Triangle [id= " + id +",width=" + width + ", height=" + height + ", location=" + location + "]";
	}

	
}
