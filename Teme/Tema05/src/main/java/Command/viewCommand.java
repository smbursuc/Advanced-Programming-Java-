package Command;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import tema5.Item;

public class viewCommand extends Command {

	public void view(Item item) throws IOException {
		Desktop desktop = Desktop.getDesktop();
		File folder = new File(item.getLocation());
		desktop.open(folder);
		
	}

}
