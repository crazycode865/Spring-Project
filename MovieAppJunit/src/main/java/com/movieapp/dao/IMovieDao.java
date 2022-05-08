package com.movieapp.dao;

import java.util.List;

import com.movieapp.exceptions.IdNotFoundException;
import com.movieapp.exceptions.MovieNotFoundException;
import com.movieapp.model.Movie;

public interface IMovieDao {
	//Admin
	void addMovie(Movie movie);
	void deleteMovie(int movieId);
	void updateMovie(int movieId,String language);
	Movie findById(int movieId)throws IdNotFoundException;
	
	//User
	List<Movie> findAllMovies();
	Movie findByName(String movieName)throws MovieNotFoundException;
	List<Movie> findByGenre(String genre)throws MovieNotFoundException;
	List<Movie> findByLanguage(String language)throws MovieNotFoundException;
	List<Movie> findByYear(int year)throws MovieNotFoundException;
	
	

}
