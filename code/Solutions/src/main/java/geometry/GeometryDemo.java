package geometry;

import java.util.stream.Stream;

public class GeometryDemo {

	public static void main(String[] args) {
		final int numShapes = 20;
		Shape[] shapes = new Shape[numShapes];
		
		System.out.println("Creating random shapes");
		for(int i = 0; i < numShapes; i++) {
			shapes[i] = randomShape(i);
		}
		
		//Taste of java 8 streams
		Stream.of(shapes).forEach(s -> System.out.println(s));
		
		//todo: Calculate and print total area of all shapes
		double area = 0;
		for(Shape shape: shapes) {
			area += shape.area();
		}
		System.out.println("Total area: " + area);
	}
	
	private static Shape randomShape(int i) {
		Point location = new Point(i++, i++);
		double r = Math.random();
		if (r > 2.0/3) return new Circle(location, i++);
		else if (r >= 1.0/3) return new Triangle(location, i++, i++);
		else return new Rectangle(location, i++, i++);
	}

}
