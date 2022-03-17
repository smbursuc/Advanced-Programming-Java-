
public class Computer extends Node implements Identifiable, Storage {

	private String address;
	private int storageCapacity;
	
	public Computer(String name, String address)
	{
		super(name);
		this.address=address;
	}

	@Override
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public int getStorageCapacity() {
		return storageCapacity;
	}

}
