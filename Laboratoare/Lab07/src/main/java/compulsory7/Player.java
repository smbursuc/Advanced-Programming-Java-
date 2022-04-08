package compulsory7;

import java.util.List;
import java.util.Random;

public class Player implements Runnable
{
	private String name;
	private Game game;
	private boolean running;

	public Player(String name)
	{
		this.name = name;
	}

	public String getName()
	{
		return name;
	}

	public void setGame(Game game)
	{
		this.game = game;
	}

	private boolean submitWord() throws InterruptedException 
	{
		List<Tile> extracted = game.getBag().extractTiles(7);
		if (extracted.isEmpty()) 
		{
			return false;
		}
		//create a word with all the extracted tiles;
		Random random = new Random();
		String word = "";
		for(int i=0;i<extracted.size();i++)
		{
			int extractedIndex = random.nextInt(extracted.size());
			word = word + extracted.get(extractedIndex).getLetter();
		}
		game.getBoard().addWord(this, word);
		

		Thread.sleep(50);
		
		return true;

	}

	public void run()
	{
		try
		{
			while(true)
			{
				submitWord();
				Thread.sleep(1000);
			}
		} 
		catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}