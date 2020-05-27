package geometry;

import java.util.Comparator;

public class DescendingByArea implements Comparator<Shape> {
	
	@Override
	public int compare(Shape a, Shape b) {
		return (int) Math.signum(b.area() - a.area());
	}
}
