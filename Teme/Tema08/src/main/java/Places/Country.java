package Places;

public class Country extends Place{
	
	private String continent;
	private String code;
	
	public Country(int id, String name, String continent, String code)
	{
		super(id,name);
		this.continent = continent;
		this.code = code;
	}

	public String getContinent() {
		return continent;
	}

	public void setContinent(String continent) {
		this.continent = continent;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	public String toString()
	{
		return "ID: " + id + " Name: " + name + " Continent: " + continent + " Code: " +  code;
	}
	
	
	

}
