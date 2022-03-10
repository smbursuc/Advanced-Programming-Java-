
public class Computer extends Node implements Identifiable, Storage {

	private String address;
	private int storageCapacity;
	
	public Computer(String name)
	{
		super(name);
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
