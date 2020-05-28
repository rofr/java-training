# Exercises M5 Concurrency

## 1. Property Handler
Project PropertyHandler holds classes that implement the design pattern producer-consumer. PropertyProducer is a class derived from Thread that reads data from a text file and creates Property objects based on read data and stores them in a common storage PropertyStore. Another threaded class PropertyConsumer should fetch objects from the storage and print out info to console.  

When all key/value pairs are read from the text file, PropertyProducer will signal to the PropertyStore by calling setEndBag(true). PropertyConsumer will go on reading objects from the storage until it is empty and the flag endBag is set.

PropertyStore implements the generic interface GenericStore<T> 

[Class Diagram](classdiagram.jpg)

Test run the application using TestGenericStore where one producer and one consumer are running simultaneously. 

Run the test program TestGenericStore using multiple consumer threads that run in parallel. Detect and correct any problems occurring.