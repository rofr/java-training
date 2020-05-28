package se.informator.t2732.forkjoin;

public class ShellSort{

	Integer[] numbers;
	
	public ShellSort(Integer[] numbers){
		this.numbers = numbers;
	}

	public void sort(){
		// perform sorting here
		for(int i=0; i<numbers.length-1; i++){
			for(int j=i+1; j<numbers.length; j++){
				if(numbers[i] > numbers[j]){
					int temp = numbers[i];
					numbers[i] = numbers[j];
					numbers[j] = temp;
				}
			}
			
		}
	}
	
	public void printList(){
		for(int temp : numbers){
			System.out.println(temp);
		}
	}
	
	public static void main(String[] args){
		
		final int N = 500;
		Integer[] testNumbers = generateNumbers(N);
		
		long start = System.nanoTime();
		
		ShellSort ss = new ShellSort(testNumbers);
		ss.sort();
			
		long stop = System.nanoTime();		
		float time = (stop-start)/1000000F;
		

		System.out.println("Sorting " + N + " integers");
		System.out.print("First: " + testNumbers[0]);
		System.out.println("\tLast: " + testNumbers[N-1]);
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
