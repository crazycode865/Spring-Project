package com.movieapp.util;

public class AllQueries {
	public static final String INSERTQUERY = "insert into movie(movieName,genre,language,type,year) values(?,?,?,?,?)";
	public static final String DELETEQUERY = "delete from movie where movieId=?";
	public static final String UPDATEQUERY = "update movie where movieId=? set language=?";
	public static final String IDQUERY     = "Select * from movie where movieId=?";
	public static final String SELECTQUERY = "Select *from movie";
	public static final String LANGUAGEQUERY = "Select * from movie where language=?";
	public static final String GENREQUERY = "Select * from movie where genre=?";
	public static final String NAMEQUERY = "Select * from movie where movieName=?";
	public static final String YEARQUERY = "Select * from movie where year=?";
	
	//Query for Book Tickets
	public static final String BOOKTICKETS = "insert into booking(movieId,numberOfTickets,date,price, totalCost) values(?,?,?,?,?)" ;
	public static final String SELECTTICKETS ="Select * from booking";

}
