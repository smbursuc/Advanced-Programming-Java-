
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Node v1 = new Computer("A","B5DF");
		Node v2 = new Router("B","5ZMN3");
		Node v3 = new Switch("A");
		Node v4 = new Switch("B");
		Node v5 = new Router("B","098PLN");
		Node v6 = new Computer("B","ZTDG");
		
		Network n1 = new Network();
		
		n1.addNode(v1);
		n1.addNode(v2);
		n1.addNode(v3);
		n1.addNode(v4);
		n1.addNode(v5);
		n1.addNode(v6);
		
		v1.setCost(v2, 10);
		v1.setCost(v3, 50);
		v2.setCost(v3, 20);
		v2.setCost(v4, 20);
		v2.setCost(v5, 20);
		v3.setCost(v4, 10);
		v4.setCost(v5, 30);
		v4.setCost(v6, 10);
		v5.setCost(v6, 20);
		
		
		n1.displayIdentifiables();
		System.out.println();
		
		for(Node node : n1.getNodes())
			if(node instanceof Identifiable)
			n1.showShortestPath(node);
		
		
		
		
	}

}
