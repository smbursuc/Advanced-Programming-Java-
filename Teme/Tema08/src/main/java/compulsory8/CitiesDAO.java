package compulsory8;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CitiesDAO {

	public void create(int id, String country, String name, int capital, float latitude, float longitude) throws SQLException {
		Connection con = Database.getConnection();
		try (PreparedStatement pstmt = con.prepareStatement("insert into cities (id,country,name,capital,latitude,longitude) values (?,?,?,?,?,?)")) {
			pstmt.setInt(1, id);
			pstmt.setString(2, country);
			pstmt.setString(3, name);
			pstmt.setInt(4, capital);
			pstmt.setFloat(5, latitude);
			pstmt.setFloat(6, longitude);			
			pstmt.executeUpdate();
		}
	}

	public String findByName(String name) throws SQLException {
		Connection con = Database.getConnection();
		try (Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery("select id from cities where name='" + name + "'")) {
			String result = "";
			if(!rs.next())
			{
				return null;
			}
			
			while(rs.next())
			{
				result = result + rs.getString(1) + "\n";
			}
			
			return result;
		}
	}

	public String findById(int id) throws SQLException {
		Connection con = Database.getConnection();
		try (Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery("select name from cities where id='" + id + "'")) {
			String result = "";
			if(!rs.next())
			{
				return null;
			}
			
			while(rs.next())
			{
				result = result + rs.getString(1) + "\n";
			}
			
			return result;
		}
	}
	
	public String findByCountry(String country) throws SQLException {
		Connection con = Database.getConnection();
		try (Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery("select name from cities where country='" + country + "'")) {
			String result = "";
			if(!rs.next())
			{
				return null;
			}
			
			while(rs.next())
			{
				result = result + rs.getString(1) + "\n";
			}
			
			return result;
		}
	}
	
	public void addFromReader(CityDatasetReader cdr) throws NumberFormatException
	{
		for(Integer key : cdr.getData().keySet())
		{
			String country = cdr.getData().get(key).get(0);
			String capital = cdr.getData().get(key).get(1);
			float latitude = Float.valueOf(cdr.getData().get(key).get(2));
			float longitude = Float.valueOf(cdr.getData().get(key).get(3));
			try {
				create(key,country,capital,1,latitude,longitude);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}

}
