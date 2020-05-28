package se.informator.t2732.concurrent.queue.xercise;

public interface ConcurrentGenericStore<T> {
	
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

}
