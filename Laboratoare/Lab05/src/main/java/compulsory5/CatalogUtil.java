package compulsory5;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;



public class CatalogUtil {

	public static void save(Catalog catalog, String path) throws IOException {

		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.writeValue(new File(path), catalog);
	}

	public static Catalog load(String path) throws InvalidCatalogException, StreamReadException, DatabindException, IOException {
		ObjectMapper objectMapper = new ObjectMapper();
		Catalog catalog = objectMapper.readValue(new File(path), Catalog.class);
		return catalog;
	}
	
	
	
	

}
