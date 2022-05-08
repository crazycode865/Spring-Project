package com.movieapp.model;

import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Movie {
    @Id
    @GeneratedValue(generator = "movie_gen",strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "movie_gen",sequenceName = "movie_seq",initialValue = 100,allocationSize = 2)
    private Integer movieId;
    @Column(length = 20)
    private  String name;
    @Enumerated(EnumType.STRING)
    private Genre genre;
    @Enumerated(EnumType.STRING)
    private Type type;
    @Column(length = 20)
    private  String language;
    private int year;
    @Enumerated(EnumType.STRING)
    private Format format;
    private double price;


    public Movie(String name, Genre genre, Type type, String language, int year, Format format, double price) {
        this.name = name;
        this.genre = genre;
        this.type = type;
        this.language = language;
        this.year = year;
        this.format = format;
        this.price = price;
    }
}
