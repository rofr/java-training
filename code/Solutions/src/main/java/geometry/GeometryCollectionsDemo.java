package geometry;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class GeometryCollectionsDemo {

	public static void main(String[] args) {
		final int numShapes = (int)(Math.random() * 10 + 10);
		Map<Integer,Shape> shapes = new TreeMap<>();
		
		System.out.println("Creating random shapes");
		for(int i = 0; i < numShapes; i++) {
			Shape shape = randomShape(i);
			shapes.put(i + 1, shape);
		}

		System.out.println("Display without sorting, should be by id");
		//Taste of java 8 streams
		shapes.values().stream().forEach(s -> System.out.println(s));

		System.out.println("Display sorted by area, smallest first");
		shapes.values()
				.stream()
				.sorted((a,b) -> byArea(a,b))
				.forEach(s -> System.out.println(s));

		double area = 0;
		for(Shape shape: shapes.values()) {
			area += shape.area();
		}
		
		System.out.println("Total area: " + area);
		
		for(Drawable shape: shapes.values()) {
			shape.draw(System.out);
		}
	}

	private static int byArea(Shape a, Shape b) {
		return (int) Math.signum(a.area()-b.area());
	}
	
	private static Shape randomShape(int i) {
		Point location = new Point(i++, i++);
		double r = Math.random();
		if (r > 2.0/3) return new Circle(location, i++);
		else if (r >= 1.0/3) return new Triangle(location, i++, i++);
		else return new Rectangle(location, i++, i++);
	}

}
