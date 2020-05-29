package functional;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;

import calculator.Calculator;

public class Lambdas {

	public static void main(String[] args) {

		BiFunction<Integer,Integer, Integer> addition
		   = (a, b) -> a + b;


	   int result = addition.apply(100, 200);
	   System.out.println("100 + 200 = " + result);
		   
	   Function<Double,Double> sqrt = Math::sqrt;
	   double root = sqrt.apply(81.0);
	   System.out.println("Square root of 81 is " + root);
	   
	   BiFunction<Integer,Integer,Integer> sub = Lambdas::subtract;
	   int diff = sub.apply(100, 40);
	   System.out.println("100 - 40 = " + diff);
	   
	   Calculator calculator = new Calculator();
		calculator.add(500);
	   
	   Consumer<Integer> consumer = calculator::add;
	   consumer.accept(200);
	   System.out.println("500 + 200 = " + calculator.getValue());
	   
	   BiConsumer<Calculator, Integer> bc = Calculator::add;
	   bc.accept(calculator, 100);
	   System.out.println("700 + 100 = " + calculator.getValue());

	}

	public static int subtract(int a, int b) {
		return a - b;
	}
}
