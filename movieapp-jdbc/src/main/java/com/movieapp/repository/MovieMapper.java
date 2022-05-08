package com.movieapp.repository;

import com.movieapp.model.Format;
import com.movieapp.model.Genre;
import com.movieapp.model.Movie;
import com.movieapp.model.Type;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MovieMapper implements RowMapper<Movie> {
    @Override
    public Movie mapRow(ResultSet rs, int rowNum) throws SQLException {
        Movie movie = new Movie();
        movie.setMovieId(rs.getInt("movie_id"));
        movie.setName(rs.getString("name"));
        movie.setGenre(Genre.valueOf(rs.getString("genre")));
        movie.setLanguage(rs.getString("language"));
        movie.setType((rs.getString("type")));
        movie.setYear(rs.getInt("year"));
       movie.setFormat(rs.getString("format"));
       movie.setPrice(rs.getDouble("price"));
        return movie;
    }
}
