package tema7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

public class Bag
{

	// private final declare a collection for tiles;
	private final List<Tile> tiles;
	private final int tileNumber = 0;
	private Map<String, Integer> tilePoints = new HashMap<>();
	
	public void add(char letter, int number, int points)
	{
		for (int i = 0; i < number; i++)
		{
			tiles.add(new Tile(letter, points));
		}
		tilePoints.put(String.valueOf(letter), points);
	}

	public Bag()
	{

		tiles = new CopyOnWriteArrayList<Tile>();
		add('a', 9, 1);
		add('b', 2, 3);
		add('c', 2, 3);
		add('d', 4, 2);
		add('e', 12, 1);
		add('f', 2, 4);
		add('g', 3, 2);
		add('h', 2, 4);
		add('i', 9, 1);
		add('j', 1, 8);
		add('k', 1, 5);
		add('l', 4, 1);
		add('m', 2, 3);
		add('n', 6, 1);
		add('o', 8, 1);
		add('p', 2, 3);
		add('q', 1, 10);
		add('r', 6, 1);
		add('s', 4, 1);
		add('t', 6, 1);
		add('u', 4, 1);
		add('v', 2, 4);
		add('w', 2, 4);
		add('x', 1, 8);
		add('y', 2, 4);
		add('z', 1, 10);
	}

	public synchronized List<Tile> extractTiles(int howMany)
	{
		List<Tile> extracted = new ArrayList<>();
		Random random = new Random();
		synchronized (tiles)
		{
			for (int i = 0; i < howMany; i++)
			{
				if(tiles.size()==0)
				{
					i=howMany;
				}
				else
				{
					int tilePosition = random.nextInt(tiles.size());
					extracted.add(tiles.get(tilePosition));
					tiles.remove(tiles.get(tilePosition));
				}
			}
		}
		return extracted;
	}

	public Integer getPoints(char letter)
	{
		for (String letters : tilePoints.keySet())
		{
			if (letters.equals(String.valueOf(letter)))
			{
				return tilePoints.get(letters);
			}
		}
		return 0;
	}

	public List<Tile> getTiles()
	{
		return tiles;
	}

}
