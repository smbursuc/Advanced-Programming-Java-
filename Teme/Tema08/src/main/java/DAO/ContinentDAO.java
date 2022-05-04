package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Places.Continent;
import Places.Country;
import compulsory8.Database;

public class ContinentDAO {

	public void create(String name, int id) throws SQLException {
		Connection con = Database.getConnection();
		try (PreparedStatement pstmt = con.prepareStatement("insert into continents (name,id) values (?,?)")) {
			pstmt.setString(1, name);
			pstmt.setInt(2, id);
			pstmt.executeUpdate();
		}
	}

	public List<Continent> findByName(String name) throws SQLException {
		Connection con = Database.getConnection();
		try (Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery("select id,name from continents where name='" + name + "'")) {
			List<Continent> result = new ArrayList<>();

			while(rs.next())
			{
				Continent continent = new Continent(rs.getInt(1),rs.getString(2));
				result.add(continent);
			}
			
			return result;
		}
	}

	public List<Continent> findById(int id) throws SQLException {
		Connection con = Database.getConnection();
		try (Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery("select id,name from continents where id='" + id + "'")) {
			List<Continent> result = new ArrayList<>();
			
			while(rs.next())
			{
				Continent continent = new Continent(rs.getInt(1),rs.getString(2));
				result.add(continent);
			}
			
			return result;
		}
	}
	
	public List<Continent> findAll() throws SQLException {
		Connection con = Database.getConnection();
		try (Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery("select id,name from continents")) {
			List<Continent> result = new ArrayList<>();
			
			while(rs.next())
			{
				Continent continent = new Continent(rs.getInt(1),rs.getString(2));
				result.add(continent);
			}
			
			return result;
		}
	}

}
