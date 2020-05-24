# Module 7 - Automated test using TestNG

[Open with mark.show](https://mark.show?source=https://github.com/rofr/java-training/blob/master/docs/M7_TestNG/README.md)

TestNG is a testing framework inspired from JUnit and NUnit but introducing some new functionalities that make it more powerful and easier to use, such as:

* Annotations.
* Run your tests in arbitrarily big thread pools with various policies available (all methods in their own thread, one thread per test class, etc...).
* Test that your code is multithread safe.
* Flexible test configuration.
* Support for data-driven testing (with @DataProvider).
* Support for parameters.
* Powerful execution model (no more TestSuite).
* Supported by a variety of tools and plug-ins (Eclipse, IDEA, Maven, etc...).
* Embeds BeanShell for further flexibility.
* Default JDK functions for runtime and logging (no dependencies).
* Dependent methods for application server testing.
* TestNG is designed to cover all categories of tests:  unit, functional, end-to-end, integration, etc...

I started TestNG out of frustration for some JUnit deficiencies which I have documented on my weblog here and here Reading these entries might give you a better idea of the goal I am trying to achieve with TestNG.  You can also check out a quick overview of the main features and an article describing a very concrete example where the combined use of several TestNG's features provides for a very intuitive and maintainable testing design.

## Reading materials and guides

* [TestNG documentation](https://testng.org/doc/)

* [Working with IntelliJ IDEA](https://testng.org/doc/idea.html)

* [Working with Eclipse](https://testng.org/doc/eclipse.html)

* [TestNG and Maven](https://testng.org/doc/maven.html)

* [API Documentation](https://javadoc.jitpack.io/com/github/cbeust/testng/master/javadoc/)