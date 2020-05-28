package se.informator.t2732.forkjoin;

import java.util.concurrent.ForkJoinPool;

/**
 * This class runs a recursive algorithm using a fork/join concurrency framework
 * For low values of configuring parameter the overhead will be significant
 * but, for large values you will get a performance benefit of this computation intensive algorithm
 */
public class ForkJoinSorterApp {
		
	static boolean DEBUG = true;
	
	public static void main(String[] args) {
		
		// Check the number of available processors
		int processors = Runtime.getRuntime().availableProcessors();
		System.out.println("No of processors: " + processors);
		
		final int N = 500;	
		Integer[] testNumbers = generateNumbers(N);
		
		long start = System.nanoTime();
		
		ShellSortTask mainTask = new ShellSortTask(testNumbers);
		
		ForkJoinPool pool = new ForkJoinPool(processors);
		Integer[] sortedNumbers = pool.invoke(mainTask);
		
		long stop = System.nanoTime();
		
		float time = (stop-start)/1000000F;
		System.out.println("Sorting " + N + " integers");
		System.out.print("First: " + sortedNumbers[0]);
		System.out.println("\tLast: " + sortedNumbers[N-1]);		
		System.out.println("Elapsed Time: " + time + " ms");
		
	}
	
	
	private static Integer[] generateNumbers(final int N) {
		Integer[] testNumbers = new Integer[N];
		java.util.Random generator = new java.util.Random();
		
		for(int i=0; i<N; i++){
			testNumbers[i] = generator.nextInt(N*10);
		}
		return testNumbers;
	}
}

