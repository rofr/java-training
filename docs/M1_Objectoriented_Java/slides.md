---
# Configurations
progress: true
controls: true
slideNumber: true
hideAddressBar: true
transition: 'slide' 
backgroundTransition: 'zoom'
---

# M1
## Object oriented java

Notes:
[Open in browser](https://mark.show/?source=https://github.com/rofr/java-training/raw/master/docs/M1_Objectoriented_java/slides.md)

---

# Contents
- Principles of OO
- Class definition and members
- Properties
- Inheritance
- Interface
- LAB: Geometry

Note: These are the topics covered in this module. Objects are building blocks that serve as components for large scale software development.

---

# Principles of OO
 - How humans represent the world
 - Ecapsulation
 - Composition
 - Inheritance
 - Polymorphism

---

# Class definition
```java
public class Car { 
  // members:
  //fields
  //methods
  //constructors
}```

---
# Properties
```java
public class Car {
    private int weight;

    public int getWeight() {
        return weight;
    }

    public void setWeight(int value) {
        if (weight < 100) throw new Exception();
        weight = value;
    }
}
```
---
# Inheritance
```java
public abstract class Shape {}

public class Circle extends Shape {}
```
---
# Interface
- An interface describes a contract
```java
public interface Drawable {
    void draw(PrintWriter pw);
}
```
Notes: Things that are drawable have a draw() method
___

# Interface implementation
```java
public class Shape implements Drawable {
    public void draw(PrintWriter pw) {
      pw.println(toString());
    }
}
```
# LAB!
Geometry
Time: 1 hour
