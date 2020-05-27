package calculator;

import java.lang.reflect.Method;

public class ReflectionDemo {

	public static void main(String[] args) throws Exception {
	   Class c = Class.forName("calculator.Calculator");
	   Method[] methods = c.getDeclaredMethods();
	   Object instance = c.newInstance();
	   methods[0].invoke(instance, 200);
	   methods[0].invoke(instance, 300);
	   int value = (int) methods[1].invoke(instance);
	   System.out.println("add 200, add 300, result=" + value);
	}
}
