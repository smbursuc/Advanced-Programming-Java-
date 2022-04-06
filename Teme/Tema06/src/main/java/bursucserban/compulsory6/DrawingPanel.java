package bursucserban.compulsory6;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;

public class DrawingPanel
{

	private int x = 0, y = 0; // actual x and y
	private int map[][];
	private GridPane grid;
	private List<NodeInfo> adjacency;

	public GridPane getGrid()
	{
		return grid;
	}

	public DrawingPanel(int x, int y)
	{
		this.x = x;
		this.y = y;
		map = new int[2 * x][2 * y];
		adjacency = new ArrayList<>();
	}

	private void createRoad()
	{
		Random random = new Random();
		int randI = 0;// random.nextInt(2*x);
		int randJ = 0;// random.nextInt(2*y);

		for (int i = 0; i < 2 * x - 1; i++)
		{
			for (int j = 0; j < 2 * y - 1; j++)
			{
				if (i % 2 == 0 && j % 2 == 0)
				{
					map[i][j] = 0;
				}
				else if (i % 2 == 0 && j % 2 == 1 || i % 2 == 1 && j % 2 == 0)
				{
					map[i][j] = 2;
				}
				else
					map[i][j] = 3;

				// 2=loc liber pt muchie
				// 1=muchie ocupata
				// 0=nod
				// 3=interzis
			}
		}

		while (map[randI][randJ] != 2)
		{
			randI = random.nextInt(2 * x - 1);
			randJ = random.nextInt(2 * y - 1);
		}

		map[randI][randJ] = 1;

		int steps = random.nextInt(x * (x - 1) + y * (y - 1));

		int values[] = new int[3];
		values[0] = 0;
		values[1] = 1;
		values[2] = -1;

		int i = randI, j = randJ;
		int startI = i;
		int startJ = j;

		int control = 0;
		int stepsDone = 0;
		while (stepsDone < steps)
		{
			do
			{
				i = startI;
				j = startJ;
				j = j + values[random.nextInt(values.length)];
				i = i + values[random.nextInt(values.length)];
			}
			while (!(i >= 0 && i < 2 * x - 1 && j >= 0 && j < 2 * y - 1));

			if (map[i][j] == 2)
			{
				map[i][j] = 1;
				startI = i;
				startJ = j;
				control = 0;
				stepsDone++;
			}

			control++;
			if (control == 500)
			{
				System.out.println("Failed too many times! (Probably got stuck)");
				System.out.println("Only drew " + stepsDone + " out of " + steps + " lines");
				break;
			}

		}

	}


	public GridPane create()
	{
		GridPane grid = new GridPane();

		grid.setPadding(new Insets(50));

		createRoad();
		for (int i = 0; i < 2 * y - 1; i++) // column index
		{
			for (int j = 0; j < 2 * x - 1; j++) // row index
			{
				Circle circle = new Circle(20, 20, 20);
				if (j % 2 == 0)
				{
					if (i % 2 == 0)
					{
						circle.setFill(Color.BLACK);
						circle.setStyle("-fx-stroke: red; -fx-fill: transparent;");
						grid.add(circle, i, j);
					}
					else if (i % 2 == 1)
					{
						Line line = new Line(100, 200, 150, 200);
						line.setFill(Color.BLACK);
						if (map[j][i] == 1)
						{
							line.setStyle("-fx-stroke-width: 5;");
							line.setUserData("horizontal");
						}
						else
							line.setStyle("-fx-stroke-width: 1;");
						grid.add(line, i, j);
					}
				}
				else
				{
					if (i % 2 == 0)
					{
						Line line = new Line(0, 0, 0, 50);
						GridPane.setMargin(line, new Insets(0, 15, 0, 18));
						line.setFill(Color.BLACK);
						if (map[j][i] == 1)
						{
							line.setStyle("-fx-stroke-width: 5;");
							line.setUserData("vertical");
						}
						else
							line.setStyle("-fx-stroke-width: 1;");
						grid.add(line, i, j);
					}
				}
			}
		}
		
		
		for (int i = 0; i < 2 * y - 1; i++) // column index
		{
			for (int j = 0; j < 2 * x - 1; j++) // row index
			{
				if(map[j][i]==1)
				{
					for(Node node : grid.getChildren())
					{
						if(grid.getRowIndex(node)==j && grid.getColumnIndex(node)==i)
						{
							if(String.valueOf(node.getUserData())=="vertical")
							{
								for(Node n : grid.getChildren())
								{
									if(grid.getRowIndex(n)==j-1 && grid.getColumnIndex(n)==i)
									{
										n.setUserData("road");
										NodeInfo nodeInfo = new NodeInfo(n,i,j-1);
										nodeInfo.getAdjacentNodes().add(node);
										adjacency.add(nodeInfo);
										
									}
									else if(grid.getRowIndex(n)==j+1 && grid.getColumnIndex(n)==i)
									{
										n.setUserData("road");
										NodeInfo nodeInfo = new NodeInfo(n,i,j+1);
										nodeInfo.getAdjacentNodes().add(node);
										adjacency.add(nodeInfo);
									}
								}
							}
							else
							{
								for(Node n : grid.getChildren())
								{
									if(grid.getRowIndex(n)==j && grid.getColumnIndex(n)==i-1)
									{
										n.setUserData("road");
										NodeInfo nodeInfo = new NodeInfo(n,i-1,j);
										nodeInfo.getAdjacentNodes().add(node);
										adjacency.add(nodeInfo);
									}
									else if(grid.getRowIndex(n)==j && grid.getColumnIndex(n)==i+1)
									{
										n.setUserData("road");
										NodeInfo nodeInfo = new NodeInfo(n,i+1,j);
										nodeInfo.getAdjacentNodes().add(node);
										adjacency.add(nodeInfo);
									}
								}
							}
						}
					}
				}
			}
		}
			
		this.grid = grid;
		return grid;
	}
	
	public Node getNodeByIJ(int i, int j)
	{
		for(Node node : grid.getChildren())
		{
			if(grid.getRowIndex(node)==j && grid.getColumnIndex(node)==i)
			{
				return node;
			}
		}
		return null;
	}

	public List<NodeInfo> getAdjacency()
	{
		return adjacency;
	}

}
