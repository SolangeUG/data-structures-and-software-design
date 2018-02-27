import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * A class that represents a graph as an adjacency set
 */
public abstract class Graph {
	protected Map<Node, Set<Edge>> adjacencySets;
	protected int numNodes;
	protected int numEdges;
	protected Map<String, Node> elementToNode;

	/*
	 * These methods need to be overridden by subclasses.
	 */
	public abstract boolean addEdge(Node node1, Node node2);
	public abstract boolean removeEdge(Node node1, Node node2);

	/**
	 * Constructor
	 */
	public Graph() {
		adjacencySets = new HashMap<>();
		elementToNode = new HashMap<>();
		numNodes = 0;
		numEdges = 0;
	}

	/**
	 * Add a node to the graph
	 * @param newNode the node to be added
	 * @return true if the operation succeeds
	 * 		   false otherwise
	 */
	public boolean addNode(Node newNode) {
		if (newNode == null || containsNode(newNode)) {
			return false;
		}
		Set<Edge> newAdjacencySet = new HashSet<>();
		adjacencySets.put(newNode, newAdjacencySet);
		elementToNode.put(newNode.getElement(), newNode);
		numNodes++;
		return true;
	}

	/**
	 * Return the given node's neighbors in the graph
	 * @param node the input node
	 * @return the set of the input node's neighbors
	 */
	public Set<Node> getNodeNeighbors(Node node) {
		if (!containsNode(node)) {
			return null;
		}
		Set<Edge> nodeEdges = adjacencySets.get(node);
		Set<Node> nodeNeighbors= new HashSet<>();
		for (Edge e : nodeEdges) {
			Node neighbor = e.getDestination();
			nodeNeighbors.add(neighbor);
		}
		return nodeNeighbors;
	}

	/**
	 * Add an edge between two nodes
 	 * @param source the source node
	 * @param destination the destination node
	 * @return true if the operation succeeds
	 * 		   false otherwise
	 */
	protected boolean addEdgeFromTo(Node source,
			Node destination) {
		Edge newEdge = new Edge(source, destination);
		Set<Edge> sourceEdges = adjacencySets.get(source);
		if (!sourceEdges.contains(newEdge)) {
			sourceEdges.add(newEdge);
			return true;
		}
		return false;
	}

	/**
	 * Delete an edge connecting two nodes
	 * @param source the source node
	 * @param destination the destination node
	 * @return true if the operation succeeds
	 * 		   false otherwise
	 */
	protected boolean removeEdgeFromTo(Node source,
			Node destination) {
		Edge toRemove = new Edge(source, destination);
		Set<Edge> sourceEdges = adjacencySets.get(source);
		if (sourceEdges.contains(toRemove)) {
			sourceEdges.remove(toRemove);
			return true;
		}
		return false;
	}

	/**
	 * Return the number of nodes in the graph
	 * @return node count
	 */
	public int getNumNodes() {
		return numNodes;
	}

	/**
	 * Return the number of edges in the graph
	 * @return edge count
	 */
	public int getNumEdges() {
		return numEdges;
	}

	/**
	 * Return the starting node
	 * @return the staring node if the graph is not empty
	 * 		   null otherwise
	 */
	public Node getStartingNode() {
		Iterator<Node> iter = adjacencySets.keySet().iterator();
		if (iter.hasNext()) {
			return iter.next();
		}
		return null;
	}

	/**
	 * Return a set of all the nodes of the graph
	 * @return all the nodes in the graph
	 */
	public Set<Node> getAllNodes() {
		return adjacencySets.keySet();
	}

	/**
	 * Return a set of edges from and to the given node
	 * @param node the input node
	 * @return all the edges adjacent to the given node
	 */
	public Set<Edge> getNodeEdges(Node node) {
		if (!containsNode(node)) {
			return null;
		}
		return adjacencySets.get(node);
	}

	/**
	 * Does the graph contain a given node?
	 * @param node the input node
	 * @return true if the node is in the graph
	 * 		   false otherwise
	 */
	public boolean containsNode(Node node) {
		return adjacencySets.containsKey(node);
	}

	/**
	 * Return the node that corresponds to a given element
	 * @param element the input string element
	 * @return its corresponding node
	 */
	public Node getNode(String element) {
		
		if (!elementToNode.containsKey(element)) {
    		Node newNode = new Node(element);
    		elementToNode.put(element, newNode);
    		return newNode;
    	}
    	
		return elementToNode.get(element);
	}

	/**
	 * Determine whether the graph contains a given string element
	 * @param element the input value
	 * @return true if the element is found in the graph
	 * 		   false otherwise
	 */
	public boolean containsElement(String element) {
		return elementToNode.containsKey(element);
	}
}
