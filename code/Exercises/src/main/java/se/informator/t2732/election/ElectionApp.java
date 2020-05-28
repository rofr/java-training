package se.informator.t2732.election;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;

/**
 * This application will simulate the outcome from an election by using
 * the Executor Framework in combination with the atomic package.
 * The example will show how to set up efficient concurrency for a number
 * of asynchronous tasks that will be working in parallel.
 */
public class ElectionApp {

	public static void main(String[] args) {

		final int parties = 5;
		
		TaskExecutor te = new TaskExecutor(parties);
		Collection<Callable<Result>> counters = new ArrayList<Callable<Result>>(); 
		
		// create a number of tasks, add to Collection
		for(int i=1; i<=10; i++){
			Callable<Result> task = new VotesCountTask("Counter "+i, parties);
			counters.add(task);
		}
		
		System.out.println("ElectionApp started... ");
		
		// start task executor, passing Collection of defined tasks
		try {
			te.count(counters);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
	}

}
