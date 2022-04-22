package compulsory8;

import java.sql.SQLException;

public class Main {

	public static void main(String args[]) {
		try {
			var continents = new ContinentDAO();
			Database.createConnection();
			continents.create("Europe",0);
			continents.create("Asia",1);
			Database.getConnection().commit();
			System.out.println(continents.findById(0));
			var countries = new CountryDAO();
			countries.create("Romania", continents.findByName("Europe"));
			countries.create("China", continents.findByName("Asia"));
			Database.getConnection().commit();
			System.out.println(countries.findById(0));
			System.out.println(countries.findByName("Romania"));
			Database.getConnection().close();
		} catch (SQLException e) {
			System.err.println(e);
			Database.rollback();
		}
	}

}
