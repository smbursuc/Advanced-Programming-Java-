package Command;

import Exception.ItemAlreadyAdded;
import tema5.Catalog;
import tema5.Item;

public class addCommand extends Command{

	public void addToCatalog(Catalog catalog, Item item) throws ItemAlreadyAdded
	{
		if(catalog.findById(item)==null)
			catalog.getItems().add(item);
		else throw new ItemAlreadyAdded("Cannot add the same item twice!");
	}
	
	
	
}
