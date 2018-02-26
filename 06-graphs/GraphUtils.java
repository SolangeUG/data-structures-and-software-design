import java.util.List;
import java.util.Set;

/**
 * SD2x Homework #6 - Methods used to explore graphs.
 * Implement the methods below according to the specification in the assignment description.
 * Please be sure not to change the signature of any of the methods!
 *
 * @author Solange U. Gasengayire
 */

public class GraphUtils {

	/**
	 * Determine the shortest distance from an element to another in a graph
	 * @param graph the input graph to explore
	 * @param src the source element
	 * @param dest the destination element
	 * @return the shortest distance between the two elements
	 */
	public static int minDistance(Graph graph, String src, String dest) {
		int result = -1;

		if (graph != null) {
			Node source = graph.getNode(src);
			if (source != null) {
				Node destination = graph.getNode(dest);
				if (destination != null) {
					// search for the shortest path between the source and destination nodes
					BreadthFirstSearch breadthFirstSearch = new BreadthFirstSearch(graph);

					// min distance is the number of edges traversed by the BFS algorithm
					boolean pathExists = breadthFirstSearch.bfs(source, dest);
					if (pathExists) {
						// remove 1 from the total number of nodes marked by the BFS algorithm
						result = breadthFirstSearch.marked.size() - 1;
					}
				}
			}
		}

		return result;
	}

	/**
	 * Return a set of elements within the specified distance of a source node
	 * @param graph the input graph to explore
	 * @param src the source element
	 * @param distance the provided distance
	 * @return the set of all elements within distance of the source element
	 */
	public static Set<String> nodesWithinDistance(Graph graph, String src, int distance) {

		
		return null;
	}

	/**
	 * Determine whether the provided list of values make up a Hamiltonian path in a graph
	 * @param g the input graph to explore
	 * @param values the list of elements
	 * @return true if the values constitute a Hamiltonian path in the graph
	 * 		   false otherwise
	 */
	public static boolean isHamiltonianPath(Graph g, List<String> values) {

		
		return true;
	}

}
