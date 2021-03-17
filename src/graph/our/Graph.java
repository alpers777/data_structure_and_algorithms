package graph.our;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Graph {
	
	private int numberOfVertex;
	
	private Edge[][] listOfEdge;
	
	public Graph(int numberOfVertex, Edge[][] edges) {
		super();
		this.numberOfVertex = numberOfVertex;
		this.listOfEdge = edges;
	}
	
	public void shortestPath(int v) {
		int[] cost = new int[numberOfVertex];
		Arrays.fill(cost, Integer.MAX_VALUE);

		int[] parents = new int[numberOfVertex];
		Arrays.fill(parents, -1);
		
		boolean[] visited = new boolean[numberOfVertex]; 
		
		cost[v] = 0;
		parents[v] = v;
		visited[v] = true;
		
		while(true) {
			
			System.out.println(Arrays.toString(cost));
			System.out.println(Arrays.toString(parents));
			System.out.println(Arrays.toString(visited));
			
			for (Edge edge : listOfEdge[v]) {
				if (cost[edge.to] > cost[v] + edge.weigth) {
					cost[edge.to] = cost[v] + edge.weigth;
					parents[edge.to] = v;
				}
			}
			int min = Integer.MAX_VALUE;
			for (int i = 0; i < numberOfVertex; i++) {
				if (!visited[i] && cost[i] < min) {
					min = cost[i];
					v = i;
				}
			}
			
			if (min == Integer.MAX_VALUE)
				break;
			
			visited[v] = true;
		}
		

	}
	

	public MST mst() {
		List<int[]> list =new ArrayList<int[]>();
		int totalCost = 0;
		
		Set<Integer> visitedSet = new HashSet<Integer>();
		
		Edge minEdge = minEdge();
		visitedSet.add(minEdge.from);
		visitedSet.add(minEdge.to);
		
		list.add(new int[]{minEdge.from, minEdge.to});
		totalCost += minEdge.weigth;
		
		while(true) {
			minEdge = null;
			for (Integer v : visitedSet) {
				for (Edge edge : listOfEdge[v]) {
					if (!visitedSet.contains(edge.to)) {
						if (minEdge == null || minEdge.weigth > edge.weigth)
							minEdge = edge;
					}
				}
			}
			if (minEdge == null) 
				break;
			
			visitedSet.add(minEdge.to);
			list.add(new int[]{minEdge.from, minEdge.to});
			totalCost += minEdge.weigth;
		}
		
		return new MST(list, totalCost);
	}

	private Edge minEdge() {
		Edge min = null;
		for (Edge[] edges : listOfEdge) {
			for (Edge edge : edges) {
				if (min == null || min.weigth > edge.weigth) {
					min = edge;
				}
			}
		}
		return min;
	}


	public static void main(String[] args) {
		Edge[][] edges = {
			{new Edge(0, 1, 6), new Edge(0, 5, 5)},
			{new Edge(1, 0, 6), new Edge(1, 2, 10), new Edge(1, 5, 8), new Edge(1, 6, 7)},
			{new Edge(2, 1, 10), new Edge(2, 3, 8), new Edge(2, 4, 10), new Edge(2, 6, 5)},
			{new Edge(3, 2, 8), new Edge(3, 4, 8)},
			{new Edge(4, 2, 10), new Edge(4, 3, 8), new Edge(4, 5, 12), new Edge(4, 6, 7)},
			{new Edge(5, 0, 5), new Edge(5, 1, 8), new Edge(5, 4, 12), new Edge(5, 6, 7)},
			{new Edge(6, 1, 7), new Edge(6, 2, 5), new Edge(6, 4, 7), new Edge(6, 5, 7)}
		};
		Graph graph = new Graph(7, edges);
		
		MST mst = graph.mst();
		System.out.println(mst);
		
		graph.shortestPath(1);
	}


}

class MST {
	List<int[]> list;
	int totalCost;
	
	public MST(List<int[]> list, int totalCost) {
		this.list = list;
		this.totalCost = totalCost;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("MST\n");
		sb.append("List:\n");
		for (int[] edge : list) {
			sb.append(Arrays.toString(edge));
			sb.append(" ");
		}
		sb.append("\n");
		sb.append("totalCost = ");
		sb.append(totalCost);
		sb.append("\n");
		return sb.toString();
	}
	
	
}

class Edge {
	int from;
	int to;
	int weigth;
	
	public Edge(int from, int to, int weigth) {
		this.from = from;
		this.to = to;
		this.weigth = weigth;
	}
	
	
}