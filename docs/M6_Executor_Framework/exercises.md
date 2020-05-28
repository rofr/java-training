# Exercises M6 Executor Framework

## 1. ExecutorService Dice Simulation
Write a program that simulates throwing of N dice, adding up die values to a dice sum. The simulation should prove that the various sums are distributed according to the normal distribution with a peek at median value. The application should be divided into two parts, DiceTask that implements Callable and defines a task representing one throw of N dice. DiceExecutor should be the supervisor that creates and submits thread tasks and takes care of the return values when the tasks are done.

Class DiceTask should have a structure as presented below:

```java
  private Die[] diceArray;

  public DiceTask(int n)
  public Integer call()
```
Die is a predefined class that you should use as is.


Class DiceExecutor has the following contents:

```java
	private ExecutorService executor;
	private static int POOL_SIZE = 3;
	private int tasks;
	
	public DiceExecutor(String type, int noOfThrows)
	public float throwDice(int noOfDice)
```

The tasks are submitted from method throwDice, which also will take care of return values from executed tasks. The return values should be added up to a total sum, which is used for final calculation of average value of the complete test.


Run the test program TestDiceSimulation testing different choices of ExecutorService. Change number of Dice and number of test runs in order to check that the simulation scales correctly. 


## 2. FutureTask<> Dice Statistics
Write a program handling dice statistics. The program should check the average number of attempts you need to get a specific target dice sum. A complete run through of all possible dice sums, depending on configured number of dice, should end up in an inversed normal distribution of results.

The application should use class DiceStatTask for specifying the job; 
```java
  private Die[] diceArray;
  private int target;
	
  public DiceStatTask(int noOfDice, int targetSum)
     public Integer call()
```

Constructor arguments will configure the array of Die objects and the target dice sum. 

DiceStatExecutor is designed as follows:

```java
 private List<Integer> diceSums
 private TreeMap<Integer, FutureTask<Integer>> diceStatsMap
 private int noOfDice;
  
 public DiceStatistics(int noOfDice)
 public void collectStatistics()
 public void report()
```
	
Constructor arguments will configure attribute noOfDice. List diceSums is holding all possible sums using the current value of noOfDice. This List should be prepared by the constructor and later values should be used as keys when populating diceStatsMap holding all tasks to be submitted to an Executor.

Method collectStatistics() is responsible for setting up an Executor that will run all jobs submitted to it. The jobs are taken from the value part of the diceStatMap, holding a number of FutureTasks. The results of each job will eventually end up in this Map for presentation in key order.

Run the test program TestDiceStatistics and study output. 

Xtra: Add a parameter repeats configuring the number of times you would like each task to be repeated, ensuring a statistical stable value, avoiding random results.
Rerun the test program and study output, change configuration parameters and see if the application scales well.

## 3. Blocking Queue (extra exercise if time permits)
Rewrite exercise PropertyHandler in order to use a storage class that implements the BlockingQueue<E> interface, replacing previous solution.

BlockingQueue can be used in several different ways. Study the documentation before you decide which implementation to use.

[Blocking Queue docs screenshot](blockingqueue.jpg)
 


Run the adjusted application using TestGenericStore. Test one or several threads that run in parallel in order to verify that the application is running correctly.

## 4. CompletionService
Rewrite exercise DiceStatistics in order to handle completed tasks when result becomes available. You should use an implementation of CompletionService, polling tasks when they report state done. Wait for all results to be available before you present the final statistics.

Tip: Add a class Result that holds target sum to be tested for current task and the outcome of task execution, i.e. the return value from DiceStatTask.

