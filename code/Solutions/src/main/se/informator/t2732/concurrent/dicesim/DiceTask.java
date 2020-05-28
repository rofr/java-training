package se.informator.t2732.concurrent.dicesim;

import java.util.concurrent.*;

public class DiceTask implements Callable<Integer>{

	private Die[] diceArray;
	
	public DiceTask(int n){
		diceArray = new Die[n];
		for(int i=0; i<n; i++){
			diceArray[i] = new Die();
		}
	}
	
	public Integer call(){
		int diceSum=0;
		
		for(int i=0; i<diceArray.length; i++){
			diceArray[i].roll();
		}
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		for(int i=0; i<diceArray.length; i++){
			diceSum += diceArray[i].getValue();
		}
				
		return diceSum;
	}
	
}
