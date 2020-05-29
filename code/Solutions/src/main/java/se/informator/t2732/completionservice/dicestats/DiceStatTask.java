package se.informator.t2732.completionservice.dicestats;

import java.util.concurrent.Callable;

public class DiceStatTask implements Callable<Result>{
	
	private Die[] diceArray;
	private int target;
	private int repeats;
	
	public DiceStatTask(int noOfDice, int targetSum, int r){
		diceArray = new Die[noOfDice];
		target = targetSum;
		repeats = r;
	}
	
	public Result call(){		
		
		int diceSum;
		int totalCount = 0;
		int count;
		
		for(int n=0; n<repeats; n++){
			count = 0;
			do{
				diceSum = 0;
				for(int i=0; i<diceArray.length; i++){
					diceArray[i] = new Die();
					diceArray[i].roll();
				}

				for(int i=0; i<diceArray.length; i++){
					diceSum += diceArray[i].getValue();
				}
				count++;

				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
			}while(diceSum != target);
			totalCount += count;
		}
		
		Integer value = Math.round(10*totalCount/repeats)/10;
		
		return new Result(target, value);
	}

}
