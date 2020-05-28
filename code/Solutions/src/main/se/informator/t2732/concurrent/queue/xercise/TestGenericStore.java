package se.informator.t2732.concurrent.queue.xercise;

public class TestGenericStore {

  public static void main(String[] args) throws Exception {
	  
    ConcurrentGenericStore<Property> store = new ConcurrentPropertyStore(5);
    String filename = "properties.txt";
    
    PropertyProducer producer = new PropertyProducer(filename, store);
    PropertyConsumer consumer1 = new PropertyConsumer(store);
    PropertyConsumer consumer2 = new PropertyConsumer(store);
    
    producer.start();
    consumer1.start();
    consumer2.start();
    
  }
}