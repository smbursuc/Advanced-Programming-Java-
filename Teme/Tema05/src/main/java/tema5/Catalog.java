package tema5;
import java.util.List;
import java.util.ArrayList;


public class Catalog {
	
	private List<Item> items = new ArrayList<>();
	private String name;
	
	public Catalog()
	{
		
	}
	
	public Catalog(String name)
	{
		this.name=name;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String toString()
	{
		System.out.println("Catalog " + name);
		String tostring = "";
		for(int i=0;i<items.size();i++)
		{
			int index=1+i;
			tostring = tostring + index + ".\n";
			tostring = tostring + "ID: " + items.get(i).getIdentifier() + "\n";
			tostring = tostring + "Location: " + items.get(i).getLocation() + "\n";
			tostring = tostring + "Title: " + items.get(i).getTitle() + "\n";
		}
		return tostring;
	}
	
	public Item findById(Item item)
	{
		for(Item i_tem : items)
		{
			if(i_tem.getIdentifier().equals(item.getIdentifier()))
			{
				return i_tem;
			}
		}
		return null;
	}
	

}
