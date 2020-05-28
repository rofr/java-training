package se.informator.t2732.threads;

import java.util.*;


public class PropertyStore implements GenericStore<Property> {

	/**
	 * Notification of last item in store
	 */
	private boolean endBag=false;

	/**
	 * The maximum size of the store
	 */
	private final int MAX_SIZE;

	/**
	 * An array that holds the objects.
	 */
	private Deque<Property> values;

	/**
	 * Constructor
	 */
	public PropertyStore(int max){
		MAX_SIZE = max;
		values= new ArrayDeque<Property>(MAX_SIZE);
	}

	// See interface for documentation
	public synchronized void store(Property value) throws InterruptedException{

		while (isStoreFull()) {
			System.out.println("Store full - waiting");    	
			wait();
		}

		values.addLast(value);
		System.out.println(" + Storing, size: " + values.size());

		notifyAll();
	}

	// See interface for documentation
	public synchronized Property get() throws InterruptedException {

		while (isStoreEmpty() && !endBag) {
			System.out.println("Store empty - waiting");
			wait();
		}

		Property obj = values.pollFirst();
		System.out.println(" - Getting, size: " + values.size());
		notifyAll();

		return obj;
	}
	
	// See interface for documentation
	public boolean isStoreEmpty() {
		return values.isEmpty();
	}

	// See interface for documentation
	public boolean isStoreFull() {
		return (values.size() == MAX_SIZE);
	}

	// See interface for documentation
	public boolean isEndBag() {
		return endBag;
	}

	// See interface for documentation
	public void setEndBag(boolean endBag) {
		this.endBag = endBag;
	}

}
