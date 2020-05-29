package se.informator.t2732.threads.xercise;

import java.io.*;

public class PropertyProducer extends Thread {

	/**
	 * The producer.
	 */
	private BufferedReader producer = null;

	/**
	 * The store.
	 */
	private GenericStore<Property> theStore = null;

	/**
	 * Constructs a new PropertyProducer reading input from the specified file.
	 * @param filename the name of the file.
	 * @param store the store.
	 */
	public PropertyProducer(String filename, GenericStore<Property> store)
			throws FileNotFoundException{
		theStore = store;
		producer = new BufferedReader(new FileReader(filename));
	}

	/**
	 * Overriding the dummy implementation of interface Runnable 
	 */
	public void run() {

		try {
			String line = null;
			boolean stop = false;
			do {
				line = producer.readLine();
				if(line != null){
					String[] parts = line.split("=");
					Property prop = new Property(parts[0], parts[1]);
					theStore.store(prop);
				}
				int delay = (int)(Math.random()*100);
				Thread.sleep(delay);		
				stop = (line == null);
			} while (!stop);
		}
		catch (IOException ioe) {
			System.err.println("Error when reading file: " + ioe.getMessage());
		}
		catch (InterruptedException ie) {
			System.err.println("Error when storing property, interrupted: " + ie.getMessage());
		}
		finally{
			// close down file connection
			try {
				producer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		System.out.println("No more properties available!");  
		System.out.println("Producer thread "+this.getName()+" ends!");
		// Inform store - end of properties
		theStore.setEndBag(true);
	}

}