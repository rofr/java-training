package se.informator.t2732.concurrent.queue.xercise;


public class PropertyConsumer extends Thread{

	/**
	 * The store.
	 */
	private ConcurrentGenericStore<Property> theStore = null;

	/**
	 * Constructs a new PropertyConsumer using the specified store.
	 * @param store the store.
	 */
	public PropertyConsumer(ConcurrentGenericStore<Property> store) {
		theStore = store;
	}

   /**
	* Defining consumer thread 
	*/
	public void run() {
		boolean stop = false;
		Property property = null;
		do {
			try {
				property =  theStore.get();
				// Do something with the property...
				System.out.println("Property: "+property);
				if(property.getName().equals("EndBag")){
					stop = true;
					System.out.println("Returning EndBag to Store");
					theStore.store(property);
				}
				int delay = (int)(Math.random()*100);
				Thread.sleep(delay);
			}
			catch (InterruptedException ie) {
				System.err.println("Error when getting property, interrupted: " + ie.getMessage());
			}

		} while (!stop);
		System.out.println("Consumer thread "+this.getName()+" ends!");
	}
}