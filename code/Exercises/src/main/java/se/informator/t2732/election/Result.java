package se.informator.t2732.election;

import java.util.concurrent.atomic.AtomicIntegerArray;

/**
 * This class is used to atomically handle a number of int values stored
 * in a thread safe array of length n.
 * Updating and retrieving current values for any element in the array is
 * done in using the atomic package facilities guaranteeing thread safety.
 */
public class Result {

	private AtomicIntegerArray values;
	private int n;
	
	public Result(int n){
		this.n = n;
		values = new AtomicIntegerArray(n);
	}
	
	public int getN(){
		return n;
	}
	
	public void addValue(Integer delta, int index) {
		values.addAndGet(index, delta);
	}
	public Integer getValue(int index){
		return values.get(index);
	}
	
	public String toString(){
		return values.toString();
	}
}
