package se.informator.t2732.threads.xercise;

/**
 * A class that represents a property.
 * The property has a name and a value.
 */
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
	 *
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
	 * Converting object state to human readable format
	 * @return String holding current object state
	 * Output format: [<name> - <value>]
	 */
	public String toString() {
		return String.format("%s - %s", name, value);
	}
}