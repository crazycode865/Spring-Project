package com.movieapp.service;

import com.movieapp.model.Format;
import com.movieapp.model.Genre;
import com.movieapp.model.Movie;
import com.movieapp.model.Type;
import com.movieapp.repository.IMovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MovieServiceImpl implements  IMovieService {
  @Autowired
    IMovieRepository iMovieRepository;

    @Override
    public void addMovie(Movie movie) {
        iMovieRepository.save(movie);
    }

    @Override
    public void deleteMovie(int movieId) {
        iMovieRepository.deleteById(movieId);

    }

    @Override
    public void updateMovie(Movie movie) {
        iMovieRepository.save(movie);

    }

    @Override
    public Movie findByName(String name) {
        return iMovieRepository.findByName(name);
    }

    @Override
    public List<Movie> getByGenre(Genre genre) {
        return iMovieRepository.findByGenre(genre);
    }

    @Override
    public List<Movie> getByLanguage(String language) {
        return iMovieRepository.findByLanguage(language);
    }

    @Override
    public List<Movie> getByType(Type type) {
        return iMovieRepository.findByType(type);
    }

    @Override
    public List<Movie> getByYear(int year) {
        return iMovieRepository.findByYear(year);
    }

    @Override
    public List<Movie> getByFormat(Format format) {
        return iMovieRepository.findByFormat(format);
    }

    @Override
    public List<Movie> getByPrice(double price) {
        return iMovieRepository.findByPrice(price);
    }
}
