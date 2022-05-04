package compulsory8;

import java.io.File;
import java.sql.SQLException;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Ellipse;
import javafx.stage.Stage;

public class Main extends Application{
	
	private static CityDatasetReader cdr = new CityDatasetReader();

	public static double distance(double lat1, double lat2, double lon1, double lon2) {

		lon1 = Math.toRadians(lon1);
		lon2 = Math.toRadians(lon2);
		lat1 = Math.toRadians(lat1);
		lat2 = Math.toRadians(lat2);

		double dlon = lon2 - lon1;
		double dlat = lat2 - lat1;
		double a = Math.pow(Math.sin(dlat / 2), 2) + Math.cos(lat1) * Math.cos(lat2) * Math.pow(Math.sin(dlon / 2), 2);
		double c = 2 * Math.asin(Math.sqrt(a));
		double r = 6371;
		
		return (c * r);
	}

	public static void main(String args[]) {
		try {
			ContinentDAO continents = new ContinentDAO();
			Database.createConnection();
			continents.create("Europe", 0);
			continents.create("Asia", 1);
			Database.getConnection().commit();
			System.out.println(continents.findById(0));
			System.out.println(continents.findAll());
			
			
			CountryDAO countries = new CountryDAO();
			countries.create("Romania", continents.findByName("Europe"));
			countries.create("China", continents.findByName("Asia"));
			Database.getConnection().commit();
			System.out.println(countries.findById(0));
			System.out.println(countries.findByName("Romania"));
			
			cdr.readDataLineByLine("./concap.csv");
			CitiesDAO cities = new CitiesDAO();
			cities.addFromReader(cdr);
			Database.getConnection().commit();
			Database.getConnection().close();
		} catch (SQLException e) {
			System.err.println(e);
			Database.rollback();
		}
		
		cdr.readDataLineByLine("./concap.csv");
		double lat1 = Double.valueOf(cdr.getData().get(1).get(2));
		double long1 = Double.valueOf(cdr.getData().get(1).get(3));
		double lat2 = Double.valueOf(cdr.getData().get(2).get(2));
		double long2 = Double.valueOf(cdr.getData().get(2).get(3));
		System.out.println(distance(lat1,lat2,long1,long2));
		launch(args);
		
		
		
		
	}
	
	public void start(Stage primaryStage)
	{
		primaryStage.setTitle("Map");
        
        Pane root = new Pane();
        
        Image worldMap = new Image(new File("./worldmap3.jpg").toURI().toString());
        BackgroundImage bgImg = new BackgroundImage(worldMap, 
        	    BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
        	    BackgroundPosition.DEFAULT, 
        	    new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false));

        root.setBackground(new Background(bgImg));
                
        //SphericalMercator sphc = new SphericalMercator();
        MercatorV2 mcv2 = new MercatorV2(1200,1200);
        for(Integer key : cdr.getData().keySet())
        {
        	Ellipse ellipse = new Ellipse(3,3,3,3);
        	if(cdr.getData().get(key).get(1).equals("Bucharest") || cdr.getData().get(key).get(1).equals("Washington") || cdr.getData().get(key).get(1).equals("Tokyo"))
        		ellipse.setStyle("-fx-fill: blue;");
        	else ellipse.setStyle("-fx-fill: red;");
        	root.getChildren().add(ellipse);
        	double lat1 = Double.valueOf(cdr.getData().get(key).get(2));
    		double long1 = Double.valueOf(cdr.getData().get(key).get(3));
        	ellipse.setTranslateX(mcv2.getX(long1));
        	ellipse.setTranslateY(mcv2.getY(lat1));
        }
        
        Scene scene = new Scene(root, 1200, 1200);
        primaryStage.setScene(scene);
        primaryStage.show();

	}

}
