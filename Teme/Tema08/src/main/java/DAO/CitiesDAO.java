package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Places.City;
import Util.CityDatasetReader;
import compulsory8.Database;

public class CitiesDAO {

	public void create(int id, String country, String name, int capital, double latitude, double longitude) throws SQLException {
		Connection con = Database.getConnection();
		try (PreparedStatement pstmt = con.prepareStatement("insert into cities (id,country,name,capital,latitude,longitude) values (?,?,?,?,?,?)")) {
			pstmt.setInt(1, id);
			pstmt.setString(2, country);
			pstmt.setString(3, name);
			pstmt.setInt(4, capital);
			pstmt.setDouble(5, latitude);
			pstmt.setDouble(6, longitude);			
			pstmt.executeUpdate();
		}
	}

	public List<City> findByName(String name) throws SQLException {
		Connection con = Database.getConnection();
		try (Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery("select id,country,name,capital,latitude,longitude from cities where name='" + name + "'")) {
			List<City> result = new ArrayList<>();
			
			while(rs.next())
			{
				City city = new City(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getDouble(5),rs.getDouble(6));
				result.add(city);
			}
			
			return result;
		}
	}

	public List<City> findById(int id) throws SQLException {
		Connection con = Database.getConnection();
		try (Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery("select id,country,name,capital,latitude,longitude from cities where id='" + id + "'")) {
			List<City> result = new ArrayList<>();

			while(rs.next())
			{
				City city = new City(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getDouble(5),rs.getDouble(6));
				result.add(city);
			}
			
			return result;
		}
	}
	
	public List<City> findByCountry(String country) throws SQLException {
		Connection con = Database.getConnection();
		try (Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery("select id,country,name,capital,latitude,longitude from cities where country='" + country + "'")) {
			List<City> result = new ArrayList<>();

			while(rs.next())
			{
				City city = new City(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getDouble(5),rs.getDouble(6));
				result.add(city);
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
	
	public List<City> findAll() throws SQLException {
		Connection con = Database.getConnection();
		try (Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery("select * from cities")) {
			List<City> result = new ArrayList<>();

			while(rs.next())
			{
				City city = new City(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getDouble(5),rs.getDouble(6));
				result.add(city);
			}
			
			return result;
		}
	}

}
