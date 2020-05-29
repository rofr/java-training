package se.informator.t2732.futuretask.dicestats;

public class Die {
	private int value;
	
	public Die(){
		value = 6;
	}
	
	public void roll(){
		value = (int)(Math.random()*6)+1;
	}
	
	public int getValue(){
		return value;
	}
	
}
