package calculator;

public class CalculatorDemo {

	public static void main(String[] args) {
		

		final int NumCalculators = 10;
		final int NumRandomNumbersToAdd = 10000;
		
		Calculator[] calculators = new Calculator[NumCalculators];
		
		for(int i = 0; i < NumCalculators; i++) {
			calculators[i] = new Calculator();
		}
		
		for(Calculator calculator: calculators) {
			addRandomNumbers(calculator, NumRandomNumbersToAdd);
		}
	}
	
	private static void addRandomNumbers(Calculator calculator, int numRandomNumbersToAdd) {
		for(int i = 0; i < numRandomNumbersToAdd; i++) {
			calculator.add(randomInteger(100));
			System.out.println(calculator.getValue());
		}
	
	}

	private static int randomInteger(int n) {
		return (int)(Math.random() * n);
	}

}
