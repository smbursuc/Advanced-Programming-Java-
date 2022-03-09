
public class ComputerLab extends Room{

	private OperatingSystem os;
	
	public ComputerLab(String name, int capacity, OperatingSystem os)
	{
		super(name,capacity);
		this.os=os;
	}

	public OperatingSystem getOs() {
		return os;
	}

	public void setOs(OperatingSystem os) {
		this.os = os;
	}
	
	
}
