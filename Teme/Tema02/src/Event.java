import java.util.Objects;

public class Event {

	private int start;
	private int end;
	private String name;
	private int size;
	
	public Event(int size, int start, int end, String name) {
		super();
		this.start = start;
		this.end = end;
		this.name = name;
		this.size = size;
	}
	
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getEnd() {
		return end;
	}
	public void setEnd(int end) {
		this.end = end;
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
		return "Event [start=" + start + ", end=" + end + ", name=" + name + ", size=" + size + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Event other = (Event) obj;
		return end == other.end && Objects.equals(name, other.name) && size == other.size && start == other.start;
	}

	
	
	
	
	
	
	
	
	
	
}
