import java.io.BufferedReader;
import java.io.FileReader;

/**
 * A utility class to create directed and undirected graphs
 */
public class GraphBuilder {

	/**
	 * Return a directed graph from a source file
	 * @param filename the data file
	 * @return a directed graph from the supplied data
	 */
	public static DirectedGraph buildDirectedGraph(String filename) {
		DirectedGraph dg = new DirectedGraph();
		try {
			buildGraph(dg, filename);
		}
		catch (Exception e) {
			System.out.println("An exception occurred while trying to read " + filename + ": " + e);
			return null;
		}
		return dg;
	}

	/**
	 * Return an undirected graph from a source file
	 * @param filename the data file
	 * @return an undirected graph from the supplied data
	 */
	public static UndirectedGraph buildUndirectedGraph(String filename) {
		UndirectedGraph ug = new UndirectedGraph();
		try {
			buildGraph(ug, filename);
		}
		catch (Exception e) {
			System.out.println("An exception occurred while trying to read " + filename + ": " + e);
			return null;
		}
		return ug;
	}

	/**
	 * Create relationships in a graph
	 * @param graph the input graph to build
	 * @param filename the file containing the graph relationships
	 * @throws Exception if the file does not exist or cannot be read
	 */
	protected static void buildGraph(Graph graph, String filename) throws Exception {
		try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
		    String line;
		    while ((line = br.readLine()) != null) {
		    	String[] edge = line.split(" ");
		    	if (edge.length < 2) 
		    		continue;
		    	String source = edge[0];
		    	String destination = edge[1];

		    	Node sourceNode = graph.getNode(source);
		    	Node destinationNode = graph.getNode(destination);
		    	graph.addEdge(
		    			sourceNode, destinationNode);
		    }
		}
	}
	


}
