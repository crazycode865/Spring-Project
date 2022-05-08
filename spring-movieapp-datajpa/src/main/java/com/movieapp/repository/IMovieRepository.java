package com.movieapp.repository;

import com.movieapp.model.Format;
import com.movieapp.model.Genre;
import com.movieapp.model.Movie;
import com.movieapp.model.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface IMovieRepository extends JpaRepository<Movie,Integer> {

    Movie findByName(String name);
    List<Movie> findByGenre(Genre genre);
    List<Movie> findByLanguage(String language);
    List<Movie> findByType(Type type);
    List<Movie> findByYear(int year);
    List<Movie> findByFormat(Format format);
    List<Movie> findByPrice(double price);



}
