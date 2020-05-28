package se.informator.t2732.concurrent.queue.xercise;

public final class Property {

	/**
	 * The name of the property.
	 */
	private final String name;

	/**
	 * The value of the property
	 */
	private final String value;

	/**
	 * Constructs a new property object with the specified name and value.
	 * @param name the name of the property
	 * @param value the value of the property
	 */
	public Property(String name, String value) {
		this.name = name;
		this.value = value;
	}

	/**
     * Getter
	 * @return the name of the property.
	 */
	public String getName() {
		return name;
	}

	/**
     * Getter
	 * @return the value of the property.
	 */
	public String getValue() {
		return value;
	}

	/**
	 * Converts object state to text
	 * @return String holding a human readable object description 
	 */
	public String toString() {
		return String.format("%s - %s", name, value);
	}
}