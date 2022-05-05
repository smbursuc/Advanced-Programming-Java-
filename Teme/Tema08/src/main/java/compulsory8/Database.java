package compulsory8;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Database {

	private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
	private static final String USER = "postgres";
	private static final String PASSWORD = "password";
	private static Connection connection = null;

	private Database() {
	}

	public static Connection getConnection()
	{
		return connection;
	}

	public static void createConnection() {
		try {
			connection = DriverManager.getConnection(
					 URL, USER, PASSWORD);
			connection.setAutoCommit(false);
		} catch (SQLException e) {
			System.err.println(e);
		}
	}

	public static void closeConnection() {
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void rollback()
	{
		try {
			connection.rollback();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void nukeDatabase()
	{
		Connection con = Database.getConnection();
		try 
		{
			PreparedStatement pstmt1 = con.prepareStatement("delete from cities");
			PreparedStatement pstmt2 = con.prepareStatement("delete from countries");
			PreparedStatement pstmt3 = con.prepareStatement("delete from continents");
			pstmt1.executeUpdate();
			pstmt2.executeUpdate();
			pstmt3.executeUpdate();
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
	}

}
