package com.movieapp.service;

import java.util.List;

import com.movieapp.exceptions.IdNotFoundException;
import com.movieapp.exceptions.MovieNotFoundException;
import com.movieapp.model.Movie;

public interface IMovieService {
	//Admin
		void addMovie(Movie movie);
		void deleteMovie(int movieId);
		void updateMovie(int movieId,String language);
		Movie getById(int movieId)throws IdNotFoundException;
		
		//User
		List<Movie> getAllMovies();
		Movie getByName(String movieName)throws MovieNotFoundException;
		List<Movie> getByGenre(String genre)throws MovieNotFoundException;
		List<Movie> getByLanguage(String language)throws MovieNotFoundException;
		List<Movie> getByYear(int year)throws MovieNotFoundException;

}
