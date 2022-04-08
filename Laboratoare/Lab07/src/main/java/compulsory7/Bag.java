package compulsory7;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Bag
{

	// private final declare a collection for tiles;
	private final List<Tile> tiles;
	private final int tileNumber;

	public Bag()
	{
		// 97-122 a-z
		Random random = new Random();
		tiles = new ArrayList<>();
		tileNumber = 20 + random.nextInt(50);

		for (int i = 0; i < tileNumber; i++)
		{
			int asciiCode = 97 + random.nextInt(25);
			int points = 1 + random.nextInt(20);
			tiles.add(new Tile((char) asciiCode, points));
		}
	}

	public synchronized List<Tile> extractTiles(int howMany)
	{
		List<Tile> extracted = new ArrayList<>();
		Random random = new Random();
		for (int i = 0; i < howMany; i++) 
		{
			int tilePosition = random.nextInt(tileNumber);
			extracted.add(tiles.get(tilePosition));
		}
		return extracted;
	}

}
