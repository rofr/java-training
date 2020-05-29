package calculator;

import static xunit.Assert.assertEquals;
import xunit.Fact;

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
	
	@Fact
	public void failingTest() {
		assertEquals(6,9);
	}
	
	@Fact(expectedException=RuntimeException.class)
	public void throwingTest() {
		throw new RuntimeException("Gotcha!");
	}

	@Fact(expectedException=RuntimeException.class)
	public void throwingWrongExceptionTest() {
		throw new IllegalArgumentException("Gotcha!");
	}
	
	@Fact
	public void noAssertion() {
		
	}
}
