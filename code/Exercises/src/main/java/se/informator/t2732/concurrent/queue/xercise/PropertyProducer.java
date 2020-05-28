package se.informator.t2732.concurrent.queue.xercise;

import java.io.*;

public class PropertyProducer extends Thread {

  /**
   * The file to read.
   */
  private String propertyFile;

  /**
   * The store.
   */
  private ConcurrentGenericStore<Property> theStore;

  /**
   * Constructs a new PropertyProducer reading input from the specified file
   * @param filename the name of the file
   * @param store where to store Property objects
   */
  public PropertyProducer(String filename, ConcurrentGenericStore<Property> store)
  												throws FileNotFoundException{
	  propertyFile = filename;
	  theStore = store;
  }

  /**
   * Defining producer thread 
   */
  public void run() {

	  String line = null;
	  boolean stop = false;
	  // Java7 try with resources used
	  try (BufferedReader reader = new BufferedReader(new FileReader(propertyFile));){
		  do {
			  try{
				  line = reader.readLine();
				  if(line != null){
					  String[] parts = line.split("=");			  
					  Property prop = new Property(parts[0], parts[1]);
					  theStore.store(prop);
				  }
				  int delay = (int)(Math.random()*40);
				  Thread.sleep(delay);
			  }catch (InterruptedException ie) {
				  System.err.println("Error when storing property, interrupted: " + ie.getMessage());
			  }

			  stop = (line == null);
		  } while (!stop);
	  }
	  catch (IOException ioe) {
		  System.err.println("Error when reading file: " + ioe.getMessage());
	  }

	  System.out.println("No more properties available!");  
	  System.out.println("Producer thread "+this.getName()+" ends!");

	  // Inform store - end of properties
	  Property endProp = new Property("EndBag", "EndBag");
	  try {
		  theStore.store(endProp);
	  } catch (InterruptedException e) {
		  e.printStackTrace();
	  }

  }

}