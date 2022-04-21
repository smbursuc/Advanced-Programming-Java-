package tema7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Board
{
	private List<String> dictionaryWords = new ArrayList<>();
	private Map<Player,Integer> playerPoints = new HashMap<>();
	private Game game;
	
	public Board(Dictionary dictionary, Game game)
	{
		this.dictionaryWords=dictionary.getWords();
		this.game = game;
	}

	public synchronized void addWord(Player player, String word)
	{
		if(dictionaryWords.contains(word))
		{
			int pointSum = 0;
			for(int i=0;i<word.length();i++)
			{
				pointSum = pointSum + game.getBag().getPoints(word.charAt(i));
			}
			playerPoints.put(player,playerPoints.get(player)+pointSum);
			System.out.println(player.getName() + " word: " + word + " points: " + pointSum + " bag size: " + game.getBag().getTiles().size());
		}
	}

	@Override
	public String toString()
	{
		return dictionaryWords.toString();
	}
	
	public void setDictionary(Dictionary dictionary)
	{
		dictionaryWords=dictionary.getWords();
	}
	
	public void setPlayerPoints()
	{
		game.getPlayers().stream().forEach(player -> playerPoints.put(player,0));
	}

	public Map<Player, Integer> getPlayerPoints()
	{
		return playerPoints;
	}
	
}
