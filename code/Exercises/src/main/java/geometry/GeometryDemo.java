package geometry;

import java.util.stream.Stream;

public class GeometryDemo {

	public static void main(String[] args) {
		Shape[] shapes = new Shape[10];
		
		System.out.println("Creating random shapes");
		for(int i = 0; i < 10; i++) {
			shapes[i] = randomShape(i);
		}
		
		//Taste of java 8 streams
		Stream.of(shapes).forEach(s -> System.out.println(s));
	
	}
	
	public static Shape randomShape(int i) {
		Point location = new Point(i++, i++);
		double r = Math.random();
		if (r > 0.5) return new Circle(location, i++);
		else return new Rectangle(location, i++, i++);
	}

}
