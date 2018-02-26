/**
 * A class that represents an edge in a graph
 */
public class Edge {
	private final Node source;
	private final Node destination;

	/**
	 * Constructor
	 * @param source the source node
	 * @param destination the destination node
	 */
	public Edge(Node source, Node destination) {
		this.source = source;
		this.destination = destination;
	}

	/**
	 * Is this edge equal to the other?
	 * @param obj the other edge to compare to
	 * @return true if the two edges are equal
	 * 		   false otherwise
	 */
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Edge)) {
			return false;
		}
		Edge otherEdge = (Edge) obj;
		Node otherSource = otherEdge.getSource();
		Node otherDest = otherEdge.getDestination();

		return (otherSource.equals(source)
			 && otherDest.equals(destination));
	}

	/**
	 * Return this edge integer representation
	 * @return this edge as an int
	 */
	@Override
	public int hashCode() {
		return source.hashCode() + destination.hashCode();
	}

	/**
	 * Return this edge's source node
	 * @return source node
	 */
	public Node getSource() {
		return source;
	}

	/**
	 * Return this edge's destination node
	 * @return destination node
	 */
	public Node getDestination() {
		return destination;
	}
	

}
