package com.movieapp.service;

import com.movieapp.model.Format;
import com.movieapp.model.Genre;
import com.movieapp.model.Movie;
import com.movieapp.model.Type;

import java.util.List;

public interface IMovieService {
    public void addMovie(Movie movie);
    public void deleteMovie(int movieId);
    public void updateMovie(Movie movie);
    Movie findByName(String name);
    List<Movie> getByGenre(Genre genre);
    List<Movie> getByLanguage(String language);
    List<Movie> getByType(Type type);
    List<Movie> getByYear(int year);
    List<Movie> getByFormat(Format format);
    List<Movie> getByPrice(double price);
}
