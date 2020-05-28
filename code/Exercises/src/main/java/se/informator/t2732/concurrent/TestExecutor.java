package se.informator.t2732.concurrent;


public class TestExecutor {

	public static void main(String[] args){
		
		int noOfTasks = 10;
		ConcurrentNumbers cn;
		cn = new ConcurrentNumbers("FixedPoolExecutor", noOfTasks);
//		cn = new ConcurrentNumbers("CachedPoolExecutor", noOfTasks);
		float average = cn.runTasks();		
		
		System.out.println();
		System.out.println("Tasks executed: "+noOfTasks);
		System.out.println("Average value: "+average);
	}
}
