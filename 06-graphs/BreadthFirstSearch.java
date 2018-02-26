import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

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
				if (!marked.contains(neighbor)) {
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
	 * Return the set of marked nodes
	 * @return marked
	 */
	public Set<Node> getMarked() {
		return marked;
	}

	/**
	 * Reset set of marked/visited nodes
	 */
	public void clear() {
		if (marked != null) {
			marked.clear();
		}
	}
	

}
