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

@SpringBootApplication
public class SpringMovieappDatajpaApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SpringMovieappDatajpaApplication.class, args);
    }

    @Autowired
    IMovieService iMovieService;

    @Override
    public void run(String... args) throws Exception {
        //String name, Genre genre, Type type, String language, int year, Format format, double price
        Movie movie = new Movie("Pushpa", Genre.ACTION, Type.TOLLYWOOD, "Telugu", 2022, Format.TWOD, 543);
        Movie movie1 = new Movie("RRR", Genre.FAMILY, Type.TOLLYWOOD, "Hindi", 2020, Format.THREED, 234);
        Movie movie2 = new Movie("Sholay", Genre.DRAMA, Type.BOLLYWOOD, "Hindi", 1975, Format.TWOD, 1000);
        Movie movie3 = new Movie("Captain America", Genre.ACTION, Type.HOLLYWOOD, "English", 2015, Format.IMAX, 765);
        Movie movie4 = new Movie("The Hulk", Genre.THRILLER, Type.HOLLYWOOD, "English", 2010, Format.SCREENX, 1234);
        Movie movie5 = new Movie("Theri", Genre.THRILLER, Type.TOLLYWOOD, "Tamil", 2016, Format.THREED, 780);
       // iMovieService.addMovie(movie5);
        //iMovieService.deleteMovie(111);
        iMovieService.getByPrice(780).forEach(System.out::println);
        iMovieService.getByLanguage("Hindi").forEach(System.out::println);
        System.out.println(iMovieService.findByName("Pushpa"));
        //iMovieService.getByFormat(Format.THREED).forEach(System.out::println);
        iMovieService.getByGenre(Genre.ACTION).forEach(System.out::println);
        iMovieService.getByType(Type.HOLLYWOOD).forEach(System.out::println);
    }
}
