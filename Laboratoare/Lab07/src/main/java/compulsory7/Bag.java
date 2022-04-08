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
		tileNumber = 10;

		for (int i = 97; i <= 122; i++)
		{
			for(int j=0;j<tileNumber;j++)
			{
				tiles.add(new Tile((char) i,1+random.nextInt(10)));
			}
		}
	}

	public synchronized List<Tile> extractTiles(int howMany)
	{
		List<Tile> extracted = new ArrayList<>();
		Random random = new Random();
		for (int i = 0; i < howMany; i++) 
		{
			int tilePosition = random.nextInt(tiles.size()-1);
			extracted.add(tiles.get(tilePosition));
		}
		return extracted;
	}

}
