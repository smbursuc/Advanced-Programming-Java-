
public class Router extends Node implements Identifiable{

	private String address;
	
	public Router(String name, String address)
	{
		super(name);
		this.address=address;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String adress) {
		this.address = adress;
	}
	
	
}
