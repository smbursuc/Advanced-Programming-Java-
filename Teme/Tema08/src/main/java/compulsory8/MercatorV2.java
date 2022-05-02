package compulsory8;

public class MercatorV2 {

	private int width;
	private int height; 
	
	public MercatorV2(int width, int height)
	{
		this.width=width;
		this.height=height;
	}
	public double getX(double longitude)
	{
		//double x = (longitude+180)*(width/360);
		
		double x = (width * (180 + longitude) / 360) % width -5;
		return x;
	}
	
	public double getY(double latitude)
	{
		double latRad = latitude*Math.PI/180;

		// get y value
		double mercN = Math.log(Math.tan((Math.PI/4)+(latRad/2)));
		double y = (height/2)-(width*mercN/(2*Math.PI));
		
		return y;

	}
}
