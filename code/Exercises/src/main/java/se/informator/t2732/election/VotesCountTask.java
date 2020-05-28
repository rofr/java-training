package se.informator.t2732.election;

import java.util.concurrent.Callable;

/**
 * This class is defining a Callable task that will produce an array of integer values
 * packaged in an object of type Result, which is defined elsewhere.
 */
public class VotesCountTask implements Callable<Result>{

	private String threadId;
	private int n;
	
	public VotesCountTask(String id, int noOfElements){
		threadId = id;
		n = noOfElements;
	}
	
	public Result call() throws Exception {
			
		try {
			Thread.sleep( (int)(Math.random()*30000)+1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Integer[] votes = new Integer[n];
		for(int i=0; i<n; i++){
			votes[i] = (int)(Math.random()*1000);
		}
		Result resultObject = new Result(n);
		for(int i=0; i<n; i++){
			resultObject.addValue(votes[i], i);
		}
		System.out.println("Local thread "+threadId+" reports");

		return resultObject;
	}

}
