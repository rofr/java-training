package se.informator.t2732.futuretask.xercise;

import java.util.List;
import java.util.TreeMap;
import java.util.concurrent.FutureTask;

public class DiceStatExecutor {

	private List<Integer> diceSums;
	private TreeMap<Integer, FutureTask<Integer>> diceStatsMap;
	private int noOfDice;
	
	public DiceStatExecutor(int noOfDice) {
		// store all possible sums for noOfDice in a List

		// create Map holding target sums and FutureTask
		
	}

	/**
	 * This method creates Callables of type DiceStatTask
	 * Each Callable should define a FutureTask that should be mapped to a target dice sum
	 * All FutureTasks should be submitted using a suitable Executor 
	 */
	public void collectStatistics() {
		// add code here
	}

	/**
	 * This method presents statistics found in Map diceStatsMap
	 */
	public void report() {
		// add code here

	}

}
