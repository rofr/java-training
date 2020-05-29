package geometry;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ComparisonDemo {
	public static void main(String[] args) {

		//Shows that Integer is Comparable
		Class[] interfaces = Integer.class.getInterfaces();
		for(Class c : interfaces) {
			System.out.println(c);
		}

		//Comparable and it will sort
		List<Integer> numbers = Arrays.asList(4,7,3,2,9);
		Collections.sort(numbers);
		
		Point location = new Point(10,20);
		ArrayList<Circle> circles
				= new ArrayList<Circle>();
		circles.add(new Circle(location, 30));
		circles.add(new Circle(location, 40));
		circles.add(new Circle(location, 20));

		System.out.println("Ascending (default)");
		Collections.sort(circles);
		for (Circle c: circles) {
			System.out.println(c);
		}

		System.out.println("Descending");
		Collections.sort(circles, (a,b) -> -a.compareTo(b));
		for (Circle c: circles) {
			System.out.println(c);
		}
	}
}
