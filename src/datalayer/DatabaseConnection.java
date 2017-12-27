package datalayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnection {

	private static Connection conn;

	public static Connection getConnection() throws SQLException {

		if (conn == null || conn.isClosed()) {
			conn = CreateNewConnection();
		}
		return conn;
	}

	private static Connection CreateNewConnection() throws SQLException {
		Statement stmt = null;
		try {
			Class.forName("org.sqlite.JDBC");
			conn = DriverManager.getConnection("jdbc:sqlite:Database");
			stmt = conn.createStatement();
			
			String sql = "CREATE TABLE IF NOT EXISTS PERSON " + "(FIRSTNAME TEXT NOT NULL," + "LASTNAME TEXT NOT NULL,"
					+ "DATEOFBIRTH TEXT NOT NULL," + "AGE TEXT NOT NULL," + "EMAIL TEXT NOT NULL,"
					+ "PHONENUMBER TEXT NOT NULL," + "ADDRESS1 TEXT NOT NULL," + "ADDRESS2 TEXT ,"
					+ "CITY TEXT NOT NULL," + "ZIP TEXT NOT NULL, " + "STATE TEXT NOT NULL," + "COUNTRY TEXT NOT NULL)";
			
			stmt.executeUpdate(sql);
			stmt.close();

		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		return conn;
	}

}
