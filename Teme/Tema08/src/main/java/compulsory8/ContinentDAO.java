package compulsory8;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ContinentDAO {

	public void create(String name, int id) throws SQLException {
		Connection con = Database.getConnection();
		try (PreparedStatement pstmt = con.prepareStatement("insert into continents (name,id) values (?,?)")) {
			pstmt.setString(1, name);
			pstmt.setInt(2, id);
			pstmt.executeUpdate();
		}
	}

	public Integer findByName(String name) throws SQLException {
		Connection con = Database.getConnection();
		try (Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery("select id from continents where name='" + name + "'")) {
			return rs.next() ? rs.getInt(1) : null;
		}
	}

	public String findById(int id) throws SQLException {
		Connection con = Database.getConnection();
		try (Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery("select name from continents where id='" + id + "'")) {
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

}
