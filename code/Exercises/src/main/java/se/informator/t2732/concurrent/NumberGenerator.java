package se.informator.t2732.concurrent;

import java.util.concurrent.Callable;

public class NumberGenerator implements Callable<Integer>{
	
	/**
	 * Define the task to be run
	 * @return Integer holding a randomly created value in the range 0 - 99
	 */
	public Integer call(){
		try{
			Thread.sleep((int)(Math.random()*100)+1000);
		}
		catch(InterruptedException e){ e.printStackTrace();}
		int value = (int)(Math.random()*100);
		return value;
	}
}