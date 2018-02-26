/**
 * A concrete class that represents a directed graph
 */
public class DirectedGraph extends Graph {

	/**
	 * Constructor
	 */
	public DirectedGraph() {
		super();
	}

	/**
	 * Add an edge to the graph
	 * @param source the source node
	 * @param destination the destination node
	 * @return true if the operation succeeds
	 * 		   false otherwise
	 */
	@Override
	public boolean addEdge(Node source, Node destination) {
		addNode(source); // only adds if node not already in graph.
		addNode(destination);
		boolean addEdgeSuccess = addEdgeFromTo(source, destination);
		if (addEdgeSuccess) {
			numEdges++;
		}
		return addEdgeSuccess;	
	}

	/**
	 * Remove an edge from the graph
	 * @param source the source node
	 * @param destination the destination node
	 * @return true if the operation succeeds
	 * 		   false otherwise
	 */
	@Override
	public boolean removeEdge(Node source, Node destination) {
		if (!containsNode(source) || !containsNode(destination)) {
			return false;
		}
		boolean removeEdgeSuccess = removeEdgeFromTo(source, destination);
		if (removeEdgeSuccess) {
			numEdges--;
		}
		return removeEdgeSuccess;	
	}
	

	
}
