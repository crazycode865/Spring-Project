package com.movieapp.service;

import com.movieapp.exception.MovieNotFoundException;
import com.movieapp.model.Movie;

import java.util.List;

public interface IMovieService {
    public void addMovie(Movie movie);
    public void  deleteMovie(int movieId);
    public void  updateMovie(int movieId,int price);
    Movie getById(int movieId)throws MovieNotFoundException;
    Movie getByName(String name)throws MovieNotFoundException;
    List<Movie> getByGenre(String genre)throws  MovieNotFoundException;
    List<Movie> getByLanguage(String language)throws  MovieNotFoundException;
    List<Movie> getByYear(int year)throws  MovieNotFoundException;
    List<Movie> getByType(String type)throws  MovieNotFoundException;
    List<Movie> getByFormat(String format)throws MovieNotFoundException;
    List<Movie> getByPrice(double price)throws  MovieNotFoundException;
}
