package xunit;

public class Assert {
	
	static boolean ok; 
	static String message;
	
	static void reset() {
		ok = false;
		message = "Inconclusive, no assertion called";
	}
	
	public static void assertEquals(int expected, int actual) {
		if (expected == actual) {
			ok = true;
			message = "";
		} else {
			ok = false;
			message = "Expected <" + expected + ">, got <" + actual + ">";  
		}			
	}
}
