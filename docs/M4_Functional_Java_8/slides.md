---
# Configurations
progress: true
controls: true
slideNumber: true
hideAddressBar: true
transition: 'slide' 
backgroundTransition: 'zoom'
---

# M4
## Java 8 functional extensions

Notes:
[Open in browser](https://mark.show/?source=https://github.com/rofr/java-training/raw/master/docs/M4_Functional_Java_8/slides.md)

---

# Contents
- Signatures and functional notation
- Functional interfaces
- Lambda expressions
- Method references
- Streams
Notes: The topics covered in this module

---

# Method Signatures
- Return type
- Number of arguments and types
- `void add(int value)` int -> void
- `double sqrt(double n)` double -> double
- `int add(int a, int b)` (int,int) -> int
Notes: Every method has a signature, we can represent the signature using functional notation: arg_types -> result_type

---

# Named functional signatures
- `Supplier<String>`: () -> String
- `Consumer<Integer>`: int -> void 
- `Function<String,Double>`: String -> double
- `BiFunction<Float, Float, Integer>`: (float, float) -> int
- `Predicate<String>`: String -> boolean

---

# Functional interfaces
- interface with a single method
- Annotated with @FunctionalInterface
- 
```java
@FunctionalInterface
public interface Function<T, U> {
  U apply(T input);
}
```

---

# Lambdas
- A lambda is an anonymous method with a signature matching a functional interface.
- argument names and types, method body
```java
BiFunction<Integer,Integer, Integer> addition
   = (Integer a, Integer b) -> { return a + b; };
```

---

# Lambdas simplified
- parameter types can often be deduced by the compiler from the surrounding context
- method body with single statement does nor require curlies {}
- return keyword can also be skipped if single statement
- parenthesis can be dropped when there is a single argument
```java
BiFunction<Integer,Integer,Integer> addition =
   (a,b) -> a + b;
```

---

# Lambdas as callbacks
- Lambdas are typically used as callbacks
  `numbers.stream().filter(n -> n > 4)`

---

# Method references
- A method reference can be used in place of a lambda
- `Consumer<Integer> c = calculator::add`
- `BiConsumer<Calculator, Integer> bc = Calculator::add`
Notes: See example code

---
# Streams
See PDF T1414 shared in the chat

# LAB!
Time: 1 hour
