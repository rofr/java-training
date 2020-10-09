package geometry;

import java.io.PrintStream;

public abstract class Shape implements Drawable, Comparable<Shape> {
   protected Point location;
   protected int id;

   protected static int nextId = 1;

   protected Shape(Point location) {
       this.location = location;
       id = nextId++;
   }
   
   public abstract double area();
   
   @Override
   public void draw(PrintStream pw) {
	   System.out.println("Drawing: " + toString());
	   System.out.println("Area: " + area());
   }

   @Override
   public int compareTo(Shape other) {
       return id - other.id;
   }
}
