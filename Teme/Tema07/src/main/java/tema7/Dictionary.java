package tema7;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Dictionary
{

	private List<String> words = new ArrayList<>();

	public Dictionary()
	{
		Stream<String> stream;
		try
		{
			stream = Files.lines(Paths.get("./dictionary.txt"));
			stream.forEach(word ->
			{
				word = word.toLowerCase();
				words.add(word);
			});
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public boolean isWord(String str)
	{
		return true;
	}
	
	public List<String> getWords()
	{
		return words;
	}
}