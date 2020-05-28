package se.informator.t2732.threads;


public class TestGenericStore {

  public static void main(String[] args) throws Exception {
	  
    GenericStore<Property> store = new PropertyStore(5);
    String filename = "properties.txt";
    
    PropertyProducer producer = new PropertyProducer(filename, store);
    PropertyConsumer consumer1 = new PropertyConsumer(store);
//    PropertyConsumer consumer2 = new PropertyConsumer(store);
    
    producer.start();
    consumer1.start();
//    consumer2.start();
    
  }
}