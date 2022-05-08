package com.movieapp.model;

public enum Genre {
    ACTION("Action"),THRILLER("Thriller"),ROMANCE("Romance"),
    COMEDY("Comedy"),ADVENTURE("Adventure"),DRAMA("Drama"),FAMILY("Family"),CRIME("Crime");
    public final String type;

    Genre(String type) {
        this.type = type;
    }
}
