package se.informator.t2732.completionservice.dicestats;

public class Result {

	private int targetSum;
	private int attempts;
	
	public Result(int sum, int value){
		targetSum = sum;
		attempts = value;
	}
	
	public Integer getTargetSum(){
		return targetSum;
	}
	
	public Integer getAttempts(){
		return attempts;
	}
	
	public String toString(){
		return "Target sum "+ targetSum + " reached after " + getAttempts() + " attempts";
	}
	
}
