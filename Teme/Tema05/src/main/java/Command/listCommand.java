package Command;

import tema5.Catalog;
import tema5.Item;

public class listCommand implements Command{
	
	private Catalog catalog;
	
	public listCommand(Catalog catalog)
	{
		this.catalog=catalog;
	}

	public void execute()
	{
		System.out.println("Catalog " + catalog.getName());
		int index = 1;
		for(Item item : catalog.getItems())
		{
			System.out.println(String.valueOf(index)+ ". " + String.valueOf(item.getClass()).split(" ")[1].split("\\.")[1]);
			index++;
		}
	}
}
