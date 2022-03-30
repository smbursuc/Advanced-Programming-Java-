package Command;

import java.io.File;
import java.io.IOException;
import com.fasterxml.jackson.databind.ObjectMapper;

import tema5.Catalog;

public class saveCommand extends Command{
	
	public void save(Catalog catalog, String path) throws IOException {

		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.writeValue(new File(path), catalog);
	}

}
