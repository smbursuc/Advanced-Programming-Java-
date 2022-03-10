
public class Switch extends Node implements Identifiable{

	private String address;
	
	public Switch(String adress)
	{
		super(adress);
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String adress) {
		this.address = adress;
	}
}
