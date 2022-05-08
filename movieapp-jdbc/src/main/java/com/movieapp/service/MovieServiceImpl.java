package com.movieapp.service;

import com.movieapp.exception.MovieNotFoundException;
import com.movieapp.model.Genre;
import com.movieapp.model.Movie;
import com.movieapp.repository.IMovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MovieServiceImpl implements IMovieService {
    IMovieRepository iMovieRepository;
    @Autowired
    public MovieServiceImpl(IMovieRepository iMovieRepository) {
        this.iMovieRepository = iMovieRepository;
    }

    @Override
    public void addMovie(Movie movie) {
        iMovieRepository.addMovie(movie);
    }

    @Override
    public void deleteMovie(int movieId) {
        iMovieRepository.deleteMovie(movieId);
    }

    @Override
    public void updateMovie(int movieId, int price) {
        iMovieRepository.updateMovie(movieId, price);
    }

    @Override
    public Movie getById(int movieId) throws MovieNotFoundException {
        return iMovieRepository.findById(movieId);
    }

    @Override
    public Movie getByName(String name) throws MovieNotFoundException {
        return iMovieRepository.findByName(name);
    }

    @Override
    public List<Movie> getByGenre(String genre) throws MovieNotFoundException {
        return iMovieRepository.findByGenre(genre);
    }

    @Override
    public List<Movie> getByLanguage(String language) throws MovieNotFoundException {
        return iMovieRepository.findByLanguage(language);
    }

    @Override
    public List<Movie> getByYear(int year) throws MovieNotFoundException {
        return iMovieRepository.findByYear(year);
    }

    @Override
    public List<Movie> getByType(String type) throws MovieNotFoundException {
        return iMovieRepository.findByType(type);
    }

    @Override
    public List<Movie> getByFormat(String format) throws MovieNotFoundException {
        return iMovieRepository.findByFormat(format);
    }

    @Override
    public List<Movie> getByPrice(double price) throws MovieNotFoundException {
        return iMovieRepository.findByPrice(price);
    }
}
