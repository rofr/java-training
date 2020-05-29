package xunit;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class Runner {

	public static void main(String[] args) {
		
		try {
			//Let's pretend this string is passed as an argument
			String className = "calculator.CalculatorTests";
			
			//TODO: use reflection to create a Class object
			Class c = Class.forName(className);
			
			for(Method m : c.getDeclaredMethods()) {
				
				 Fact fact = m.getAnnotation(Fact.class);
				 if (fact == null) continue;
				 
				 boolean expectsException 
				 	= fact.expectedException() != DummyException.class;
			
				 boolean expectedExceptionWasThrown = false;
				 
				if (!signatureIsValid(m)) {
					Assert.ok = false;
					Assert.message = "Invalid test method, must be public void and take 0 arguments";
					reportResult(m);
					continue;
				}

				Object testInstance = c.newInstance();
				Assert.reset();

				try {
					m.invoke(testInstance);
				} catch (InvocationTargetException ex) {
					if (ex.getTargetException().getClass() == fact.expectedException()) {
						expectedExceptionWasThrown = true;
						Assert.ok = true;
					} else {
						Assert.ok = false;
						Assert.message = "threw exception: " + ex.getClass();						
					}
				} catch(Exception ex) {
					Assert.ok = false;
					Assert.message = "Unexpected exception: " + ex.getClass();
				}
				
				if (expectsException && ! expectedExceptionWasThrown) {
					Assert.ok = false;
					Assert.message = "Expected " + fact.expectedException();
				}
				
				reportResult(m);				
			}

			//TODO: Run each test and write the result to the console
			
		} catch (Exception ex) {
			System.out.println("Unexpected exception in runner");
			ex.printStackTrace();
		}
	}

	private static boolean signatureIsValid(Method m) {
		
		int modifiers = m.getModifiers();
		
		boolean isValid = m.getParameterCount() == 0
				&& m.getReturnType() == void.class
				&& Modifier.isPublic(modifiers)
				&& ! Modifier.isStatic(modifiers);
		
		return isValid;
	}

	private static void reportResult(Method m) {
		String name = m.getName();
		if (Assert.ok) {
			System.out.println("OK     : " + name);
		} else {
			System.out.println("FAIL   : " + name + ", " + Assert.message);
		}
	}

}
