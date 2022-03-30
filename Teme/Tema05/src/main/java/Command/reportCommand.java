package Command;

import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.log4j.PropertyConfigurator;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;
import tema5.Catalog;


public class reportCommand extends Command{

	public void generateReport(Catalog catalog) throws IOException, TemplateException
	{
		Properties props = new Properties();
        props.load(new FileInputStream("./log4j.properties"));
        PropertyConfigurator.configure(props);
        
		Configuration cfg = new Configuration(Configuration.VERSION_2_3_29);
		cfg.setDirectoryForTemplateLoading(new File("./Util/Templates"));
		cfg.setDefaultEncoding("UTF-8");
		cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
		cfg.setLogTemplateExceptions(false);
		cfg.setWrapUncheckedExceptions(true);
		cfg.setFallbackOnNullLoopVariable(false);
		
		Map<String, Object> tags = new HashMap<>();
		tags.put("title", catalog.getName());
		tags.put("catalogItems", catalog.getItems());
		
		Template template = cfg.getTemplate("template.ftl");
		
		Writer fileWriter = new FileWriter(new File("./Util/Reports/report.html")); 
	    template.process(tags, fileWriter);
	    fileWriter.close();
	    
	    Desktop desktop = Desktop.getDesktop();
		File folder = new File("./Util/Reports/report.html");
		desktop.open(folder);
	
		
		

	}
}
