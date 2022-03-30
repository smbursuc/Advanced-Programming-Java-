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
        
        addCommand ac = new addCommand();
        ac.addToCatalog(catalog1, item1);
        ac.addToCatalog(catalog1, item2);
        
        saveCommand sc = new saveCommand();
        sc.save(catalog1, "./Util/Catalog/catalog.json");
        
        loadCommand ldc = new loadCommand();
        Catalog catalog2 = ldc.load("./Util/Catalog/catalog.json");
        System.out.println(catalog2);
        
        listCommand lstc = new listCommand();
        lstc.listItems(catalog1);
        
        viewCommand vc = new viewCommand();
        vc.view(item2);
      
        reportCommand rc = new reportCommand();
        rc.generateReport(catalog1);
        
        infoCommand ic = new infoCommand();
        ic.getMetaData(item2);
        

	}

}
