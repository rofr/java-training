package se.informator.t2732.concurrent;

import java.util.concurrent.*;

public class ConcurrentNumbers {

	private ExecutorService executor;
	private static int POOL_SIZE = 5;
	private int tasks;
	
	/**
	 * Constructor
	 * @param type holding preferred Executor of tasks
	 * @param noOfTasks the number of tasks to be handled
	 */
	public ConcurrentNumbers(String type, int noOfTasks){
		tasks = noOfTasks;
		if(type.equals("FixedPoolExecutor")){
			executor = Executors.newFixedThreadPool(POOL_SIZE);
		}
		else{
			executor = Executors.newCachedThreadPool();			
		}
	}
	
	/**
	 * This is where the tasks are created and submitted to the chosen Executor 
	 * for execution. The result of a task is held in a Future instance that will
	 * be available when the task is done.
	 * 
	 * @return float holding the average of the results from all tasks
	 */
	@SuppressWarnings("unchecked")
	public float runTasks(){
		
		float sum = 0;	
		Future<Integer>[] result=new Future[tasks];
		
		// submit tasks
		for(int i=0; i<tasks; i++){					
				Callable<Integer> task = new NumberGenerator();
				result[i] = executor.submit(task);
		}
		
		// close down executor 
		executor.shutdown();	
		
		// collect result of executed tasks
		for(int i=0; i<tasks; i++){
			try {
				System.out.print(result[i].get()+" ");
				sum += result[i].get();				
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			}
		}
		
		return Math.round(10*sum/tasks)/10F;
	}
	
}
