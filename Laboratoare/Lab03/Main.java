
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Node v1 = new Computer("A");
		Node v2 = new Router("B");
		Node v3 = new Switch("A");
		Node v4 = new Switch("B");
		Node v5 = new Router("B");
		Node v6 = new Computer("B");
		
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
		v2.setCost(v5, 10);
		v3.setCost(v4, 20);
		v4.setCost(v5, 30);
		v4.setCost(v6, 10);
		v5.setCost(v6, 20);
		
		System.out.println(n1);
		
		
		
	}

}
