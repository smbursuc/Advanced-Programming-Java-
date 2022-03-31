package Command;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

import tema5.Catalog;
import Exception.InvalidCatalogException;


public class loadCommand implements Command{
	
	private String path;
	private Catalog catalog;
	
	public loadCommand(String path, Catalog catalog)
	{
		this.path=path;
		this.catalog=catalog;
	}
	
	public void execute() throws StreamReadException, DatabindException, IOException, InvalidCatalogException {
		ObjectMapper objectMapper = new ObjectMapper();
		catalog = objectMapper.readValue(new File(path), Catalog.class);
	}

}
