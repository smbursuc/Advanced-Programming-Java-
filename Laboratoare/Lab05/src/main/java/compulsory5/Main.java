package compulsory5;

import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException, InvalidCatalogException {

		Item item1 = new Book("628", "Metro 2033", "D:/Books");
        Item item2 = new Article("120", "The Fellowship of the Ring" , "D:/Books");
        Catalog catalog1 = new Catalog("Favorite Books");
        catalog1.add(item1);
        catalog1.add(item2);
        CatalogUtil.save(catalog1, "./catalog.json");
        Catalog catalog2 = CatalogUtil.load("./catalog.json");
        System.out.println(catalog2);
	}

}
