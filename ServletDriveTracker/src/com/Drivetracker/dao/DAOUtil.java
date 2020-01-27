package com.Drivetracker.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAOUtil {

	public static Connection dBConnection() throws ClassNotFoundException, SQLException {
		// Database Connection
		Class.forName("com.mysql.cj.jdbc.Driver");
		final String URL = "jdbc:mysql://localhost:3307/driver_tracker";

		// Database name to access
		final String USER = "root";
		final String PASS = "root";

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(URL, USER, PASS);
		return con;
	}
}
