package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Class responsible for the connection to the database.
 */
public class ConnectionBBDD {

	private final String bbdd = "shop";
	private final String user = "root";
	private final String password = "root";
	private final String url = "jdbc:mysql://localhost:3306/" + bbdd + "?userTimezone=true&serverTimezone=UTC";

	private Connection connection = null;

	public Connection getConnection() {

		try {
			connection = DriverManager.getConnection(this.url, this.user, this.password);
		} catch (SQLException sqlException) {
			System.out.println(sqlException);
		}

		return connection;
	}

}
