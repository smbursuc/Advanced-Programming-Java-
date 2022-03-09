
public class LectureHall extends Room {

	private boolean isProjector;

	public LectureHall(String name, int capacity, boolean isProjector)
	{
		super(name,capacity);
		this.isProjector = isProjector;
	}
	
	public boolean getIsProjector() {
		return isProjector;
	}
	
	public void setProjector(boolean isProjector) {
		this.isProjector = isProjector;
	}
	
	
}
