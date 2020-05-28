package se.informator.t2732.thread.latches;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class StopLatch extends Thread {
	
	private final CountDownLatch stopLatch;

	public StopLatch(CountDownLatch stopLatch, String id) {
		this.stopLatch = stopLatch;
		this.setName(id);
	}
	
	public void run() {
		try {
			// perform interesting task
			int sum = 0;
			int target = 20;
			do{
				Thread.sleep(1000);
				sum += (int)(Math.random() * 10);
				System.out.println("Thread " + Thread.currentThread().getName() + "  " + sum);
			}while(sum < target);
			
			System.out.println("***** Thread " + Thread.currentThread().getName() +  " done");
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
			System.out.println("### " + Thread.currentThread().getName() + " Interrupted ###");
		} finally {
			// the application specific Latch will count down for every thread that is done here
			stopLatch.countDown();
			System.out.println("--- count:" + stopLatch.getCount());
		}
	}


	public static void performParallelTask(int n) throws InterruptedException {
		
		CountDownLatch latch = new CountDownLatch(n);
		
		Thread[] threads = new Thread [n];
		for (int i = 0; i < n; i++) {
			String tempId = String.valueOf("T"+(i+1));
			threads[i] = new StopLatch(latch, tempId);
			threads[i].start();
		}
		
		System.out.println("CountDownLatch waiting for all threads to complete");
		if(latch.await(5, TimeUnit.SECONDS)){
			System.out.println("All threads are now done");
		}
		else{
			System.out.println("### Operation not completed! ###");
			for(int i=0; i<n; i++){
				threads[i].interrupt();
			}
			throw new InterruptedException();
		}
	}
	

	public static void main(String[] args){
		
		try {
			performParallelTask(5);
			System.out.println("Application finished normally");
		} catch (InterruptedException e) {
			System.out.println("Exception occurred: ");
			e.printStackTrace();
		}
	}
}