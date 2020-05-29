package geometry;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

public class GeometryDemo {

	public static void main(String[] args) {
		List<Shape> shapes = new LinkedList<>();
		
		System.out.println("Creating random shapes");
		for(int i = 0; i < 797; i++) {
			Shape s = randomShape(i);
			shapes.add(s);
		}
		
		//Taste of java 8 streams
		shapes.stream().forEach(s -> System.out.println(s));
	}
	
	public static Shape randomShape(int i) {
		Point location = new Point(i++, i++);
		double r = Math.random();
		if (r > 0.5) return new Circle(location, i++);
		else return new Rectangle(location, i++, i++);
	}

}
