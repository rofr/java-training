package geometry;

public abstract class Shape {
   protected Point location;
   
   protected Shape(Point location) {
	   this.location = location;
   }
   
   public abstract double area();
}
