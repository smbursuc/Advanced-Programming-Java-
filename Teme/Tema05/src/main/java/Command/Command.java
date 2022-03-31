package Command;

import java.io.IOException;

import org.apache.tika.exception.TikaException;
import org.xml.sax.SAXException;

import Exception.ItemAlreadyAdded;
import freemarker.template.TemplateException;

public interface Command {
	
	public void execute() throws ItemAlreadyAdded, IOException, TemplateException, SAXException, TikaException;

}
