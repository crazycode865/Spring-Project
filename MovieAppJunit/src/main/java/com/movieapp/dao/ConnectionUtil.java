package com.movieapp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {
	private static final String URL ="jdbc:mysql://localhost:3306/dbtraining";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "root";
	
	static Connection connection=null;
	public static Connection openConnection() {
		try {
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return connection;
	}
	public static void closeConnection() {
		try {
			if(connection!=null)
				connection.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
