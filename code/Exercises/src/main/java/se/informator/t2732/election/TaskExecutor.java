package se.informator.t2732.election;

import java.util.Collection;
import java.util.concurrent.*;
import java.util.concurrent.atomic.*;

/**
 * This class is the center of the application submitting Callable tasks, updating results
 * in an asynchronous way and finally presents the outcome of a full application run 
 */
public class TaskExecutor {
	
	private ExecutorService executor;
	private Result totalVotes;
	private static AtomicInteger reports = new AtomicInteger();
	
	public TaskExecutor(int noOfChoice){
		executor = Executors.newCachedThreadPool();
		totalVotes = new Result(noOfChoice);
	}
	
	/**
	 * This method submits all counting tasks and waits for response using
	 * ExecutorCompletionService which works in an asynchronous way 
	 * @param counters holding all created count tasks to submit
	 * @throws InterruptedException
	 * @throws ExecutionException
	 */
	public void count(Collection<Callable<Result>> counters)throws InterruptedException, ExecutionException {
		
		// CompletionService holding future Result objects
		CompletionService<Result> service = new ExecutorCompletionService<Result>(executor);
      
		// submit all tasks 
		for (Callable<Result> count : counters){
    	  service.submit(count);
		}
		
		System.out.println("All tasks submitted, waiting for results...");
		
		// no more tasks to submit, close down service
		executor.shutdown();
		
		// wait for tasks to finish, handle result in separate method
		int n = counters.size();
		for (int i = 0; i < n; ++i) {
			// handle Result objects as they become available 
			Result countResult = service.take().get();
			accumulateVotes(countResult);
		}
		System.out.println("==================== Done =======================");
		

	}
	
	/**
	 * This method should accumulate current Result to previous Result value
	 * @param countResult holding updates
	 */
	private void accumulateVotes(Result countResult){

		reports.incrementAndGet();
		System.out.println("Result "+countResult);
		
		// add countResult to overall votes count
		for(int i=0; i<countResult.getN(); i++){
			int value = countResult.getValue(i);			
			totalVotes.addValue(value, i);
		}
		
		System.out.println("Current standings after "+reports.get()+" reports");
		System.out.println(totalVotes);
		System.out.println("-------------------------------------------------");
		
	}
}
