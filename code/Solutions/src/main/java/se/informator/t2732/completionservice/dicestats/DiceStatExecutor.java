package se.informator.t2732.completionservice.dicestats;

import java.util.*;
import java.util.concurrent.*;

public class DiceStatExecutor {

	private List<Integer> diceSums;
	private TreeMap<Integer, Integer> diceStatsMap;	
	private int noOfDice;
	private int repeats;
	
	/**
	 * Populate an ArrayList holding all possible sums of n dice
	 * @param n the number of dice that will be simulated
	 * @param r the number of rounds for collection of statistics 
	 */
	public DiceStatExecutor(int n, int r){
		
		diceSums = new ArrayList<Integer>(n*6);
		diceStatsMap = new TreeMap<Integer, Integer>();
		
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
		
		// create and temporary store tasks in a collection		
		List<Callable<Result>> diceTaskList = new ArrayList<Callable<Result>>();
		
		for(Integer value: diceSums){
			DiceStatTask dt = new DiceStatTask(noOfDice, value, repeats);
			diceTaskList.add(dt);
		}
		
		// Set up a completion service and submit tasks to it
		CompletionService<Result> service = new ExecutorCompletionService<Result>(executor);
		// submit tasks
		for(Callable<Result> task : diceTaskList){
			service.submit(task);
		}
		
		System.out.println("All tasks submitted, waiting for results...");
			
		// close down executor
		executor.shutdown();
		
		// wait for tasks to finish, handle result in separate method
		int n = diceTaskList.size();
		for (int i = 0; i<n; ++i) {
			// handle Result objects as they become available 
			try {
				Result r = service.take().get();
				diceStatsMap.put(r.getTargetSum(), r.getAttempts());
				System.out.println("Task completed: " + r);
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			} 

		}
		System.out.println("==================== Done =======================");
	}
	
	/**
	 * This method will present a full report on the outcome of the dice simulation.
	 */
	public void report(){

		System.out.println("=====================================");
		for(Integer key: diceStatsMap.keySet()){

			int value = diceStatsMap.get(key);

			System.out.print("Dicesum "+key+" occurs after "+value+" throw(s)\t");
			for(int i=0; i<value; i++){
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println("=====================================");
	}	
}
