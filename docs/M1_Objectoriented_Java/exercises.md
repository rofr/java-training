# Exercises M1

## 1. Study and run the GeometryDemo program
Study the class, run it and examine the output. Note that:

- There is an abstract base class Shape
- There are subclasses Circle and Rectangle
- Is something missing in the Rectangle class? Add it!

## 2. Add a Triangle class
- Add a new kind of Shape, a Triangle. For simplicities sake only equilateral triangles are supported. You can represent a triangle with a base and a height. 
- Make sure you override toString()
- Modify the GeometryDemo program to include some triangles
- Print the total area of all the shapes

## 3. Add the Drawable interface (optional if time permits)
- Add the Drawable interface according to the slides
- Make all shapes Drawable, think about where to implement the interface
- Create an array of Drawable objects
- Loop over the drawables and call draw on each

Tip: Pass a reference to System.out when calling the draw() method