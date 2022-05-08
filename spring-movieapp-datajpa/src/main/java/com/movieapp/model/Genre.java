package com.movieapp.model;

public enum Genre {
    ACTION("Action"),DRAMA("Drama"),COMEDY("Comedy"),THRILLER("Thriller"),FAMILY("Family");

    public final String type;

    Genre(String type) {
        this.type = type;
    }
}
