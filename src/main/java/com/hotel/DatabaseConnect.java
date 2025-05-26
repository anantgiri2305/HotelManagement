package com.hotel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnect {
	private static final String URL = "jdbc:mysql://localhost:3306/hotel";
	private static final String USER = "root";
	private static final String PASSWORD = "123456789";

	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // Register driver
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("JDBC Driver not found", e);
		}
	}

	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(URL, USER, PASSWORD);
	}
}
