package geometry;

import java.io.PrintStream;

public abstract class Shape implements Drawable {
   protected Point location;
   
   protected Shape(Point location) {
	   this.location = location;
   }
   
   public abstract double area();
   
   @Override
   public void draw(PrintStream pw) {
	   System.out.println("Drawing: " + toString());
	   System.out.println("Area: " + area());
   }
}
