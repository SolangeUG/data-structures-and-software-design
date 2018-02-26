/**
 * A class that represents a node in a graph
 */
public class Node {
	protected String element;

	/**
	 * Constructor
	 * @param element the value of this node
	 */
	public Node(String element) {
		this.element = element;
	}

	/**
	 * Return the value of this node
	 * @return element
	 */
	public String getElement() {
		return element;
	}

	/**
	 * Return the string representation of this node
	 * @return this node as a string
	 */
	public String toString() {
		return element;
	}

}
