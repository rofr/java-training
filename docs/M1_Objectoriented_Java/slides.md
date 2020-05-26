---
# Configurations
progress: true
controls: true
slideNumber: true
hideAddressBar: true
transition: 'slide' 
backgroundTransition: 'zoom'
---

# M0
## Course Introduction

Notes:
[Open in browser](https://mark.show/?source=https://github.com/rofr/java-training/blob/master/docs/M0_Introduction/slides.md)

---

# Contents
- Introduction
- Java Review
- Objects
- Heap and Stack
- LAB: ?

Note: These are the topics covered in this module

---

# Introduction
 - Your instructor
 - Materials
 - Environment
 - Format and timings

Notes: 
- Instructor presentation
- Review the top level README document
---

# Java Review
- Created 1995
- Write once , run anywhere
- Interpreted, runs on a JVM
- Garbage collection

---
# JRE Java Runtime Environment
- JVM
- Class library

Notes: The class library contains a large number of reusable components 
---
#
---

# Hello world
```java
package m0.hello;

public class Hello
{
    public static void main(String[] args) {
        double result = Math.sqrt(81);
        System.out.println("The square root of 81 is " + result);
    }
}
```
Notes: Talk through the parts of the program, focus on static methods on the math class
---

# A calculator example
```java
  int a = 100;
  int b = 200;
  Calculator calculator = new Calculator();
  calculator.add(a);
  calculator.add(b);
  calculator.reset();
```
Notes: Focus on the object instance and it's state compared to static methods on the math class. The object has state and operations.
---

# Heap and stack
- The heap is where all objects are kept
- The stack is used for local method variables and parameters

Notes: Think about the code on the previous slide. The calculator object is on the heap. The variables a, b and calculator are on the stack. 
---
# Calculator implementation

```java
public class Calculator {
    private int value;

    public void add(int a ) {
        value += a;
    }

    public int getValue() {
        return value;
    }

    public void reset() {
        value = 0;
    }
}
```
Notes: Th
---
