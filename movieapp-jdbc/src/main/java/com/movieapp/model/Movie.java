package com.movieapp.model;

import lombok.*;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Movie {
    private Integer movieId;
    private  String name;
    private Genre genre;
    private String type;
    private  String language;
    private int year;
    private String format;
    private double price;

    public Movie(String name, Genre genre, String type, String language, int year, String format, double price) {
        this.name = name;
        this.genre = genre;
        this.type = type;
        this.language = language;
        this.year = year;
        this.format = format;
        this.price = price;
    }
}
