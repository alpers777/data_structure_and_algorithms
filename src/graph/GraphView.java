package graph;

import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;

public class GraphView extends Pane {
	private Graph<? extends Displayable> graph;
	
	private final String NOT_SELECTED = "Not selected";
	
	private Text source;
	private int sourceIndex;
	
	private Text destination;
	

	public GraphView(Graph<? extends Displayable> graph) throws Exception {
		this.graph = graph;
		
		this.source = new Text(200, 20, NOT_SELECTED);
		getChildren().add(this.source);
		this.destination = new Text(300, 20, NOT_SELECTED);
		getChildren().add(this.destination);
		
		Button clearButton = new Button("Clear");
		clearButton.setLayoutX(500);
		clearButton.setLayoutY(20);
		clearButton.setOnMouseClicked(e -> {
			this.source.setText(NOT_SELECTED);
			this.destination.setText(NOT_SELECTED);
		});
		getChildren().add(clearButton);
		
				
		

		// Draw vertices
		java.util.List<? extends Displayable> vertices = graph.getVertices();
		for (int i = 0; i < graph.getSize(); i++) {
			int x = vertices.get(i).getX();
			int y = vertices.get(i).getY();
			String name = vertices.get(i).getName();
			Circle c = new Circle(x, y, 8);
			final int finalI = i;
			
			c.setOnMouseClicked(e -> {
				if (this.source.getText().equals(NOT_SELECTED)) {
					this.source.setText(name + " (" + finalI + ")");
					this.sourceIndex = finalI;
				} else {
					this.destination.setText(name + " (" + finalI + ")");
					
					int[] path = graph.myBfs(sourceIndex);
					int index = finalI;
					
					while(path[index] != index) {
						int v = path[index];
						
						int x1 = graph.getVertex(index).getX();
						int y1 = graph.getVertex(index).getY();
						
						int x2 = graph.getVertex(v).getX();
						int y2 = graph.getVertex(v).getY();
						
						
						Line line = new Line(x1, y1, x2, y2);
						line.setStroke(Color.RED);
						getChildren().add(line);
						
						index = v;
					}
					
				}
			});
			
			getChildren().add(c); // Display a vertex
			getChildren().add(new Text(x - 8, y - 18, name + " (" + i + ")"));
		}

		// Draw edges for pairs of vertices
		for (int i = 0; i < graph.getSize(); i++) {
			java.util.List<Integer> neighbors = graph.getNeighbors(i);
			int x1 = graph.getVertex(i).getX();
			int y1 = graph.getVertex(i).getY();
			for (int v : neighbors) {
				double weigth = ((WeightedGraph) graph).getWeight(i, v);

				int x2 = graph.getVertex(v).getX();
				int y2 = graph.getVertex(v).getY();

				// Draw an edge for (i, v)
				getChildren().add(new Line(x1, y1, x2, y2));

				getChildren().add(new Text((x1 + x2) / 2, (y1 + y2) / 2, (int) weigth + ""));
			}
		}
	}
}
