package bursucserban.compulsory6;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
 
public class App extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) {
    	BorderPane layout = new BorderPane();

        ConfigPanel cfgp = new ConfigPanel(10,10);
        DrawingPanel dwp = new DrawingPanel(cfgp.getX(),cfgp.getY());
        ControlPanel cp = new ControlPanel();
        
        cfgp.getCreateButton().setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
            	DrawingPanel dp = new DrawingPanel(cfgp.getX(),cfgp.getY());
                layout.setCenter(dp.create());
            }
        });
       
        layout.setTop(cfgp.create());
        layout.setCenter(dwp.create());
        layout.setBottom(cp.create());
        primaryStage.setScene(new Scene(layout, 800, 600));
        primaryStage.show();
    }
}