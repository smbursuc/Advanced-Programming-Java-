package tema7;

import java.util.ArrayList;
import java.util.List;

public class Game
{
	private final Bag bag = new Bag();
	private final Dictionary dictionary = new Dictionary();
	private final Board board = new Board(dictionary, this);
	private final List<Player> players = new ArrayList<>();
	private Timekeeper timekeeper = new Timekeeper();

	public void addPlayer(Player player)
	{
		players.add(player);
		player.setGame(this);
	}
	
	public Timekeeper getTimekeeper()
	{
		return timekeeper;
	}
	
	public Bag getBag()
	{
		return bag;
	}
	
	public Board getBoard()
	{
		return board;
	}
	
	public List<Player> getPlayers()
	{
		return players;
	}
	
	public Dictionary getDictionary()
	{
		return dictionary;
	}

	public void play() 
	{
		board.setPlayerPoints();
		for (Player player : players) 
		{
			new Thread(player).start();
		}
		Thread daemonThread = new Thread(new Timekeeper());
		daemonThread.setDaemon(true);
		daemonThread.start();
	}
	
	public static void main(String[] args)
	{
		Game game = new Game();
		game.addPlayer(new Player("Player 1"));
		game.addPlayer(new Player("Player 2"));
		game.addPlayer(new Player("Player 3"));
		game.play();
	}

}