package se.informator.t2732.concurrent.queue.xercise;

import java.util.concurrent.*;

public class ConcurrentPropertyStore implements ConcurrentGenericStore<Property> {

	/**
	 * The maximum size of the store
	 */
	private final int MAX_SIZE;

	/**
	 * An array that holds the objects.
	 */
	private BlockingQueue<Property> storage;

	/**
	 * Constructor defining a blocking queue with a fixed size
	 */
	public ConcurrentPropertyStore(int max){
		MAX_SIZE = max;
		storage= new ArrayBlockingQueue<Property>(MAX_SIZE);
	}
	
	// See interface for documentation
	public Property get() throws InterruptedException {
		System.out.println("-- Store holds "+storage.size()+" items");
		if(storage.size() == 0){
			System.out.println("      Waiting");
		}
		Property prop = storage.take();	
		return prop;
	}

	// See interface for documentation
	public void store(Property prop) throws InterruptedException{
		System.out.println("++ Store holds "+storage.size()+" items");	
		if(storage.size() == MAX_SIZE){
			System.out.println(" ***** Waiting");
		}
		storage.put(prop);
	}

}
