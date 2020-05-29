---
# Configurations
progress: true
controls: true
slideNumber: true
hideAddressBar: true
transition: 'slide' 
backgroundTransition: 'zoom'
---

# M7
## Testautomation with TestNG

Notes:
[Open in browser](https://mark.show/?source=https://github.com/rofr/java-training/raw/master/docs/M7_TestNG/slides.md)
---

# Contents
- Example test
- Annotations
- Running tests
- TestNg xml file

Note: These are the topics covered in this module

---

# Example test
```java
public class CalculatorNgTests {

	@Test
	public void add() {
		Calculator calculator = new Calculator();
		calculator.add(100);
		assertEquals(calculator.getValue(), 100);
	}	
}
```

---

# Annotations
 - @Test
 - @BeforeTest
 - @BeforeClass

Note: The most common annotations. See materials for a full reference.

---

# Running tests
 - Ant
 - Command line
 - Eclipse / IntelliJ plugin
 - Jenkins

---

# testng.xml

```xml
<!DOCTYPE suite SYSTEM "https://testng.org/testng-1.0.dtd" >
  
<suite name="Suite1" verbose="1" >
  <test name="Geometry">
    <packages>
      <package name="geometry" />
   </packages>
 </test>
  <test name="Regression1">
    <classes>
      <class name="test.sample.ParameterSample"/>
      <class name="test.sample.ParameterTest"/>
    </classes>
  </test>
</suite>

``` 
---

# M7 LAB
- Running and authoring tests
- 30 minutes

