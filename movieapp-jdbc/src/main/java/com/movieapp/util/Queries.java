package com.movieapp.util;

public class Queries {

    public static final String INSERTQUERY = "INSERT INTO movie_jdbc(name,genre,type,language,year,format,price) VALUES(?,?,?,?,?,?,?)";
    public static final String UPDATEQUERY = "UPDATE movie_jdbc SET price=? WHERE movie_id=?";
    public static final String DELETEQUERY = "DELETE FROM movie_jdbc  WHERE movie_id=?";
    public static final String SELECTQUERY = "SELECT * FROM movie_jdbc";
    public static final String LANGUAGEQUERY = "SELECT * FROM movie_jdbc WHERE language=?";
    public static final String GENREQUERY = "SELECT * FROM movie_jdbc WHERE genre=?";
    public static final String TYPEQUERY = "SELECT * FROM movie_jdbc WHERE type=?";
    public static final String YEARQUERY = "SELECT * FROM movie_jdbc WHERE year=?";
    public static final String IDQUERY = "SELECT * FROM movie_jdbc WHERE movie_id=?";
    public  static  final String NAMEQUERY = "SELECT * from movie_jdbc WHERE name=?";
    public static final String FORMATQUERY ="Select * from movie_jdbc where format=?" ;
    public static final String PRICEQUERY ="Select * from movie_jdbc where price=?" ;
}
