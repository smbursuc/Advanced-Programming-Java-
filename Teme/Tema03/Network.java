import java.util.List;
import java.util.Comparator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Network {

	private List<Node> nodes = new ArrayList<>();

	public List<Node> getNodes() {
		return nodes;
	}

	public void addNode(Node node) {

		for (Node node_ : nodes) {
			if (node_ instanceof Identifiable && node instanceof Identifiable) {
				Identifiable n1 = (Identifiable) node_;
				Identifiable n2 = (Identifiable) node;
				if (n1.getAddress() == n2.getAddress()) {
					System.out.println("Nu se pot adauga 2 noduri identice in acelasi network.");
					System.exit(-1);
				}
			}
		}

		nodes.add(node);
	}

	@Override
	public String toString() {
		Collections.sort(nodes);
		String output = "";
		for (Node node : nodes) {
			String className_1 = String.valueOf(node.getClass());
			String[] splitString_1 = className_1.split(" ");
			className_1 = splitString_1[1];

			for (Node node_ : node.getCost().keySet()) {
				String className_2 = String.valueOf(node_.getClass());
				String[] splitString_2 = className_2.split(" ");
				className_2 = splitString_2[1];
				System.out.println(className_1 + " " + node.getName() + " - " + className_2 + " " + node_.getName()
						+ " " + node.getCost().get(node_));
			}
		}
		return output;
	}

	public void displayIdentifiables() {
		List<Node> identifiableNodes = new ArrayList<>();

		for (Node node : nodes) {
			if (node instanceof Identifiable) {
				identifiableNodes.add(node);
			}
		}

		Collections.sort(identifiableNodes, new Comparator<Node>() {
			public int compare(Node n1, Node n2) {
				Identifiable i1 = (Identifiable) n1;
				Identifiable i2 = (Identifiable) n2;
				return i1.getAddress().compareTo(i2.getAddress());

			}
		});

		System.out.println("Identifiables:");
		for (Node node : identifiableNodes) {
			String className_1 = String.valueOf(node.getClass());
			String[] splitString_1 = className_1.split(" ");
			className_1 = splitString_1[1];
			System.out.println(className_1 + " " + node.getName());
		}
	}

	public void showShortestPath(Node source) {

		if (!(source instanceof Identifiable)) {
			System.out.println("Sursa nu este identificabila!");
			System.exit(-1);
		}

		List<Node> identifiableNodes = new ArrayList<>();

		for (Node node : nodes) {
			if (node instanceof Identifiable) {
				identifiableNodes.add(node);
			}
		}

		HashMap<Node, Integer> distance = new HashMap<>();
		Stack<Node> nodeStack = new Stack<>();

		for (Node node : identifiableNodes) {
			distance.put(node, 9999);
			nodeStack.add(node);
		}

		distance.put(source, 0);

		List<Pair<Node, Node>> adjacency = new ArrayList<>();

		for (Node node : nodes) {
			for (Node neighbour : node.getAdjacency()) {
				Pair<Node, Node> dummyPairFirst = new Pair(node, neighbour);
				Pair<Node, Node> dummyPairSecond = new Pair(neighbour, node);
				adjacency.add(dummyPairFirst);
				adjacency.add(dummyPairSecond);
			}
		}
		Node minNode = null;
		while (nodeStack.size() > 0) {
			int minimum = 9999;
			for (Node node : nodeStack) {
				if (distance.get(node) < minimum) {
						minNode = node;
					}
				}
			
			nodeStack.remove(minNode);

			for (Pair<Node, Node> pair : adjacency) {
				Node neighbour = null;
				boolean found = false;
				if (pair.getKey() == minNode) {
					neighbour = pair.getValue();
					found = true;
				} else if (pair.getValue() == minNode) {
					neighbour = pair.getKey();
					found = true;
				}

				if (found)
				{
					if (neighbour instanceof Identifiable && nodeStack.contains(neighbour)) {
						
						Identifiable i1 = (Identifiable) neighbour;
						int x = distance.get(minNode) + neighbour.getCost().get(minNode);
						if (x < distance.get(neighbour)) {
							distance.put(neighbour, x);
						}
					}
				}
			}
		}

		Identifiable iii = (Identifiable)source;
		System.out.println("From: " + source.getClass() + " " + source.getName() + " " + iii.getAddress());
		for (Node node : distance.keySet()) {
			System.out.print(node.getClass() + " " + node.getName() + " " + distance.get(node) + " ");
			Identifiable i = (Identifiable) node;
			System.out.print(i.getAddress() + "\n");
		}
		System.out.println("");
	}

}
