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

---

# Contents
- Example test
- Annotations
- TestNg xml file
- Running tests
- 

Note: These are the topics covered in this module

---

# Example test
TBD

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
  <test name="Nopackage" >
    <classes>
       <class name="NoPackageTest" />
    </classes>
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
