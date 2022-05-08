package com.movieapp;

import com.movieapp.model.Format;
import com.movieapp.model.Genre;
import com.movieapp.model.Movie;
import com.movieapp.model.Type;
import com.movieapp.service.IMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.swing.plaf.basic.BasicComboBoxUI;

@SpringBootApplication
public class MovieappJdbcApplication implements CommandLineRunner {

    public static void main(String[] args) {

        SpringApplication.run(MovieappJdbcApplication.class, args);
    }

    @Autowired
    IMovieService iMovieService;

    @Override
    public void run(String... args) throws Exception {
       // String name, Genre genre, String type, String language, int year, String format
        Movie movie = new Movie("Iron man", Genre.ADVENTURE,Type.HOLLYWOOD.type,"English",2022, Format.IMAXSCREENX.type, 234);
        Movie movie1 = new Movie("3-Idiot", Genre.COMEDY,Type.BOLLYWOOD.type, "Hindi",2013, Format.TWOD.type, 987);
        Movie movie2 = new Movie("Wanted", Genre.FAMILY,Type.BOLLYWOOD.type, "Hindi",2015, Format.TWOD.type, 765);
        Movie movie3 = new Movie("Bahubali", Genre.DRAMA,Type.TOLLYWOOD.type, "Telugu",2015, Format.THREED.type, 456);
        //iMovieService.addMovie(movie);
        iMovieService.getByYear(2015).forEach(System.out::println);
        iMovieService.getByFormat(Format.TWOD.type).forEach(System.out::println);
        iMovieService.getByPrice(765).forEach(System.out::println);
        //iMovieService.deleteMovie(5);
        iMovieService.getByType(Type.HOLLYWOOD.type).forEach(System.out::println);
        iMovieService.updateMovie(4,1000);
        System.out.println(iMovieService.getByName("3-Idiot"));


    }
}
