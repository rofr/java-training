package se.informator.t2732.threads.xercise;


public class PropertyConsumer extends Thread{

	/**
	 * The store.
	 */
	private GenericStore<Property> theStore = null;

	/**
	 * Constructs a new PropertyConsumer using the specified store.
	 * @param store the store.
	 */
	public PropertyConsumer(GenericStore<Property> store) {
		theStore = store;
	}

   /**
	* Overriding the dummy implementation of interface Runnable 
	*/
	public void run() {
		Property property = null;
		boolean stop = false;
		do {
			stop = (theStore.isStoreEmpty() && theStore.isEndBag());
			try {
				property = theStore.get();
				// Do something with the property...
				if(property != null){
					System.out.println(property);
					int delay = (int)(Math.random()*100);
					Thread.sleep(delay);
				}
			}
			catch (InterruptedException ie) {
				System.err.println("Error when getting property, interrupted: " +
						ie.getMessage());
			}

		} while (!stop);
		System.out.println("Consumer thread "+this.getName()+" ends!");
	}
}