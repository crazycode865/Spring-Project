package com.movieapp.repository;

import com.movieapp.model.Movie;

import java.util.List;

public interface IMovieRepository {
    public void addMovie(Movie movie);
    public void  deleteMovie(int movieId);
    public void  updateMovie(int movieId,int price);
    Movie findById(int movieId) ;
    Movie findByName(String name) ;
    List<Movie> findByGenre(String genre)  ;
    List<Movie> findByLanguage(String language)  ;
    List<Movie> findByYear(int year)  ;
    List<Movie> findByType(String type)  ;
    List<Movie> findByFormat(String format) ;
    List<Movie> findByPrice(double price);
}
