package com.productapp.model;

public enum Category {

    COSMETICS("COSMETICS"),
    FURNITURES("RURNITURES"),
    HOME("HOME FURNISHING"),
    ELECTRONICS("ELECTRONICS"),
    TOYS("TOYS AND GAMES")
    ;

public String type;
    Category(String value){
        this.type = value;
    }
}
