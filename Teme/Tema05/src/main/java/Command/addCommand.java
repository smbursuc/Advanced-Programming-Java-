package Command;

import Exception.ItemAlreadyAdded;
import tema5.Catalog;
import tema5.Item;

public class addCommand implements Command{

	private Catalog catalog;
	private Item item;
	
	public addCommand(Catalog catalog, Item item)
	{
		this.catalog=catalog;
		this.item=item;
	}
	
	public void execute() throws ItemAlreadyAdded
	{
		if(catalog.findById(item)==null)
			catalog.getItems().add(item);
		else throw new ItemAlreadyAdded("Cannot add the same item twice!");
	}
	
	
	
}
