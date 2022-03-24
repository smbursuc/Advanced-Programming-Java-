package compulsory5;
import java.util.List;
import java.util.ArrayList;

public class Catalog {
	
	private String name;
	private List<Item> items = new ArrayList<>();
	
	public Catalog()
	{
		
	}
	public Catalog(String name)
	{
		this.name=name;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void add(Item item) {
		 items.add(item);
	}
	
	public Item findByID(String id)
	{
		for(Item item : items)
		{
			if(item.getId().equals(id))
			{
				return item;
			}
		}
		return null;
	}
	
	public String toString()
	{
		String tostring = "";
		for(int i=0;i<items.size();i++)
		{
			int index=1+i;
			tostring = tostring + index + ".\n";
			tostring = tostring + "ID: " + items.get(i).getId() + "\n";
			tostring = tostring + "Location: " + items.get(i).getLocation() + "\n";
			tostring = tostring + "Title: " + items.get(i).getTitle() + "\n";
		}
		return tostring;
	}
	
	public List<Item> getItems()
	{
		return items;
	}


}
