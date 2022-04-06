package bursucserban.compulsory6;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.text.Text;

public class GameLogic
{

	private int turn = -1; // -1 = red(first), 1 = blue(second)
	private DrawingPanel drawingPanel;
	private VBox vbox;
	private Text playerTurn;
	private int usedNodes = 0;
	private int totalNodes = 0;
	private ImageView imageView = new ImageView();
	private List<NodeInfo> adjacency = new ArrayList<>();
	private Node lastMove;
	private String nextMoveStyle;

	public GameLogic(DrawingPanel drawingPanel)
	{
		this.drawingPanel = drawingPanel;
	}

	public void setDP(DrawingPanel drawingPanel)
	{
		this.drawingPanel = drawingPanel;
	}

	public int getTurn()
	{
		return turn;
	}

	public void changeTurn()
	{
		turn = turn * -1;
	}

	public VBox create()
	{
		vbox = new VBox();

		playerTurn = new Text();
		Circle player = new Circle(20, 20, 20);

		playerTurn.setText("Turn: player 1 (red)");
		player.setStyle("-fx-fill: red;");
		VBox.setMargin(player, new Insets(10, 0, 0, 25));
		VBox.setMargin(playerTurn, new Insets(0, 10, 0, 0));

		vbox.getChildren().add(playerTurn);

		vbox.getChildren().add(player);

		totalNodes = drawingPanel.getGrid().getChildren()
				.filtered(child -> String.valueOf(child.getUserData()) == "road").size();

		Image i = new Image(new File("winGif/styleOnThemHaters.gif").toURI().toString());
		imageView.setImage(i);
		imageView.setFitHeight(300);
		imageView.setFitWidth(300);

		
		drawingPanel.getGrid().getChildren().filtered(child -> String.valueOf(child.getUserData()) == "road")
				.forEach(circle -> circle.setOnMouseClicked(new EventHandler<MouseEvent>()
				{
					public void handle(MouseEvent event)
					{
						if (String.valueOf(circle.getUserData()) == "road")
						{

							if (lastMove == null)
							{
								circle.setStyle("-fx-fill: red;");
								getText().setText("Turn: player 2 (blue)");
								player.setStyle("-fx-fill: blue;");
								changeTurn();
								circle.setUserData("road.used");
								usedNodes++;
								lastMove = circle;
								nextMoveStyle = player.getStyle();
								return;
							}

							if (isAdjacentAndDifferent(circle, lastMove))
							{

								if (getTurn() == -1)
								{
									circle.setStyle("-fx-fill: red;");
									getText().setText("Turn: player 2 (blue)");
									player.setStyle("-fx-fill: blue;");
									nextMoveStyle = player.getStyle();
								}
								else
								{
									circle.setStyle("-fx-fill: blue;");
									getText().setText("Turn: player 1 (red)");
									player.setStyle("-fx-fill: red;");
									nextMoveStyle = player.getStyle();
								}
								changeTurn();
								circle.setUserData("road.used");
								lastMove = circle;
							}

							if (!existsSolution(lastMove))
							{

								if (turn == -1)
								{
									getText().setText("Player 2 (blue) won!");
									player.setStyle("-fx-fill: blue;");
								}
								else
								{
									getText().setText("Player 1 (red) won!");
									player.setStyle("-fx-fill: red;");
								}
								vbox.getChildren().add(imageView);
							}
						}
					}
				}));

		return vbox;
	}

	public VBox getVBox()
	{
		return vbox;
	}

	public Text getText()
	{
		return playerTurn;
	}

	public boolean isAdjacentAndDifferent(Node n1, Node n2)
	{
		int searchI = 0, searchJ = 0;
		for (NodeInfo nodeInfo : drawingPanel.getAdjacency())
		{
			if (nodeInfo.getNode().equals(n2))
			{
				searchI = nodeInfo.getI();
				searchJ = nodeInfo.getJ();
				break;
			}
		}

		for (NodeInfo nodeInfo : drawingPanel.getAdjacency())
		{
			if (nodeInfo.getI() == searchI || nodeInfo.getJ() == searchJ)
			{
				if (nodeInfo.getNode().equals(n1))
				{
					if (nodeInfo.getNode().getStyle() != nextMoveStyle && commonEdge(n1, n2))
					{
						return true;
					}
				}
			}
		}
		return false;
	}

	public boolean commonEdge(Node n1, Node n2)
	{
		for (NodeInfo nodeInfo1 : drawingPanel.getAdjacency())
		{
			if (nodeInfo1.getNode().equals(n1))
			{
				for (NodeInfo nodeInfo2 : drawingPanel.getAdjacency())
				{
					if (nodeInfo2.getNode().equals(n2))
					{
						int find1 = 1;
						int find2 = 1;

						int start1 = nodeInfo2.getI() <= nodeInfo1.getI() ? nodeInfo2.getI() : nodeInfo1.getI();
						int finish1 = nodeInfo2.getI() >= nodeInfo1.getI() ? nodeInfo2.getI() : nodeInfo1.getI();
						//System.out.println("1st for: " + start + " " + finish);
						for (int x = start1; x <= finish1; x++)
						{
							//System.out.println(String.valueOf(drawingPanel.getNodeByIJ(x,
							//nodeInfo2.getJ()).getUserData()));
							if (drawingPanel.getNodeByIJ(x, nodeInfo2.getJ()).getUserData() == null)
							{
								find1 = 0;
							}
						}

						int start2 = nodeInfo2.getJ() <= nodeInfo1.getJ() ? nodeInfo2.getJ() : nodeInfo1.getJ();
						int finish2 = nodeInfo2.getJ() >= nodeInfo1.getJ() ? nodeInfo2.getJ() : nodeInfo1.getJ();
						//System.out.println("2nd for: " + start + " " + finish);
						for (int y = start2; y <= finish2; y++)
						{
							if (drawingPanel.getNodeByIJ(nodeInfo2.getI(), y).getUserData() == null)
							{
								find2 = 0;
							}
						}

						if ((find1 == 1 && start1!=finish1) || (find2 == 1 && start2!=finish2))
							return true;
					}
				}
			}
		}
		return false;
	}

	public boolean existsSolution(Node lastMove)
	{
		int searchI = 0, searchJ = 0;

		for (NodeInfo nodeInfo : drawingPanel.getAdjacency())
		{
			if (nodeInfo.getNode().equals(lastMove))
			{
				searchI = nodeInfo.getI();
				searchJ = nodeInfo.getJ();
				break;
			}
		}

		for (NodeInfo nodeInfo : drawingPanel.getAdjacency())
		{
			if (nodeInfo.getI() == searchI || nodeInfo.getJ() == searchJ)
			{
				if (nodeInfo.getNode().getStyle() != nextMoveStyle && commonEdge(nodeInfo.getNode(), lastMove) 
						&& String.valueOf(nodeInfo.getNode().getUserData())=="road")
				{
					return true;
				}
			}
		}
		return false;
	}

}
