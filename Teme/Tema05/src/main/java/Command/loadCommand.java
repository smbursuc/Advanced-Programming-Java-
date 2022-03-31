package Command;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

import tema5.Catalog;
import Exception.InvalidCatalogException;


public class loadCommand {
	
	private String path;
	
	public loadCommand(String path)
	{
		this.path=path;
	}
	
	public Catalog execute() throws StreamReadException, DatabindException, IOException, InvalidCatalogException {
		ObjectMapper objectMapper = new ObjectMapper();
		Catalog catalog = objectMapper.readValue(new File(path), Catalog.class);
		return catalog;
	}

}
