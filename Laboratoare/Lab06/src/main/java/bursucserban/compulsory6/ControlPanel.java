package bursucserban.compulsory6;

import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.application.Platform;
import javafx.event.ActionEvent;

public class ControlPanel
{

	public HBox create()
	{
		HBox controlPanel = new HBox();
		
		
		Button save = new Button("Save");
		Button load = new Button("Load");
		Button exit = new Button("Exit");
		
		exit.setOnAction((ActionEvent event) -> {
		    Platform.exit();
		});
		
		controlPanel.getChildren().addAll(save,load,exit);
		
		return controlPanel;
	}

}
