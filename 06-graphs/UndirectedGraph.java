/**
 * A concrete class that represents an undirected graph
 */
public class UndirectedGraph extends Graph {

	/**
	 * Constructor
	 */
	public UndirectedGraph() {
		super();
	}

	/**
	 * Add an edge to the graph
	 * @param node1 the source node
	 * @param node2 the desctination node
	 * @return true if the operation succeeds
	 * 		   false otherwise
	 */
	@Override
	public boolean addEdge(Node node1, Node node2) {
		addNode(node1); // only adds if node not already in graph.
		addNode(node2);
		boolean addEdgeSuccess = (
           addEdgeFromTo(node1, node2)
        && addEdgeFromTo(node2, node1));
		if (addEdgeSuccess) {
			numEdges++;
		}
		return addEdgeSuccess;	
	}

	/**
	 * Remove an edge from the graph
	 * @param node1 the source node
	 * @param node2 the destination node
	 * @return true if the operation succeeds
	 * 		   false otherwise
	 */
	@Override
	public boolean removeEdge(Node node1, Node node2) {
		if (!containsNode(node1) || !containsNode(node2)) {
			return false;
		}
		boolean removeEdgeSuccess = (
           removeEdgeFromTo(node1, node2)
        && removeEdgeFromTo(node2, node1));
		if (removeEdgeSuccess) {
			numEdges--;
		}
		return removeEdgeSuccess;	
	}
	

}
