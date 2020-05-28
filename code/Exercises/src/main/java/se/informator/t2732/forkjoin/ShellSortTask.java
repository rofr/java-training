package se.informator.t2732.forkjoin;

import java.util.concurrent.RecursiveTask;
import static se.informator.t2732.forkjoin.ForkJoinSorterApp.*;

public class ShellSortTask extends RecursiveTask<Integer[]>{
	
	private boolean DEEP_DEBUG = false;
	
	private static final long serialVersionUID = 1L;
	private static final int THRESHOLD = 50;
	private static int forkedThreads = 0;
	private static int joinedThreads = 0;
	
	private Integer[] taskNumbers;
	
	public ShellSortTask(Integer[] numbers){
		this.taskNumbers = numbers;
	}
	
	@Override
	protected Integer[] compute() {
		// easy problem, don't bother with parallelism
		if (taskNumbers.length < THRESHOLD) { 
			ShellSort ss = new ShellSort(taskNumbers);
			ss.sort();
			return ss.numbers;
		}
		else {
			// System.out.println("Divide and conquer!");
			int pos = taskNumbers.length/2;
			Integer[] firstNumbers = new Integer[pos]; 
			System.arraycopy(taskNumbers, 0, firstNumbers, 0, pos);

			Integer[] lastNumbers = new Integer[taskNumbers.length - pos]; 
			System.arraycopy(taskNumbers, pos, lastNumbers, 0, taskNumbers.length-pos);
				
				
				ShellSortTask worker1 = new ShellSortTask(firstNumbers);
				ShellSortTask worker2 = new ShellSortTask(lastNumbers);

				worker1.fork();
				worker2.fork();
				forkedThreads += 2;
				if(DEBUG) System.out.println("Waiting for forked tasks to finish. forkedThreads = " + forkedThreads);
				Integer[] firstSorted = worker1.join();				
				Integer[] secondSorted = worker2.join();			
				joinedThreads += 2;
				if(DEBUG) System.out.println("Forked tasks are now joined! joinedThreads = " + joinedThreads);
				taskNumbers = mergeResults(firstSorted, secondSorted);
				return taskNumbers;
		}

	}
	
	private Integer[] mergeResults(Integer[] firstSorted, Integer[] secondSorted ){
		
		if(DEEP_DEBUG){ 
			System.out.println("Merging arrays");
			for(Integer temp : firstSorted){
				System.out.print(temp + " ");
			}
			System.out.println();
			for(Integer temp : secondSorted){
				System.out.print(temp + " ");
			}
			System.out.println();
		}
		
		Integer[] mergedArray = new Integer[firstSorted.length + secondSorted.length];
		int m = 0;
		int s = 0;
		int i = 0;
		
		while(i<firstSorted.length){
			// check if we have completed merge of second array
			if(s >= secondSorted.length){
				mergedArray[m++] = firstSorted[i++];
				continue;
			}
			else{
				if(firstSorted[i] < secondSorted[s]){
					mergedArray[m++] = firstSorted[i++];
				}
				else{
					mergedArray[m++] = secondSorted[s++];
				}
			}

		}
		// check if there are more elements from second array to merge
		while(s < secondSorted.length){
			mergedArray[m++] = secondSorted[s++];
		}
		
		if(DEEP_DEBUG){ 
			for(Integer temp : mergedArray){
				System.out.print(temp + " ");
			}
			System.out.println();
		}
		
		return mergedArray;
	}

}
