package calculator;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

public class CalculatorNgTests {

	@Test
	public void add() {
		Calculator calculator = new Calculator();
		calculator.add(100);
		assertEquals(calculator.getValue(), 100);
	}	
}
