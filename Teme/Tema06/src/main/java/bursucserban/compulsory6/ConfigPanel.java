package bursucserban.compulsory6;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.layout.HBox;

public class ConfigPanel {

	private int x = 0, y = 0; 
	private int maxX=0, maxY =0;
	private Button createButton = new Button();
	
	public Button getCreateButton()
	{
		return createButton;
	}

	public ConfigPanel(int maxX, int maxY) {
		this.maxX = maxX;
		this.maxY = maxY;
		x=y=5;
	}

	public HBox create() {

		HBox hbox = new HBox();

		hbox.setPadding(new Insets(10));

		Label xLabel = new Label();
		xLabel.setText("x:");
		Spinner<Integer> xSpinner = new Spinner<Integer>();
		SpinnerValueFactory<Integer> xValueFactory = //
				new SpinnerValueFactory.IntegerSpinnerValueFactory(1, maxX, x);
		xSpinner.setValueFactory(xValueFactory);
		xValueFactory.valueProperty().addListener((observable, oldValue, newValue) -> {x=newValue;});
		
		Label yLabel = new Label();
		yLabel.setText("y:");
		Spinner<Integer> ySpinner = new Spinner<Integer>();
		SpinnerValueFactory<Integer> yValueFactory = //
				new SpinnerValueFactory.IntegerSpinnerValueFactory(1, maxY, y);
		ySpinner.setValueFactory(yValueFactory);
		yValueFactory.valueProperty().addListener((observable, oldValue, newValue) -> {y=newValue;});
		
		createButton.setText("CREATE");

		hbox.getChildren().addAll(xLabel,xSpinner);
		hbox.getChildren().addAll(yLabel,ySpinner);
		hbox.getChildren().add(createButton);
		return hbox;

	}

	public int getX()
	{
		return x;
	}

	public void setX(int x)
	{
		this.x = x;
	}

	public int getY()
	{
		return y;
	}

	public void setY(int y)
	{
		this.y = y;
	}
	
	

}
