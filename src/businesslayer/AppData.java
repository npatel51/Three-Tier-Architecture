package businesslayer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import datalayer.DatabaseConnection;

// This is an example of using the Singleton pattern to make the application's data available throughout the 
// application while guaranteeing that there is only one copy of it.

public class AppData {

	private static List<Person> people = new ArrayList<Person>();

	
	private static Connection conn = null;
	// this is the reference to the single instance of the AppData class
	private static AppData appData = null;

	// A private constructor that is only called one time
	private AppData() {
		try {
			conn = DatabaseConnection.getConnection();
		} catch (SQLException e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
		}
	}

	// A public method to make the app Data available throughout the
	// application.The first time the method is called, the Single instance of AppData is
	// created, each subsequent time, the one data object created is returned.

	public static AppData getAppData() {
		if (appData == null) {
			appData = new AppData();
		}
		return appData;

	}

	// example of a method to change the appData from throughout the project
	// there might be lots of there to add / remove data.

	public void addPerson(Person person) throws SQLException {
		Statement stmt = null;

		// add person
		people.add(person);

		try {
			conn.setAutoCommit(false);
			stmt = conn.createStatement();
			String info = "INSERT INTO PERSON (FIRSTNAME,LASTNAME,DATEOFBIRTH,AGE,EMAIL,PHONENUMBER,ADDRESS1,ADDRESS2,CITY,ZIP,STATE,COUNTRY) "
					+ "VALUES ('" + person.getFirstName().toString() + "','" + person.getLastName().toString() + "','"
					+ person.getDateOfBirth().toString() + "','" + person.getAge().toString() + "','"
					+ person.getEmail().toString() + "','" + person.getPhoneNumber().toString() + "','"
					+ person.getAddress1().toString() + "','" + person.getAddress2().toString() + "','"
					+ person.getCity().toString() + "','" + person.getZipCode().toString() + "','"
					+ person.getState().toString() + "','" + person.getCountry().toString() + "');";
			stmt.executeUpdate(info);
			stmt.close();
			conn.commit();

		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		} 
	}

	public Person getPerson(String firstName, String lastName) throws SQLException {
	
		Statement stmt = null;
		Person person = null;
		try {
			conn = DatabaseConnection.getConnection();
			conn.setAutoCommit(false);
			stmt = conn.createStatement();

			ResultSet result = stmt.executeQuery(
					"SELECT * FROM PERSON WHERE (FIRSTNAME = '" + firstName + "') and (LASTNAME = '" + lastName + "')");

			while (result.next()) {
				person = new Person(result.getString(1), result.getString(2), result.getString(3), result.getString(4),
						result.getString(5), result.getString(6), result.getString(7), result.getString(8),
						result.getString(9), result.getString(10), result.getString(11), result.getString(12));
			}
			result.close();
			stmt.close();
			conn.commit();
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
		} 

		return person;
	}

	public void deletePerson(String firstName, String lastName) throws SQLException {
		Statement stmt = null;
		try {
			conn = DatabaseConnection.getConnection();
			conn.setAutoCommit(false);
			stmt = conn.createStatement();

			String deleteQuery = "DELETE FROM PERSON WHERE (FIRSTNAME = '" + firstName + "') and (LASTNAME = '"
					+ lastName + "');";

			stmt.executeUpdate(deleteQuery);
			stmt.close();
			conn.commit();
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
		} 
	}

	public  ArrayList<Person> findAllPeople() throws SQLException {
		ArrayList<Person> listofPeople = new ArrayList<Person>();
	
		Statement stmnt = null;
		try {
			conn = DatabaseConnection.getConnection();
			conn.setAutoCommit(false);
			stmnt = conn.createStatement();
			ResultSet result = stmnt.executeQuery("SELECT * FROM PERSON");

			while (result.next()) {
				listofPeople.add(new Person(result.getString(1), result.getString(2), result.getString(3), result.getString(4),
								result.getString(5), result.getString(6), result.getString(7), result.getString(8),
								result.getString(9), result.getString(10), result.getString(11), result.getString(12)));

			}

			result.close();
			stmnt.close();
			conn.commit();
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
		} 
		return listofPeople;
	}
	
	
	//close the connection
	
	public void closeConnection() {
		try {
			if(conn!=null && !conn.isClosed())
				conn.close();
		} catch (SQLException e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
		}
	}

}
