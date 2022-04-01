package bursucserban.compulsory6;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;

public class DrawingPanel {
	
	private int x=0, y=0; //actual x and y
	
	public DrawingPanel(int x, int y)
	{
		this.x=x;
		this.y=y;
		
	}
	
	public GridPane create()
	{
		GridPane grid = new GridPane();
		
		grid.setPadding(new Insets(50));
		
		for(int i=0;i<x;i++)
		{
			for(int j=0;j<y;j++)
			{
				Circle circle = new Circle(20,20,20);
				circle.setFill(Color.BLACK);
				circle.setStyle("-fx-stroke: red; -fx-fill: transparent;");
				grid.add(circle, i, j);
				GridPane.setMargin(circle, new Insets(10,10,10,10));
			}
		}
		
		return grid;
	}


}
