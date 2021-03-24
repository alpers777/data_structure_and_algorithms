package graph.our;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//Prim's
public class MinimumSpanningTree {

	List<int[]> list;
	int totalCost;
	Graph graph;

	public MinimumSpanningTree(Graph graph) {
		this.graph = graph;
	}

	public void MST() {
		list = new ArrayList<int[]>();
		int totalCost = 0;

		Set<Integer> visitedSet = new HashSet<Integer>();

		Edge minEdge = minEdge();

		visitedSet.add(minEdge.from);
		visitedSet.add(minEdge.to);

		list.add(new int[] { minEdge.from, minEdge.to });
		totalCost += minEdge.weight;

		while (true) {
			minEdge = null;
			for (Integer v : visitedSet) {
				for (Edge edge : graph.getListOfEdges()[v]) {
					if (!visitedSet.contains(edge.to)) {
						if (minEdge == null || minEdge.weight > edge.weight) {
							minEdge = edge;
						}
					}
				}
			}
			if (minEdge == null) {
				break;
			}
			visitedSet.add(minEdge.to);
			list.add(new int[] { minEdge.from, minEdge.to });
			totalCost += minEdge.weight;

		}

		this.totalCost = totalCost;

	}

	private Edge minEdge() {

		Edge minEdge = null;
		for (Edge[] edges : graph.getListOfEdges()) {
			for (Edge edge : edges) {
				if (minEdge == null || minEdge.weight > edge.weight) {
					minEdge = edge;
				}
			}
		}
		return minEdge;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Prim's MST\n");
		sb.append("List: ");
		for (int[] edge : list) {
			sb.append(Arrays.toString(edge));
			sb.append(" ");
		}
		sb.append("\n");
		sb.append("Total Cost: ");
		sb.append(totalCost);
		sb.append("\n");
		return sb.toString();
	}

}
