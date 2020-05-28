package se.informator.t2732.thread.latches;

import java.util.concurrent.CountDownLatch;

public class StartLatch extends Thread {
	
	private final CountDownLatch startLatch;
	private final String id;

	public StartLatch(CountDownLatch startLatch, String id) {
		this.startLatch = startLatch;
		this.id = id;
	}
	
	public void run() {
		try {
			System.out.println("-----" + id+ " waiting for start signal");
			startLatch.await();

			// ... perform task
			int sum = 0;
			int target = 50;
			do{
				Thread.sleep(1000);
				sum += (int)(Math.random() * 10);
				System.out.println("Thread " + id + "  " + sum);
			}while(sum < target);
			
			System.out.println("***** Thread " + id +  " done");
		} catch (InterruptedException iex) {
			iex.printStackTrace();
		}
	}
	
	public static void main(String[] args){
		
		// Define the latch common to all threads
		CountDownLatch startLatch = new CountDownLatch(1);
		
		for (int threadNo = 1; threadNo <= 3; threadNo++) {		
			String tempId = String.valueOf("T"+threadNo);
			Thread t = new StartLatch(startLatch, tempId);
			t.start();
		}
		
		// give the threads chance to start up
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		// the common Latch for all pending threads will be released here
		startLatch.countDown();
		System.out.println("Off they go!");
	}
}