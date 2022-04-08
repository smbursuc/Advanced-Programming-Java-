package compulsory7;

public class Tile {
	
	private char letter;
	private int points;
	
	public Tile(char letter, int points) {
		super();
		this.letter = letter;
		this.points = points;
	}
	
	public char getLetter() {
		return letter;
	}
	public void setLetter(char letter) {
		this.letter = letter;
	}
	public int getPoints() {
		return points;
	}
	public void setPoints(int points) {
		this.points = points;
	}
	
	


}
