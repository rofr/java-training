package se.informator.t2732.threads;

public interface GenericStore<T> {
	
	/**
	 * Stores an object. Puts the executing thread in wait mode if the store
	 * is full. The thread gets awakened as soon as there are any slots available.
	 *
	 * @throws InterruptedException if the thread is interrupted during the wait.
	 */
	void store(T object) throws InterruptedException;
	
	/**
	 * Gets an object from the store. If the store is empty the executing thread
	 * is put in wait mode. The thread gets awakened as soon as there are any
	 * objects available.
	 *
	 * @throws InterruptedException if the thread is interrupted during the wait.
	 */
	T get() throws InterruptedException;

	/**
	 * Checking up empty status of store
	 * @return true if the store is empty and false if not.
	 */
	boolean isStoreEmpty();	

	/**
	 * Checking up full status of store	
	 * @return true if the store is full and false if not.
	 */	
	boolean isStoreFull();

	/**
	 * Signaling method - single producer done
	 * @param endBag holding status for endBag flag
	 */
	void setEndBag(boolean endBag);
		
	/**
	 * Checking up if producer thread are done
	 * @return boolean true if flag endBag is set
	 */	
	boolean isEndBag();
}
