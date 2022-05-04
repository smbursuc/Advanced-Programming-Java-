package Places;

public class City extends Place{
	
	private String country;
	private int capital;
	private double latitude;
	private double longitude;
	
	public City(int id, String name, String country, int capital, double latitude, double longitude)
	{
		super(id,name);
		this.country = country;
		this.capital = capital;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getCapital() {
		return capital;
	}

	public void setCapital(int capital) {
		this.capital = capital;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	@Override
	public String toString() {
		return "ID: " + id + " Name: " + name + " Country: " + country + " Capital: " + capital + " Latitude: " + latitude + " Longitude: "
				+ longitude;
	}
	
	
	
	

}
