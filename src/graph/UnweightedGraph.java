package graph;

import java.util.List;

import collection.list.library.LinkedList;

public class UnweightedGraph<V> extends AbstractGraph<V> {
	/** Construct an empty graph */
	public UnweightedGraph() {
	}

	/** Construct a graph from vertices and edges stored in arrays */
	public UnweightedGraph(V[] vertices, int[][] edges) {
		super(vertices, edges);
	}

	/** Construct a graph from vertices and edges stored in List */
	public UnweightedGraph(List<V> vertices, List<Edge> edges) {
		super(vertices, edges);
	}

	/** Construct a graph for integer vertices 0, 1, 2 and edge list */
	public UnweightedGraph(List<Edge> edges, int numberOfVertices) {
		super(edges, numberOfVertices);
	}

	/** Construct a graph from integer vertices 0, 1, and edge array */
	public UnweightedGraph(int[][] edges, int numberOfVertices) {
		super(edges, numberOfVertices);
	}
	
	public int[] myBfs(int v) {
		int[] parents = new int[getSize()];
		parents[v] = v;
		
		boolean[] visited = new boolean[getSize()];
		visited[v] = true;
		
		LinkedList<Integer> queue = new LinkedList<>();
		queue.addLast(v);
		
		while(!queue.isEmpty()) {
			int root = queue.removeFirst();
			
			for(int neighbor : getNeighbors(root)) {
				if(!visited[neighbor]) {
					parents[neighbor] = root;
					visited[neighbor] = true;
					
					queue.addLast(neighbor);
				}
			}
		}
		
		
		return parents;
	}

	public int[] myDfs(int v) {
		int[] parents = new int[getSize()];
		parents[v] = v;
		
		boolean[] visited = new boolean[getSize()];
		visited[v] = true;
		
		myDfs(v, parents, visited);
		
		return parents;
	}
	
	private void myDfs(int root, int[] parents, boolean[] visited) {
		
		for(int neighbor : getNeighbors(root)) {
			if(!visited[neighbor]) {
				parents[neighbor] = root;
				visited[neighbor] = true;
				myDfs(neighbor, parents, visited);
			}
		}
	}
	
}
