package se.informator.t2732.concurrent.xercise;

public class TestDiceSimulation {
	
	public static void main(String[] args){

		int noOfThrows = 10;
		int noOfDice = 2;
		
		DiceExecutor de = new DiceExecutor("FixedThreadPool", noOfThrows);
//		DiceExecutor de = new DiceExecutor("Default", noOfThrows);
 
		float avg = de.throwDice(noOfDice);		
		System.out.println("Average sum of "+noOfDice+" dice is: "+avg);
		
	}
}
