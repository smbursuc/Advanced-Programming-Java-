package tema5;
import java.io.IOException;

import org.apache.tika.exception.TikaException;
import org.xml.sax.SAXException;

import Command.*;
import Exception.InvalidCatalogException;
import Exception.ItemAlreadyAdded;
import freemarker.template.TemplateException;

public class Main {

	public static void main(String[] args) throws IOException, TemplateException, SAXException, TikaException, InvalidCatalogException, ItemAlreadyAdded {
		
		Item item1 = new Book("628", "Metro 2033", ".\\Util\\Books\\lotr.txt");
        Item item2 = new Article("120", "The Fellowship of the Ring" , ".\\Util\\Books\\metro.txt");
        Catalog catalog1 = new Catalog("Favorite Books");
        
        addCommand ac1 = new addCommand(catalog1, item1);
        ac1.execute();
        addCommand ac2 = new addCommand(catalog1,item2);
        ac2.execute();
        
        saveCommand sc = new saveCommand(catalog1,"./Util/Catalog/catalog.json");
        sc.execute();
        
        loadCommand ldc = new loadCommand("./Util/Catalog/catalog.json");
        Catalog catalog2 = ldc.execute();
        System.out.println(catalog2);
        
        listCommand lstc = new listCommand(catalog1);
        lstc.execute();
        
        viewCommand vc = new viewCommand(item2);
        vc.execute();
      
        reportCommand rc = new reportCommand(catalog1);
        rc.execute();
        
        infoCommand ic = new infoCommand(item2);
        ic.execute();
        
	}

}
