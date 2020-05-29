package se.informator.t2732.futuretask.dicestats;

import java.util.*;
import java.util.concurrent.*;

public class DiceStatExecutor {

	private List<Integer> diceSums;
	private TreeMap<Integer, FutureTask<Integer>> diceStatsMap;
	private int noOfDice;
	private int repeats;
	
	/**
	 * Populate an ArrayList holding all possible sums of n dice
	 * @param n the number of dice that will be simulated
	 * @param r the number of rounds for collection of statistics 
	 */
	public DiceStatExecutor(int n, int r){
		
		diceSums = new ArrayList<Integer>(n*6);
		diceStatsMap = new TreeMap<Integer, FutureTask<Integer>>();
		
		int low=n;
		int high=n*6;
		for(int i=low; i<=high; i++){
			diceSums.add(i);
		}
		noOfDice = n;
		repeats = r;
	}
	
	/**
	 * This method runs a number of tasks each waiting for a specific dice sum to happen
	 * All possible combinations will be tested and the number of tries for each sum
	 * will be stored in a map that has the sum as its key
	 */
	public void collectStatistics(){
		
		// choose executor
		ExecutorService executor = Executors.newCachedThreadPool();
		
		// create and map tasks to TreeMap
		for(Integer value: diceSums){
			DiceStatTask dt = new DiceStatTask(noOfDice, value, repeats);
			FutureTask<Integer> task = new FutureTask<Integer>(dt);
			diceStatsMap.put(value, task);		
		}
		
		// submit tasks
		for(Integer value: diceSums){
			System.out.println("Debug: DiceStatTask for target "+value+ " submitted");
			executor.submit(diceStatsMap.get(value));
		}
		
		// close down executor
		executor.shutdown();
	}
	
	/**
	 * This method will present a full report on the outcome of the dice simulation.
	 * It waits for tasks to complete, calling blocking get()
	 */
	public void report(){

		for(Integer key: diceStatsMap.keySet()){
			try	{
				// get hold of the task that belongs to current key
				FutureTask<Integer> task = diceStatsMap.get(key);
				// if available, get the result of the task
				int value = task.get();
				System.out.print("Dicesum "+key+" occurs after "+value+" throw(s)\t");
				for(int i=0; i<value; i++){
					System.out.print("*");
				}
				System.out.println();
			}
			// Java7 multi-catch
			catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}
		}

	}
		
}
