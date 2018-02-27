import java.util.HashSet;
import java.util.LinkedList;
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
			// does the graph contain the src element?
			if (graph.containsElement(src)) {

				// initialize result set
				result = new HashSet<>();

				Set<Node> allNodes = graph.getAllNodes();
				for (Node node: allNodes) {
					String element = node.getElement();
					if (! element.equals(src)) {
						// compute the minDistance of each node to the src element
						int dist = minDistance(graph, src, element);
						if (dist > -1 && dist <= distance) {
							result.add(node.getElement());
						}
					}
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

			// are all the values in the graph?
			if (! arePathValuesValid(g, values)) {
				return false;
			}

			// a Hamiltonian path must contain the source node twice exactly!
			String source = getSourceElement(values);
			if (source == null)  {
				return false;
			}

			// variable initialization
			Node sourceNode = g.getNode(source);
			Set<String> visited = new HashSet<>();
			BreadthFirstSearch algorithm = new BreadthFirstSearch(g);

			// is each value in the list reachable from the src element?
			for (String value : values) {
				//TODO find something that works!
			}

			// finally are all the values in the set of marked nodes?
			isHamiltonian = visited.containsAll(values);

		}
		return isHamiltonian;
	}

	/**
	 * Determine whether all the elements in the list are in the graph
	 * @param graph the graph to be explored
	 * @param values the list of elements
	 * @return true if all the elements of the list are in the graph
	 * 		   false otherwise
	 */
	private static boolean arePathValuesValid(Graph graph, List<String> values) {
		boolean result = false;

		if (values != null && graph != null) {
			for (String value : values) {
				result = graph.containsElement(value);
				if (! result) {
					return false;
				}
			}
		}
		return result;
	}

	/**
	 * Identify the source element from a potential cyclic path
	 * @param values the list of elements
	 * @return the source element if present exactly twice
	 * 		   null otherwise
	 */
	private static String getSourceElement(List<String> values) {
		String source = null;
		boolean sourceFound;
		for (String value : values) {
			sourceFound = values.indexOf(value) != values.lastIndexOf(value);
			if (sourceFound) {
				source = value;
				break;
			}
		}
		return source;
	}

	/**
	 * Tester method
	 * @param args program arguments
	 */
	public static void main(String[] args) {

		List<String> var1 = createValidPath();

		UndirectedGraph var2 = GraphBuilder.buildUndirectedGraph("is_hamiltonian_path_test.txt");
		boolean var3 = GraphUtils.isHamiltonianPath(var2, var1);
		System.out.println("Is it Hamiltonian? " + var3);

//		UndirectedGraph var2 = GraphBuilder.buildUndirectedGraph("is_hamiltonian_path_test.txt");
//		boolean var3 = GraphUtils.isHamiltonianPath(var2, var1);
//		System.out.println("Is it Hamiltonian? " + var3);
	}

	protected static List<String> createValidPath() {
		List<String> var1 = new LinkedList<>();
		var1.add("0");
		var1.add("1");
		var1.add("2");
		var1.add("3");
		var1.add("4");
		var1.add("5");
		var1.add("0");
		return var1;
	}

}
