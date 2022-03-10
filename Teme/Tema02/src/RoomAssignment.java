import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
public class RoomAssignment {

	ArrayList<Event> events;
	ArrayList<Room> rooms;
	
	public RoomAssignment()
	{
		rooms = new ArrayList<>();
		events = new ArrayList<>();
	}
	
	public void add(Object obj)
	{
		if(obj instanceof Event && !contine(obj))
		{
			events.add((Event)obj);
		}
		else if(obj instanceof Room && !contine(obj))
		{
			rooms.add((Room)obj);
		}
		else if(contine(obj))
			System.out.println("Exista deja obiectul");
		else System.out.println("Tip de data gresit (nu merge " + obj.getClass() + " aici).");
	}
	
	@Override
	public String toString() {
		String raspuns = "Events:" + '\n';
		for(Event e : events)
		{
			raspuns = raspuns + e.toString() + '\n';
		}
		raspuns = raspuns + "Rooms:" + '\n';
		for(Room r : rooms)
		{
			raspuns = raspuns + r.toString() + '\n';
		}
		return raspuns;
	}
	
	/*
	 * Functie folosita pentru a previne adaugarea a unui eveniment/unei camere deja existente in problema.
	 * */
	public boolean contine(Object obj)
	{
		if(obj instanceof Event)
		{
			for(Event e : events)
			{
				if(e.equals(obj))
				{
					return true;
				}
			}
		}
		else
			if(obj instanceof Room)
			{
				for(Room r : rooms)
				{
					if(r.equals(obj))
					{
						return true;
					}
				}
			}
		return false;
	}
	
	public ArrayList<Event> getEvents()
	{
		return events;
	}
	
	public ArrayList<Room> getRooms()
	{
		return rooms;
	}
}
