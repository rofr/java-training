package calculator;

public class CalculatorDemo {

	public static void main(String[] args) {
		
		Calculator calculator = new Calculator();
		
		calculator.add(randomInteger(100));
		calculator.add(randomInteger(100));
		calculator.add(randomInteger(100));
		calculator.add(randomInteger(100));
		calculator.add(randomInteger(100));

		System.out.println(calculator.getValue());
		calculator.reset();
		System.out.println(calculator.getValue());
	}
	
	private static int randomInteger(int n) {
		return (int)(Math.random() * n);
	}

}
