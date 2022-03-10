import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
public class Network {

	private List<Node> nodes = new ArrayList<>();

	public List<Node> getNodes() {
		return nodes;
	}
	
	public void addNode(Node node) {
		 nodes.add(node);
	}

	@Override
	public String toString() {
		Collections.sort(nodes);
		String output = "";
		for(Node node : nodes)
		{
			if(node instanceof Computer)
				output = output + "Computer " + node.getName() + "\n";
			else if(node instanceof Router)
			{
				output = output + "Router " + node.getName() + "\n";
			}
			else if(node instanceof Switch)
			{
				output = output + "Switch " + node.getName() + "\n";
			}
		}
		return output;
	}
	

	
}
