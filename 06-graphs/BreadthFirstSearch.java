import java.util.*;

/**
 * SD2x Homework #6 - Breadth-First Search
 * This is an implementation of Breadth First Search (BFS) on a graph.
 * You may modify and submit this code if you'd like.
 */

public class BreadthFirstSearch {
	protected Set<Node> marked;
	protected Graph graph;

	/**
	 * Constructor
	 * @param graphToSearch the input graph
	 */
	public BreadthFirstSearch(Graph graphToSearch) {
		marked = new HashSet<>();
		graph = graphToSearch;
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

		if (start.getElement().equals(elementToFind)) {
			return true;
		}

		Queue<Node> toExplore = new LinkedList<>();
		marked.add(start);
		toExplore.add(start);
		while (!toExplore.isEmpty()) {
			Node current = toExplore.remove();
			for (Node neighbor : graph.getNodeNeighbors(current)) {
				if (! marked.contains(neighbor)) {
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
	 * Compute the shortest path between two nodes of the graph if it exists
	 * @param source the source node
	 * @param goal the end node
	 * @return the shortest path if it exists
	 * 		   an empty list if no path exists between the two nodes
	 */
	public List<Node> bfs(Node source, Node goal) {
		List<Node> path = new LinkedList<>();

		boolean found = false;
		// parentMap is the map that links each node to the one from which it was discovered
		Map<Node, Node> parentMap = new HashMap<>();

		Queue<Node> toExplore = new LinkedList<>();
		toExplore.add(source);

		while (! toExplore.isEmpty()) {
			Node current = toExplore.poll();

			if (current == goal) {
				found = true;
				break;
			}

			// add current's neighbors to the queue
			List<Node> neighbors = new LinkedList<>(graph.getNodeNeighbors(current));
			ListIterator<Node> it = neighbors.listIterator(neighbors.size());
			while (it.hasPrevious()) {
				Node next = it.previous();
				if (! marked.contains(next)) {
					marked.add(next);
					parentMap.put(next, current);
					toExplore.add(next);
				}
			}
		}

		// if a path was found, reconstruct the path
		if (found) {
			path = constructPath(source, goal, parentMap);
		}

		return path;
	}

	/**
	 * Construct the path found by the BFS method
	 * @param start	The starting node in the graph
	 * @param goal	The goal node in the graph
	 * @param parentMap The map that links each node to the one
	 * 					from which it was discovered
	 * @return the reconstructed path from the start node to the goal node
	 */
	private List<Node> constructPath(Node start, Node goal, Map<Node, Node> parentMap) {
		LinkedList<Node> path = new LinkedList<>();
		// Reconstruction of the path from the goal node back to the start node
		Node current = goal;
		while (current != start) {
			path.addFirst(current);
			current = parentMap.get(current);
		}
		path.addFirst(start);
		return path;
	}

}
