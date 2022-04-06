package bursucserban.compulsory6;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.Node;

public class NodeInfo
{

	private Node node;
	private int i, j;
	private List<Node> adjacentNodes = new ArrayList<>();
	
	public NodeInfo(Node node,int i, int j)
	{
		this.node=node;
		this.i=i;
		this.j=j;
	}
	
	public void addAdjacentNode(Node node)
	{
		adjacentNodes.add(node);
	}
	
	public List<Node> getAdjacentNodes()
	{
		return adjacentNodes;
	}
	
	public Node getNode()
	{
		return node;
	}

	public int getI()
	{
		return i;
	}

	public void setI(int i)
	{
		this.i = i;
	}

	public int getJ()
	{
		return j;
	}

	public void setJ(int j)
	{
		this.j = j;
	}
	
	
	
	
	
}
