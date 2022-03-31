package Command;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import tema5.Item;

public class viewCommand implements Command {

	private Item item;
	
	public viewCommand(Item item)
	{
		this.item=item;
	}
	
	public void execute() throws IOException {
		Desktop desktop = Desktop.getDesktop();
		File folder = new File(item.getLocation());
		desktop.open(folder);
		
	}

}
