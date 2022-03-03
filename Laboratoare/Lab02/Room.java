
public class Room {
	
	private String name;
	private int capacity;
	private RoomType room_type;
	
	public Room(String name, int capacity, RoomType room_type) {
		super();
		this.name = name;
		this.capacity = capacity;
		this.room_type = room_type;
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
	public RoomType getRoom_type() {
		return room_type;
	}
	public void setRoom_type(RoomType room_type) {
		this.room_type = room_type;
	}
	
	@Override
	public String toString() {
		return "Room [name=" + name + ", capacity=" + capacity + ", room_type=" + room_type + "]";
	}
	
	
	
	
	
	
	
	
}
