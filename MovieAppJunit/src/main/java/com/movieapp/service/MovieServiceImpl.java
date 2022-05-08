package com.movieapp.service;

import java.util.List;
import java.util.stream.Collectors;

import com.movieapp.dao.IMovieDao;
import com.movieapp.dao.MovieDaoImpl;
import com.movieapp.exceptions.IdNotFoundException;
import com.movieapp.exceptions.MovieNotFoundException;
import com.movieapp.model.Movie;

public class MovieServiceImpl implements IMovieService {
	private  IMovieDao movieDao = new MovieDaoImpl();

	@Override
	public void addMovie(Movie movie) {
		movieDao.addMovie(movie);
		
	}

	@Override
	public void deleteMovie(int movieId) {
		movieDao.deleteMovie(movieId);
		
	}

	@Override
	public void updateMovie(int movieId, String language) {
		movieDao.updateMovie(movieId, language);
		
	}

	@Override
	public Movie getById(int movieId) throws IdNotFoundException {
		Movie movie = movieDao.findById(movieId);
		if(movie==null)
			throw new IdNotFoundException("Invalid ID");
		return movie;
	}

	@Override
	public List<Movie> getAllMovies() {
		List<Movie> movies = movieDao.findAllMovies();
		return movies.stream().sorted((movie1,movie2)->movie1.getMovieName().compareTo(movie2.getMovieName()))
				.collect(Collectors.toList());
	}

	@Override
	public Movie getByName(String movieName) throws MovieNotFoundException {
		Movie movie = movieDao.findByName(movieName);
		if(movie==null)
			throw new MovieNotFoundException("Movie not Found...");
		return movie;
		
	}

	@Override
	public List<Movie> getByGenre(String genre) throws MovieNotFoundException {
		List<Movie> movies = movieDao.findByGenre(genre);
		if(movies.isEmpty())
			throw new MovieNotFoundException("Movie Genre not Found");
		return movies.stream().sorted((movie1,movie2)->movie1.getMovieName().compareTo(movie2.getMovieName()))
				.collect(Collectors.toList());
	}

	@Override
	public List<Movie> getByLanguage(String language) throws MovieNotFoundException {
		List<Movie> movies = movieDao.findByLanguage(language);
		if(movies.isEmpty())
			throw new MovieNotFoundException("Movie Langauge not Found");
		return movies.stream().sorted((movie1,movie2)->movie1.getMovieName().compareTo(movie2.getMovieName()))
				.collect(Collectors.toList());
	}

	@Override
	public List<Movie> getByYear(int year) throws MovieNotFoundException {
		List<Movie> movies = movieDao.findByYear(year);
		return movies.stream().sorted((movie1,movie2)->movie1.getMovieName().compareTo(movie2.getMovieName()))
				.collect(Collectors.toList());
	}

	

}
