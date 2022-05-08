package com.furnapp.util;

public class Queries {
    public static  final String INSERTQUERY = "insert into furniture_jdbc(name,category,roomType,material,style,brand,price,storageAvailable) values(?,?,?,?,?,?,?,?)";
    public  static  final  String UPDATEQUERY = "UPDATE furniture_jdbc SET price=? WHERE furniture_id=?";
    public static  final  String DELETEQUERY = "DELETE FROM furniture_jdbc WHERE furniture_id=?";
    public  static  final  String SELECTQUERY = "SELECT * FROM furniture_jdbc";
    public  static  final String IDQUERY = "SELECT * FROM furniture_jdbc WHERE furniture_id=?";
    public  static  final  String BYNAMEQUERY = "SELECT * FROM furniture_jdbc WHERE name=?";
    public  static  final  String CATEGORYQUERY = "SELECT * FROM furniture_jdbc WHERE category=?";
    public static  final  String  BRANDQUERY = "SELECT * FROM furniture_jdbc WHERE brand=?";
    public  static  final  String MATERIALQUERY = "SELECT * FROM furniture_jdbc WHERE material=?";
    public  static  final  String ROOMTYPEQUERY = "SELECT * FROM furniture_jdbc WHERE roomtype=?";
    public  static  final  String PRICEQUERY = "SELECT * FROM furniture_jdbc WHERE price between ? and ?";
    public  static  final  String STYLEQUERY = "SELECT * FROM furniture_jdbc WHERE style=?";
    public  static final  String AVAILABILITYQUERY = "SELECT * FROM furniture_jdbc where storageAvailable=?";



 }
