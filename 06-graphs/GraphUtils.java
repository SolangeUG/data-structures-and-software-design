import java.util.HashSet;
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
						// remove 1 from the total number of nodes in the path found by the BFS algorithm
						List<Node> path = breadthFirstSearch.getPath();
						result = path.size() - 1;
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
		Set<String> result = null;

		if (graph != null && distance >= 1) {
			Node source = graph.getNode(src);
			if (source != null) {
				// initialize result set
				result = new HashSet<>();

				// use BFS algorithm for shortest pathts
				BreadthFirstSearch algorithm = new BreadthFirstSearch(graph);

				Set<Node> allNodes = graph.getAllNodes();
				for (Node node: allNodes) {
					boolean withinReach = algorithm.bfs(source, node.getElement());
					if (withinReach) {
						// keep track of all the nodes visited within this distance
						Set<Node> visitedNodes = algorithm.getMarked();
						int dist = visitedNodes.size() -1;
						if (dist <= distance) {
							for (Node visited: visitedNodes) {
								// exclude the source node itself
								if (! visited.getElement().equals(src)) {
									result.add(visited.getElement());
								}
							}
						}
					}

					// reset visited nodes before next search
					algorithm.clear();
				}
			}
		}
		return result;
	}

	/**
	 * Determine whether the provided list of values make up a Hamiltonian path in a graph
	 * @param g the input graph to explore
	 * @param values the list of elements
	 * @return true if the values constitute a Hamiltonian path in the graph
	 * 		   false otherwise
	 */
	public static boolean isHamiltonianPath(Graph g, List<String> values) {
		boolean isHamiltonian = false;

		if (g != null && values != null && !values.isEmpty()) {
			// arbitrarily chose a source node
			String src = values.get(0);
			Node source = g.getNode(src);
			if (source != null) {
				Set<String> visited = new HashSet<>();

				// use the BFS to determine a path between source and dest
				BreadthFirstSearch algorithm = new BreadthFirstSearch(g);

				// make sure there exists a path from the source to every other element of the list
				for (String value: values) {
					algorithm.clear();
					if (! value.equals(src)) {
						boolean pathExists = algorithm.bfs(source, value);
						// exist as soon as a path is not found between two values
						if (! pathExists) {
							return false;
						}

						// add marked nodes to visited
						for (Node node: algorithm.getMarked()) {
							if (! visited.contains(node.getElement())) {
								visited.add(node.getElement());
							}
						}
					}
				}

				// at this point, a path exists between the source node and each value of the list
				// finally, make sure all provided values have been visited/marked
				isHamiltonian = visited.containsAll(values);
			}
		}
		return isHamiltonian;
	}

	/**
	 * Tester method
	 * @param args program arguments
	 */
	public static void main(String[] args) {

		DirectedGraph directedGraph = GraphBuilder.buildDirectedGraph("graph_builder_test.txt");
		int minDistance = GraphUtils.minDistance(directedGraph, "0", "6");
		System.out.println("directed minDistance is " + minDistance);

		UndirectedGraph undirectedGraph = GraphBuilder.buildUndirectedGraph("graph_builder_test.txt");
		minDistance = GraphUtils.minDistance(undirectedGraph, "0", "0");
		System.out.println("undirected minDistance is " + minDistance);
	}

}
