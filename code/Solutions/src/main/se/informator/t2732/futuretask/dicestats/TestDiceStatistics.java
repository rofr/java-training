package se.informator.t2732.futuretask.dicestats;

public class TestDiceStatistics {
	
	public static void main(String[] args){
		
		int noOfDice = 2;
		int noOfRepeats = 100;
		
		DiceStatExecutor ds = new DiceStatExecutor(noOfDice, noOfRepeats);
		ds.collectStatistics();

		//	wait awhile before adding up results
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}				
		ds.report();
		
	}
}
