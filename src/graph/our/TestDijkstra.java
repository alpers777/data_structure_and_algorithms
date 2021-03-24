package graph.our;

public class TestDijkstra {

	public static void main(String[] args) {
		Edge[][] edges = { { new Edge(0, 1, 6), new Edge(0, 5, 5) },
				{ new Edge(1, 0, 6), new Edge(1, 2, 10), new Edge(1, 5, 8), new Edge(1, 6, 7) },
				{ new Edge(2, 1, 10), new Edge(2, 3, 8), new Edge(2, 4, 10), new Edge(2, 6, 5) },
				{ new Edge(3, 2, 8), new Edge(3, 4, 8) },
				{ new Edge(4, 2, 10), new Edge(4, 3, 8), new Edge(4, 5, 12), new Edge(4, 6, 7) },
				{ new Edge(5, 0, 5), new Edge(5, 1, 8), new Edge(5, 4, 12), new Edge(5, 6, 7) },
				{ new Edge(6, 1, 7), new Edge(6, 2, 5), new Edge(6, 4, 7), new Edge(6, 5, 7) } };

		Graph graph = new Graph(7, edges);
		DijkstraShortestPath dij = new DijkstraShortestPath(graph);
		dij.dijkstra(1);
		System.out.println(dij);
		System.out.println(dij.shortestPathTo(4));
	}

}
