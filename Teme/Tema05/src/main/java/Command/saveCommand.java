package Command;

import java.io.File;
import java.io.IOException;
import com.fasterxml.jackson.databind.ObjectMapper;

import tema5.Catalog;

public class saveCommand implements Command{
	
	private Catalog catalog;
	private String path;
	
	public saveCommand(Catalog catalog, String path)
	{
		this.catalog=catalog;
		this.path=path;
	}
	
	public void execute() throws IOException {

		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.writeValue(new File(path), catalog);
	}

}
