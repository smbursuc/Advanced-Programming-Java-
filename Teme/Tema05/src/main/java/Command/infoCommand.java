package Command;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.AutoDetectParser;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.Parser;
import org.apache.tika.sax.BodyContentHandler;
import org.xml.sax.SAXException;

import tema5.Item;

public class infoCommand implements Command {

	private Item item;
	
	public infoCommand(Item item)
	{
		this.item=item;
	}
	
	public void execute() throws IOException, SAXException, TikaException {
		File file = new File(item.getLocation());

		// parameters of parse() method
		Parser parser = new AutoDetectParser();
		BodyContentHandler handler = new BodyContentHandler();
		Metadata metadata = new Metadata();
		FileInputStream inputstream = new FileInputStream(file);
		ParseContext context = new ParseContext();

		// Parsing the given file
		parser.parse(inputstream, handler, metadata, context);

		// list of meta data elements elements
		String[] metadataNames = metadata.names();

		for (String name : metadataNames) {
			System.out.println(name + ": " + metadata.get(name));
		}

	}

}
