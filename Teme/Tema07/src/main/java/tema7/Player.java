package tema7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class Player implements Runnable
{
	private String name;
	private Game game;
	private boolean running;
	private List<String> words = new ArrayList<>();
	private List<Tile> extracted = new ArrayList<>();
	private int extractionAmount = 7;

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
	
	public void showExtracted()
	{
		System.out.print(name + " has the set ");
		for(Tile tile : extracted)
		{
			System.out.print(tile.getLetter());
		}
		System.out.println("");
	}

	private boolean submitWord() throws InterruptedException
	{
		if(game.getTimekeeper().getStop()==true)
		{
			return false;
		}
		if (game.getBag().getTiles().size() == 0)
		{
			System.out.println("Game over");

			Collections.sort(game.getPlayers(), new Comparator<Player>()
			{
				public int compare(Player p1, Player p2)
				{
					int scoreP1 = game.getBoard().getPlayerPoints().get(p1);
					int scoreP2 = game.getBoard().getPlayerPoints().get(p2);
					return scoreP1 < scoreP2 ? 1 : scoreP1 > scoreP2 ? -1 : 0;
				}
			});

			for (Player player : game.getPlayers())
			{
				System.out.println(
						player.getName() + " has " + game.getBoard().getPlayerPoints().get(player) + " points.???");
			}

			return false;
		}
		List<Tile> partialExtract = game.getBag().extractTiles(extractionAmount);
		
		for(Tile tile : partialExtract)
		{
			extracted.add(tile);
		}
		
		// create a word with all the extracted tiles;
		Random random = new Random();
		int wordLength = 1 + random.nextInt(7);
		
		
		for(int i=0;i<wordLength;i++)
		{
			words.removeAll(words);
			generateWords(extracted,wordLength,"");
		}

		
		if(words.size()==0)
		{
			System.out.println(name + " couldn't find any words with the extraced tiles and word length.");
			extractionAmount = 7;
			extracted.removeAll(extracted);
		}
		else
		{
			showExtracted();
			int wordListIndex = random.nextInt(words.size());
			extractionAmount = words.get(wordListIndex).length();
			for(int i=0;i<words.get(wordListIndex).length();i++)
			{
				for(int j=0;j<extracted.size();j++)
				{
					if(extracted.get(j).getLetter() == words.get(wordListIndex).charAt(i))
					{
						extracted.remove(extracted.get(j));
						j=extracted.size();
					}
				}
			}
			
			partialExtract = game.getBag().extractTiles(extractionAmount);
			
			for(Tile tile : partialExtract)
			{
				extracted.add(tile);
			}
			
			extractionAmount = 0;
			
			game.getBoard().addWord(this, words.get(wordListIndex));
			
		}
		return true;

	}
	
	public void generateWords(List<Tile> extracted, int wordLength, String currentWord)
	{
		if(currentWord.length()==wordLength)
		{
			if(game.getDictionary().getWords().contains(currentWord))
			{
				words.add(currentWord);
				return;
			}
		}
		else
		{
			for(int i=0;i<extracted.size();i++)
			{
				String wordCopy = currentWord;
				Tile tileCopy = extracted.get(i);
				currentWord = currentWord + String.valueOf(extracted.get(i).getLetter());
				extracted.remove(extracted.get(i));
				generateWords(extracted,wordLength,currentWord);
				extracted.add(tileCopy);
				currentWord=wordCopy;
			}
		}
	}

	public void run()
	{
		try
		{
			while (true)
			{
				if(!submitWord())
					break;
				else Thread.sleep(1000);
			}
		}
		catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}