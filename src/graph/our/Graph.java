package graph.our;

public class Graph {

	private int numberOfVertex;

	private Edge[][] listOfEdges;

	public Graph(int numberOfVertex, Edge[][] listOfEdges) {

		this.numberOfVertex = numberOfVertex;
		this.listOfEdges = listOfEdges;

	}

	public int getNumberOfVertex() {
		return numberOfVertex;
	}

	public Edge[][] getListOfEdges() {
		return listOfEdges;
	}

}

class Edge {

	int from;
	int to;
	int weight;

	public Edge(int from, int to, int weight) {

		this.from = from;
		this.to = to;
		this.weight = weight;
	}

}