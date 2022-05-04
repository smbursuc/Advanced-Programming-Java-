package Places;

public class Continent extends Place{

	public Continent(int id, String name)
	{
		super(id,name);
	}
	
	public String toString()
	{
		return "ID: " + id + " Name: " + name;
	}
}
