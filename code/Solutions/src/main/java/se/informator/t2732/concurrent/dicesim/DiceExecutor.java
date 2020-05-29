package se.informator.t2732.concurrent.dicesim;

import java.util.concurrent.*;

public class DiceExecutor {

	private ExecutorService executor;
	private static int POOL_SIZE = 3;
	private int tasks;
	
	public DiceExecutor(String type, int noOfThrows){
		tasks = noOfThrows;
		if(type.equals("FixedThreadPool")){
			executor = Executors.newFixedThreadPool(POOL_SIZE);
		}
		else{
			executor = Executors.newCachedThreadPool();			
		}
	}
	
	@SuppressWarnings("unchecked")
	public float throwDice(int noOfDice){
		
		int sum = 0;
		Future<Integer>[] diceSums = new Future[tasks]; 
		// create and execute tasks
		for(int i=0; i<tasks; i++){
			Callable<Integer> diceThrow = new DiceTask(noOfDice);
			diceSums[i] = executor.submit(diceThrow);	
		}	
		
		// sum up task results in order of execution
		for(int i=0; i<tasks; i++){
			try {
				sum += (Integer)diceSums[i].get();
				System.out.println("Dicesum: "+diceSums[i].get());
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			}
		}

		// close down the executor
		executor.shutdown();
		
		// present result of simulation
		float average = Math.round(10*sum/tasks)/10F;  

		return average;
	}		
	
}
