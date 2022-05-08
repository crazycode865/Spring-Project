package com.movieapp.repository;

import com.movieapp.exception.MovieNotFoundException;
import com.movieapp.model.Genre;
import com.movieapp.model.Movie;
import com.movieapp.util.Queries;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class MovieRepositoryImpl implements  IMovieRepository{
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Override
    public void addMovie(Movie movie) {
        Object[] movieArray = {movie.getName(),movie.getGenre().name(),movie.getType(),movie.getLanguage(),movie.getYear(),movie.getFormat(),movie.getPrice()};
        jdbcTemplate.update(Queries.INSERTQUERY,movieArray);
    }

    @Override
    public void deleteMovie(int movieId) {
        jdbcTemplate.update(Queries.DELETEQUERY,movieId);
    }

    @Override
    public void updateMovie(int movieId, int price) {
        jdbcTemplate.update(Queries.UPDATEQUERY,price,movieId);
    }

    @Override
    public Movie findById(int movieId) {
        return jdbcTemplate.queryForObject(Queries.IDQUERY,new MovieMapper(),movieId);
    }

    @Override
    public Movie findByName(String name) {
        return jdbcTemplate.queryForObject(Queries.NAMEQUERY,new MovieMapper(),name);
    }

    @Override
    public List<Movie> findByGenre(String genre) {
        return jdbcTemplate.query(Queries.GENREQUERY,new MovieMapper(),genre);
    }

    @Override
    public List<Movie> findByLanguage(String language) {
        return jdbcTemplate.query(Queries.LANGUAGEQUERY,new MovieMapper(),language);
    }

    @Override
    public List<Movie> findByYear(int year) {
        return jdbcTemplate.query(Queries.YEARQUERY,new MovieMapper(),year);
    }

    @Override
    public List<Movie> findByType(String type) {
        return jdbcTemplate.query(Queries.TYPEQUERY,new MovieMapper(),type);
    }

    @Override
    public List<Movie> findByFormat(String format) {
        return jdbcTemplate.query(Queries.FORMATQUERY,new MovieMapper(),format);
    }

    @Override
    public List<Movie> findByPrice(double price) {
        return jdbcTemplate.query(Queries.PRICEQUERY,new MovieMapper(),price);
    }
}
