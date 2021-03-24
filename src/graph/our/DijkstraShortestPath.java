package graph.our;

import java.util.ArrayList;
import java.util.Arrays;

public class DijkstraShortestPath {

	int[] cost;
	int[] parents;
	boolean[] visited;
	Graph graph;
	int baseNode;
	ArrayList<Integer> path;

	public DijkstraShortestPath(Graph graph) {
		this.graph = graph;
	}

	public void dijkstra(int node) {
		baseNode = node;
		cost = new int[graph.getNumberOfVertex()];
		Arrays.fill(cost, Integer.MAX_VALUE);

		parents = new int[graph.getNumberOfVertex()];
		Arrays.fill(parents, -1);

		visited = new boolean[graph.getNumberOfVertex()];

		cost[node] = 0;
		parents[node] = node;
		visited[node] = true;

		while (true) {

			for (Edge edge : graph.getListOfEdges()[node]) {
				if (cost[edge.to] > cost[node] + edge.weight) {
					cost[edge.to] = cost[node] + edge.weight;
					parents[edge.to] = node;
				}
			}
			int min = Integer.MAX_VALUE;
			for (int i = 0; i < graph.getNumberOfVertex(); i++) {
				if (cost[i] < min && !visited[i]) {
					min = cost[i];
					node = i;
				}
			}

			if (min == Integer.MAX_VALUE) {
				break;
			}
			visited[node] = true;
		}
	}

	public String shortestPathTo(int node) {
		int mainNode = node;
		path = new ArrayList<>();
		while (parents[node] != baseNode) {
			path.add(0, node);
			node = parents[node];
		}
		path.add(0, node);
		path.add(0, parents[node]);
		StringBuilder sb = new StringBuilder();
		sb.append("Path from " + baseNode + ". node to " + mainNode + ". node: ");
		for (int i = 0; i < path.size(); i++) {
			sb.append(path.get(i));
			if (i != path.size() - 1) {
				sb.append(", ");
			}
		}
		sb.append("\nCost from " + baseNode + ". node to " + mainNode + ". node: " + cost[mainNode]);
		return sb.toString();
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Costs from " + baseNode + ". node to others: ");
		for (int i = 0; i < graph.getNumberOfVertex(); i++) {
			sb.append(cost[i]);
			if (i != graph.getNumberOfVertex() - 1) {
				sb.append(", ");
			}
		}
		return sb.toString();
	}
}
