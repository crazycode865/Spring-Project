package com.bookapp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
//This class is used to Establish and Closing Connection with the Database
public class ConnectionUtil {
	static Connection connection;
	public static final String URL="jdbc:mysql://localhost:3306/dbtraining";
	public static final String USERNAME = "root";
	public static final String PASSWORD = "root";
	
	//Open Connection method
	public static Connection openConnection() {
		try {
			connection = DriverManager.getConnection(URL,USERNAME , PASSWORD);
		} catch (SQLException e) {
			
			System.out.println(e.getMessage());
		} 
		return connection;
	}
	
	//Closing the connection with the database
	public static void closeConnection() {
		try {
			if(connection!=null)
			connection.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

}
