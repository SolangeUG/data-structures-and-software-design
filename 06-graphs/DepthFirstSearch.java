import java.util.HashSet;
import java.util.Set;

/**
 * SD2x Homework #6 - Depth-First Search
 * This is an implementation of Depth First Search (DFS) on a graph.
 * You may modify and submit this code if you'd like.
 */

public class DepthFirstSearch {
	protected Set<Node> marked;
	protected Graph graph;

	/**
	 * Constructor
	 * @param graphToSearch the input graph
	 */
	public DepthFirstSearch(Graph graphToSearch) {
		marked = new HashSet<Node>();
		graph = graphToSearch;
	}

	/**
	 * Determine whether a path exists between a given node and an element in the graph
	 * @param start the source node
	 * @param elementToFind the element to find
	 * @return true if such a path exists
	 * 		   false otherwise
	 */
	public boolean dfs(Node start, String elementToFind) {
		if (!graph.containsNode(start)) {
			return false;
		}	
	
		if (start.getElement().equals(elementToFind)) {
			return true;
		} else {
			marked.add(start);
			for (Node neighbor : graph.getNodeNeighbors(start)) {
				if (!marked.contains(neighbor) && 
				    dfs(neighbor, elementToFind))
	             return true;
			}
			return false;
		}
	}
	

}
