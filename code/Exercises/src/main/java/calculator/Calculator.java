package calculator;

public class Calculator {

	private int value;
	
	public void add(int val) {
		value += val;
	}
	
	public int getValue() {
		return value;
	}
	
	public void reset() {
		value = 0;
	}
}
