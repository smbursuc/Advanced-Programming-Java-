package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Places.Country;
import compulsory8.Database;

public class CountryDAO {

	public void create(String name, int id, String continent, String code) throws SQLException {
		Connection con = Database.getConnection();
		try (PreparedStatement pstmt = con
				.prepareStatement("insert into countries(name,id,continent,code) values (?,?,?,?)")) {
			pstmt.setString(1, name);
			pstmt.setInt(2, id);
			pstmt.setString(3, continent);
			pstmt.setString(4, code);
			pstmt.executeUpdate();
		}
	}

	public List<Country> findByName(String name) throws SQLException {
		Connection con = Database.getConnection();
		try (Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery("select id,name,continent,code from countries where name='" + name + "'")) {
			List<Country> result = new ArrayList<>();

			while(rs.next())
			{
				Country country = new Country(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4));
				result.add(country);
			}
			
			return result;
		}
	}

	public List<Country> findById(int id) throws SQLException {
		Connection con = Database.getConnection();
		try (Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery("select id,name,continent,code from countries where id='" + id + "'")) {
			List<Country> result =  new ArrayList<>();

			while (rs.next())
			{
				Country country = new Country(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4));
				result.add(country);
			}

			return result;
		}

	}
	
	public List<Country> findAll() throws SQLException {
		Connection con = Database.getConnection();
		try (Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery("select * from cities")) {
			List<Country> result =  new ArrayList<>();

			while (rs.next())
			{
				Country country = new Country(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4));
				result.add(country);
			}

			return result;
		}
	}
}
