package geometry;

public abstract class Shape implements Comparable<Shape>
{
   protected Point location;
   
   protected Shape(Point location) {
	   this.location = location;
   }
   
   public abstract double area();

   public int compareTo(Shape other) {
      return (int) Math.signum(area() - other.area());
   }

}
