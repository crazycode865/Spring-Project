package com.movieapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
//import java.util.Date;
import java.sql.Date;

import com.movieapp.model.TicketType;
import com.movieapp.util.AllQueries;


public class BookTicketDaoImpl implements IBookTicketDao {
	private Connection connection = null;
	PreparedStatement preparedStatement=null;
	ResultSet resultSet=null; 

	@Override
	public void bookTicket(int movieId,int numberOfTickets, String type) {
		double price = 0;
		if(type.equals("GOLD"))
			price = TicketType.GOLD.price;
		 if(type.equals("SILVER"))
			price = TicketType.SILVER.price;
		 if(type.equals("ORDINARY"))
			price = TicketType.ORDINARY.price;
		 if(type.equals("PLATINUM"))
			 price = TicketType.PLATINUM.price;
		
			
		
		connection = ConnectionUtil.openConnection();
		try {
			
			preparedStatement = connection.prepareStatement(AllQueries.BOOKTICKETS);
			preparedStatement.setInt(1,movieId);
			preparedStatement.setInt(2,numberOfTickets);
		    LocalDate currentLocalDate = LocalDate.now();
		    Date date = Date.valueOf(currentLocalDate);
			preparedStatement.setDate(3,date);
			preparedStatement.setDouble(4, price);
			preparedStatement.setDouble(5, numberOfTickets*price);
			preparedStatement.execute();
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(preparedStatement!=null)
					preparedStatement.close();
				
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			ConnectionUtil.closeConnection();
		}
		
		System.out.println("Tickets Booked Successfully....");
		
	}

}
