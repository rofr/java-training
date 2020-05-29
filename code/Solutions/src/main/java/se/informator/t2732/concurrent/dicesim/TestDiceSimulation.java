package se.informator.t2732.concurrent.dicesim;

public class TestDiceSimulation {
	
	public static void main(String[] args){
		
		int noOfDice = 2;
		int noOfThrows = 10;
		
		DiceExecutor de = new DiceExecutor("FixedThreadPool", noOfThrows);
//		DiceExecutor de = new DiceExecutor("Default", noOfThrows);
		
		float avg = de.throwDice(noOfDice);	
		System.out.println("Average sum of "+noOfDice+" dice is: "+avg);
	}
}
