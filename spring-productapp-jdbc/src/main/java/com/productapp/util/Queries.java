package com.productapp.util;

public class Queries {
    public static  final  String INSERTQUERY = "insert into product(name,brand,category,price,expirydate) values(?,?,?,?,?)";
    public  static  final  String DELETEQUERY = "delete from product where productId=?";
    public  static  final  String UPDATEQUERY = "update product set price=? where productId=?";
    public  static  final  String  SELECTQUERY= "Select * from product";
    public  static  final  String BRANDQUERY = "Select * from product where brand =?";
    public  static  final  String CATEGORYQUERY = "Select * from product where category=?";
    public  static  final  String PRICEQUERY = "Select * from product where price <?";
    public static  final  String DATEQUERY = "Select * from product where expirydate=?";
    public static  final  String BRANDSTARTINGQUERY = "Select * from product where brand like ?";
    public  static  final  String IDQUERY = "Select * from product where productId=?";
//    public  static  final  String DATEQUERY="Select * from product where expirydate=?";
}
