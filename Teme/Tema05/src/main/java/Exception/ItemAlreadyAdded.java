package Exception;

public class ItemAlreadyAdded extends Exception{
	
	public ItemAlreadyAdded(String message)
	{
		super("Cannot add same item twice!");
	}

}
