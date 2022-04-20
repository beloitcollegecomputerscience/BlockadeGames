package application;

import java.text.ParseException;
import java.util.Arrays;

/**
 * A "Graph" includes simple graphs and directed graphs. It may allow self-loops, but does not 
 * that support Weighted Graphs
 * 
 * @author Design and coding by Darrah Chavey.
 * 
 */

 public class Graph {

	/** How many vertices are in the graph? */
	protected int numOfVertices;
	
	/** An adjacency matrix representation of the graph. */
	protected boolean[][] adjacencyMatrix;

	/** String labels to describe the vertices. Use is optional. They can be used to 
	 *  distinguish between the nodes, connect them with their meaning in a particular 
	 *  application, etc. The screen drawing method supports printing these labels 
	 *  onto the screen near the vertex. A natural default set of labels is to simply
	 *  number them in the order they are held in the adjacency matrix. A method is
	 *  provided to create this numbered set of labels. 
	 */
	protected String[] labels;


	/*  The first set of methods are constructors and related methods, such as clones.  */

	/**
	 * Constructor for a Graph with n vertices, no edges, and null labels for the vertices. This 
	 * constructor must be completed by the inheriting sub-class to define how edges are stored.
	 * 
	 * @param size   the number of vertices for this Graph
	 * @pre   size   is a positive number.
	 * @post         This Graph has n vertices, labeled 0 to size-1. It has no edges.
	 * @post         No edges, or structure to record the edges, has been defined.
	 * @throws OutOfMemoryError
	 *			     if there was insufficient memory for the specified number of nodes.
	 * @throws IllegalArgumentException  
	 *               if the specified size was zero or negative.
	 */
	public Graph(int size) throws IllegalArgumentException, OutOfMemoryError {
		if (size  <= 0) {
			throw new IllegalArgumentException("Can't have a graph with " + size + " vertices.");
		}
		numOfVertices = size;
		labels = new String[size];
		if (labels.length != size) {
			throw new OutOfMemoryError("Insufficient memory to create this graph.");			
		}
	}
	
	/**
	 * Create a duplicate of the desired Graph. Copies vertices, edges, and labels. 
	 * A deep copy (so later changes to this graph will have no effect on the cloned 
	 * graph, and vice-versa). 
	 * 
	 * @param toClone  the Graph to be duplicated
	 * @post           This Graph has the same number of vertices and the same labels as the input
	 *                 graph. There is no linkage between elements of this graph and those of the 
	 *                 input graph.
	 * @post           No edges, or structure to record the edges, have been defined to hold the 
	 *                 clone of the edges from the original graph.
	 * @throws OutOfMemoryError
	 *                 if there was insufficient memory for the specified new graph.
	 */
	public Graph(Graph toClone) throws OutOfMemoryError {
		numOfVertices = toClone.numOfVertices;
		labels = new String[numOfVertices];
		if (labels.length != numOfVertices) {
			throw new OutOfMemoryError("Insufficient memory to create labels for this graph.");			
		}
		for (int i = 0; i < numOfVertices; i++) {
			if (toClone.labels[i] != null) {
				labels[i] = new String(toClone.labels[i]);
			} // else we leave it null, just like the one we're cloning.
		}

		// Now clone the adjacency matrix
		int row, col;
		for (row = 0; row < numOfVertices; row++) {
			for (col = 0; col < numOfVertices; col++) {
				if ((row != col) && ( isEdge(row, col) )) {
					toClone.addEdge( row, col, 1 );
				}
			}
			if (labels[row] != null) {
				toClone.labels[row] = new String( labels[row] );
				if (toClone.labels[row] == null) {
					throw new OutOfMemoryError();
				}
			}
		}
	}


	/**
	 * Add a new undirected edge to this Graph.
	 * 
	 * @param source
	 *            the vertex number of the source of the new edge
	 * @param target
	 *            the vertex number of the target of the new edge
	 * @pre Both source and target are nonnegative and less than vertices().
	 * @post This Graph has all the edges that it originally had plus another
	 *       edge from the specified source to the specified target. If the edge
	 *       was already present, then this Graph is unchanged; if one direction
	 *       of the edge was already present, that edge is now bi-directional.
	 * @throws ArrayIndexOutOfBoundsException
	 *             if the source or target was not a valid vertex number.
	 */
	public void addEdge(int source, int target, double weight) 
					throws ArrayIndexOutOfBoundsException {
		adjacencyMatrix[source][target] = true;
		adjacencyMatrix[target][source] = true;
	}


	/**
	 * Remove an edge (undirected) from this Graph.
	 * 
	 * @param source
	 *            the vertex number of the source of the removed edge.
	 * @param target
	 *            the vertex number of the target of the removed edge.
	 * @pre Both source and target are nonnegative and less than vertices().
	 * @post This Graph has all the edges that it originally had minus any edge
	 *       connecting the specified source to the specified target. If there
	 *       was no edge connecting the source to the target or vice versa, then
	 *       this Graph is unchanged.
	 * @throws ArrayIndexOutOfBoundsException
	 *             if the source or target was not a valid vertex number.
	 */
	public void removeEdge(int source, int target)
			throws ArrayIndexOutOfBoundsException {
		adjacencyMatrix[source][target] = false;
		adjacencyMatrix[target][source] = false;
	}
	
	
	/**
	 * Mutator method to change the label associated with a vertex of this Graph.
	 * 
	 * @param vertex     a vertex number.
	 * @param newLabel   a new label (which may be null).
	 * @pre   vertex     is nonnegative and less than vertices().
	 * @post             The label of the specified vertex in this Graph has been changed to
	 *                   the newLabel.
	 * @throws ArrayIndexOutOfBoundsException
	 *                   if the specified vertex was not a valid vertex number.
	 */
	public void setLabel(int vertex, String newLabel)
						throws ArrayIndexOutOfBoundsException {
		labels[vertex] = newLabel;
	}

	/* The third set of methods allow us to make queries of the graph data structure.
	 * These methods are restricted to basic low-level properties, such as the
	 * existence of edges, degree of a vertex, etc.
	 */

	/** 
	 * Decide whether the graph passed in is equivalent, as a labeled graph, to "this" graph. 
	 * The comparison ignores any differences in labels on the vertices. However, it only
	 * detects equivalence if the ordering of the vertices is the same. Renumbering the vertices
	 * of a graph will (usually) result in graphs that are "isomorphic", but are not identical.
	 * For example, a path graph with 3 vertices will have three non-identical representations, 
	 * one each with vertex 0, 1, or 2 as the center vertex (of degree 2). <BR>
	 * For undirected graphs, this can be overridden to check edges in only one direction.
	 *  
	 * @param toCompare   the graph to be compared against "this" graph.
	 * @return true       if the graphs are identical, false otherwise.
	 */
	public boolean isIdenticalTo(Graph toCompare) {
		if ((toCompare.getClass() != this.getClass()) || 
				(getNumOfVertices() != toCompare.getNumOfVertices())) { 
			return false;
		}
		int row, col;
		for (row = 0; row < getNumOfVertices(); row++) {
			for (col = 0; col < getNumOfVertices(); col++) {
				if (isEdge(row, col) != toCompare.isEdge(row, col)) {
					return false;
				}
			}			
		}
		return true;
	}

	/**
	 * Accessor method to get the label of a vertex of this Graph.
	 * 
	 * @param vertex    a vertex number whose label is desired
	 * @pre   vertex    is nonnegative and less than vertices().
	 * @return          the label of the specified vertex in this Graph
	 * @throws ArrayIndexOutOfBoundsException
	 *                  if the specified vertex was not a valid vertex number.
	 */
	public String getLabel(int vertex) throws ArrayIndexOutOfBoundsException {
		return labels[vertex];
	}
	
	/**
	 * Accessor method to get the full set of labels for the graph.
	 * 
	 * @return          the labels of all vertices in this Graph
	 */
	public String[ ] getLabels( ) {
		return labels;
	}
	
	/** "Default" labels are the numbers 0..size-1, each associated with the corresponding
	 *  vertex. If the rows/columns are re-arranged, the labels move with them. They can
	 *  be re-assigned to their "new values" by simply calling this method again.
	 */
	public void setDefaultLabels( ) {
		for (int i=0; i<numOfVertices; i++) {
			labels[i] = String.valueOf( i );
		}
	}

	/**
	 * Accessor method to determine whether this Graph contains a specified edge.
	 * 
	 * @param source   the vertex number of the source of the specified edge.
	 * @param target   the vertex number of the target of the specified edge.
	 * @pre            Both source and target are nonnegative and less than vertices().
	 * @return         true if this Graph has an edge from the specified source to the specified 
	 *                 target; otherwise returns false.
	 * @throws ArrayIndexOutOfBoundsException
	 *                 if the source or target was not a valid vertex number.
	 */
	public boolean isEdge(int source, int target) throws ArrayIndexOutOfBoundsException {
		return adjacencyMatrix[source][target];
	}

	/**
	 * The degree of a vertex is the number of edges coming out of that vertex. <BR>
	 * This method is not guaranteed to be faster than O(N), so if you intend to use 
	 * this several times on an unchanging graph, you should store the values after 
	 * getting them.
	 * 
	 * @param vertex  a vertex number whose degree (number of neighbors) is desired.
	 * @pre   vertex  is nonnegative and less than vertices().
	 * @return        a count of all the vertices that are targets for edges with a 
	 *                source at the specified vertex.
	 * @throws ArrayIndexOutOfBoundsException
	 *                if the specified vertex was not a valid vertex number.
	 */
	public int degree(int vertex) throws ArrayIndexOutOfBoundsException {
		int targetVertex, vertexEdges = 0;
		for (targetVertex = 0; targetVertex < numOfVertices; targetVertex++) {
			if (isEdge(vertex, targetVertex)) {
				vertexEdges++;
			}
		}
		return vertexEdges;	
	}
	
	/** Getter for the number of vertices in the graph.
	 * @return the number of vertices in the graph.
	 */
	public int getNumOfVertices() {
		return numOfVertices;
	}
	
	/** 
	 * Report the total number of edges in this Graph. This is an O(N) operation, or
	 * O( n^2 ) if the degreeSequence has not been calculated. So if a particular 
	 * implementation of a graph can do this faster, they should override this.
	 *     
	 * @return     the total number of edges in this Graph.
	 */
	public int getNumOfEdges() {
		int totalEdges = 0;
		for (int vertex = 0; vertex < numOfVertices; vertex++) {
			totalEdges += degree(vertex);
		}
		return (totalEdges/2);	// Every edge was counted twice
	}

	/** Convert an array of N Strings, where N is the number of vertices in the graph, into the
	 *  edges of the graph. Assumes that "numOfVertices" and "labels" have been initialized, and 
	 *  that each of the N strings contains a representation of the edges adjacent to the N 
	 *  vertices of the graph. These strings should consist of N characters, with 0 for no edge 
	 *  and 1 for an edge. Any character other than 0 is converted into a 1. 
	 *  
	 * 
	 *  @param edgeDescriptors an array of strings describing the edges adjacent to the vertices
	 *         of the graph; one string for each vertex.
	 *  @throws ParseException if an input string is an invalid representation of the edges at a
	 *         vertex. The "offset" reported is the vertex whose corresponding string is invalid.
	 *  @throws OutOfMemoryError
	 *             if there was insufficient memory to create the specified new graph.
	 *  @BUG Doesn't verify that the graph is undirected; you could pass in a string
	 *       describing a DirectedGraph, and it would proceed to think it was creating
	 *       a SimpleGraph, but not actually do so.
	 */
	protected void stringsToEdges( String[] edgeDescriptors ) 
				throws ParseException, OutOfMemoryError {
		// Create object data variables:
		adjacencyMatrix = new boolean[numOfVertices][];
		if (adjacencyMatrix.length < numOfVertices) {
			throw new OutOfMemoryError();
		}
		for (int row = 0; row < numOfVertices; row++) {
			adjacencyMatrix[row] = new boolean[numOfVertices];
		}
		if (adjacencyMatrix[numOfVertices-1].length < numOfVertices) {
			throw new OutOfMemoryError();
		}

		// Initialize the adjacency matrix as specified by the inputString
		for (int i=0; i<numOfVertices; i++) {
			String line = edgeDescriptors[i];
			if (line.length() != numOfVertices) {
				throw new ParseException("Bad format: Adjacency matrix", i);
			}
			for (int j=0; j<numOfVertices; j++) {
				adjacencyMatrix[i][j] = (line.charAt(j)!='0');
			}
		}
	}

	/** 
	 * Report the total number of edges in this Graph. For SimpleGraphs, this is the total number
	 * of undirected edges.
	 *     
	 * @return     the total number of edges in this Graph.
	 */
	public int total_edges()  {
		int row, col, totalEdges=0;
		for (row = 0; row < numOfVertices; row++) {
			for (col = 0; col < row; col++) {
				if ( isEdge(row, col) ) { 
					totalEdges++;
				}
			}
		}
		return totalEdges;
	}


}