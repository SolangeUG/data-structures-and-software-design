import java.util.*;

/**
 * SD2x Homework #6 - Breadth-First Search
 * This is an implementation of Breadth First Search (BFS) on a graph.
 * You may modify and submit this code if you'd like.
 */

public class BreadthFirstSearch {
	protected Set<Node> marked;
	protected Graph graph;

	// keep track of the start node
	private Node start;
	// keep track of the goal node
	private Node goal;
	// keep track of nodes from which we explore the current node
	private Map<Node, Node> parent;

	/**
	 * Constructor
	 * @param graphToSearch the input graph
	 */
	public BreadthFirstSearch(Graph graphToSearch) {
		marked = new HashSet<>();
		graph = graphToSearch;
		parent = new HashMap<>();
	}

	/**
	 * Determine whether there is a path from a node to an element in a graph
	 * @param start the starting node
	 * @param elementToFind the element to find
	 * @return true if a path exists from the source node to the element
	 * 		   false otherwise
	 */
	public boolean bfs(Node start, String elementToFind) {
		if (!graph.containsNode(start)) {
			return false;
		}

		// reinitialize marked and parent data structures
		this.clear();

		if (start.getElement().equals(elementToFind)) {
			// keep track of the node from which we explore the current node
			parent.put(start, start);
			return true;
		}

		// keep track of the start and goal nodes in order to reconstruct the path
		this.start = start;
		this.goal = graph.getNode(elementToFind);

		Queue<Node> toExplore = new LinkedList<>();
		marked.add(start);
		toExplore.add(start);
		while (!toExplore.isEmpty()) {
			Node current = toExplore.remove();
			for (Node neighbor : graph.getNodeNeighbors(current)) {
				if (! marked.contains(neighbor)) {
					// keep track of the parent node from which we will explore the neighbor node
					parent.put(neighbor, current);
					
					if (neighbor.getElement().equals(elementToFind)) {
						return true;
					}
					marked.add(neighbor);
					toExplore.add(neighbor);
				}
			}
		}
		return false;
	}

	/**
	 * Return the path if one was found by the BFS algorithm
	 * @return the path from the start to the goal nodes
	 */
	public List<Node> getPath() {
		LinkedList<Node> path = new LinkedList<>();
		Node current = goal;
		while (current != start && current != null) {
			path.addFirst(current);
			current = parent.get(current);
		}
		path.addFirst(start);
		return path;
	}

	/**
	 * Return the set of marked nodes
	 * @return marked
	 */
	public Set<Node> getMarked() {
		return marked;
	}

	/**
	 * Reset set of marked/visited nodes
	 */
	private void clear() {
		if (marked != null) {
			marked.clear();
		}
		if (parent != null) {
			parent.clear();
		}
	}
	

}
