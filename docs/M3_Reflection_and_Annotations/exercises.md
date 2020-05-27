# Exercises M3

In this module you will implement a simple unit test framework and runner. Let's call it XUnit. We want to write tests like this:

```java
import static xunit.Assert.assertEquals;

public class CalculatorTests
{
    @Fact
    public void initialValueIsZero() {
        Calculator calculator = new Calculator();
        assertEquals(0, calculator.getValue());
    }

    @Fact
    public void positiveNumbersSumUp() {
        Calculator calculator = new Calculator();
        calculator.add(100);
        calculator.add(200);
        assertEquals(300, calculator.getValue());
    }
}
```

Some bits are already completed to let you focus on annotations and reflection.

## 1. Define the @Fact annotation
- Create the @Fact annotation type
- Add the annotation to the test methods

## 2. Implement the Runner
Complete the runner in xunit.Runner.
- Use reflection to load a Class object based on the named passed to the program
- Use reflection to find methods with the @Fact annotation
- Test methods must be public, void and take 0 arguments.
- Test methods must have a single constructor taking 0 arguments
- invoke each discovered test method using reflection, on a new instance of the test class for each test.
- reset the static test result fields on the Assert class before each run and check the result after
- Output the result of each test to the console

## 3. Extra tasks if time permits
- Add more assertion methods to the Assert class
- Write more tests
- Add an expectedException parameter to the @Fact annotation
