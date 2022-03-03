
public class Event {

	private int start;
	private int finish;
	private String name;
	private int size;
	
	public Event(int start, int finish, int size, String name) {
		super();
		this.start = start;
		this.finish = finish;
		this.name = name;
		this.size = size;
	}
	
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getFinish() {
		return finish;
	}
	public void setFinish(int finish) {
		this.finish = finish;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	
	@Override
	public String toString() {
		return "Event [start=" + start + ", finish=" + finish + ", name=" + name + ", size=" + size + "]";
	}
	
	
	
	
}
