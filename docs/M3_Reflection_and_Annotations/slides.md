---
# Configurations
progress: true
controls: true
slideNumber: true
hideAddressBar: true
transition: 'slide' 
backgroundTransition: 'zoom'
---

# M3
## Reflection and Annotations

Notes:
[Open in browser](https://mark.show/?source=https://github.com/rofr/java-training/raw/master/docs/M3_Reflection_and_Annotations/slides.md)

---

# Annotations
- Metadata attached to a target
- Targets: class, method, interface, field, constructor, etc
- Retention: source, class, runtime

---

# Parameters
- None: `@SpringBootApplication`
- Single: `@Test(expectedException=RuntimeException.class)`
- Value parameter: `@Author("Bob")`
- Explicit value: `@Author(value="Bob")`
- Multiple: `@Schedule(h="*", m="0", s="0")`

---

# Declaring and using an annotation
```java
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.CLASS)
public @interface Author {
    public String value();
}

@Author("Uncle Bob")
public class MyClass { }
```

---

# Reflection
- Metadata is included in the compiler output and can be accessed using code.
- Almost everything except local variables and statements is included with the byte code.

---

# The Class type
- `Class` is a type that represents information about a type.
- Methods give access to details: `getAnnotations()`, `getFields()`
 Obtain a `Class` instance using one of:
- `Class c = Class.forName("calculator.Calculator");`
- `Class c = Calculator.class;`
- `Class c = someObject.getClass();`

---

# Example
```java
  Class c = Class.forName("calculator.Calculator");
  Method[] methods = c.getDeclaredMethods();
  Object instance = c.newInstance();
  methods[0].invoke(instance, 200);
  methods[0].invoke(instance, 300);
  int value = (int) methods[1].invoke(instance);
  System.out.println("add 200, add 300, result=" + value);
```
---

# LAB!
Time: 1 hour
