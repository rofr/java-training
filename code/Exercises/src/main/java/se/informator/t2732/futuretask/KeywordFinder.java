package se.informator.t2732.futuretask;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class KeywordFinder {
	private List<String> keywords = new ArrayList<String>();
	private Map<String, FutureTask<Integer>> taskMap;
	
	/**
	 * Constructor
	 * @param words holding a set of Strings to search for
	 */
	public KeywordFinder(String[] words){
		keywords.addAll(Arrays.asList(words));
		taskMap = new TreeMap<String, FutureTask<Integer>>();		
	}
	
	/**
	 * This method sets up the application machinery using the Executor Framework	 
	 * Callable tasks are created for sequential execution and mapped to specific keywords 
	 * @param file holding the File to go looking for specific words in
	 */
	public void startSearchThreads(File file){
		
		// choose implementation for execution of tasks
		ExecutorService executor= Executors.newSingleThreadExecutor();
		
		// create tasks (Callables) and map to keywords in a HashMap 
		for(String s: keywords){
			KeywordTask theTask = new KeywordTask(s, file);
			FutureTask<Integer> task = new FutureTask<Integer>(theTask);
			taskMap.put(s, task);						
		}
		
		// submit tasks for execution
		// NB! the result of every executed task will be retrievable via the 
		// get-method belonging to the mapped FutureTask<Integer> instance
		for(FutureTask<Integer> task: taskMap.values()){
			executor.submit(task);				
		}
		
		// close down the executor
		executor.shutdown();		
	}
	
	/**
	 * This method will present a full report on the outcome of the complete search.
	 * It waits for tasks to complete, calling blocking get()
	 */
	public void report(){
	
		System.out.println("================= Report =====================");
		
		for(String key: taskMap.keySet()){
			try	{
				// get hold of the task that belongs to current key
				FutureTask<Integer> task = taskMap.get(key);
				// if available, get the result of the task
				int value = task.get();
				if(value != 0){
					System.out.println("Keyword "+key+" occurs "+value+" time(s)");
				}
			}
			catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}
		}
	}
	
}
