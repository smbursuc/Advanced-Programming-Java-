import java.util.Objects;

public abstract class Room {
	
	protected String name;
	protected int capacity;
	
	public Room(String name, int capacity) {
		super();
		this.name = name;
		this.capacity = capacity;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}


	@Override
	public String toString() {
		return "Room [name=" + name + ", capacity=" + capacity + ", room_type=" + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Room other = (Room) obj;
		return capacity == other.capacity && Objects.equals(name, other.name);
	}
	
	
	
	
	
	
	
	
	
	
}
