package se.informator.t2732.futuretask.dicestats;

import java.util.concurrent.Callable;

public class DiceStatTask implements Callable<Integer>{
	
	private Die[] diceArray;
	private int target;
	private int repeats;
	
	public DiceStatTask(int noOfDice, int value, int r){
		diceArray = new Die[noOfDice];
		for(int i=0; i<diceArray.length; i++){
			diceArray[i] = new Die();
		}
		target = value;
		repeats = r;
	}
	
	public Integer call(){		
		
		int diceSum;
		int totalCount = 0;
		int count;
		
		for(int n=0; n<repeats; n++){
			count = 0;
			do{
				diceSum = 0;
				for(int i=0; i<diceArray.length; i++){
					diceArray[i].roll();
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
		
		System.out.println("Debug: DiceStatTask using target "+target+" done");
		
		return Math.round(10*totalCount/repeats)/10;
	}

}
