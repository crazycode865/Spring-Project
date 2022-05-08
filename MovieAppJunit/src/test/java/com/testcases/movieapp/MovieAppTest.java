package com.testcases.movieapp;

//import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import com.movieapp.exceptions.IdNotFoundException;
import com.movieapp.exceptions.MovieNotFoundException;
import com.movieapp.model.Movie;
import com.movieapp.service.IMovieService;
import com.movieapp.service.MovieServiceImpl;
@RunWith(JUnitPlatform.class)
//@ExtendWith(MockitoExtension.class)
class MovieAppTest {
	IMovieService movieService =null;
   
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}
	
	List<Movie> movies;
	@BeforeEach
	void setUp() throws Exception {
		movieService = new MovieServiceImpl();
		        movies =Arrays.asList(new Movie(3,"Pushpa","Action","Telugu","TollyWood",2022),
				new Movie(4,"RRR","Action","Telugu","TollyWood",2022));
//				new Movie(1,"Pushpa","Action","Telugu","Tollywood",2022),
//				new Movie(1,"Pushpa","Action","Telugu","Tollywood",2022));
	}

	@AfterEach
	void tearDown() throws Exception {
		movieService = null;
	}

//	@Test
//	@DisplayName("Testing Add Movie")
//	void testAddMovie() {
//		
//		
//	}

	@Test
	@DisplayName("Testing By id")
	void testFindById() throws IdNotFoundException {
		int movieId = 3;
		Movie movie = movieService.getById(movieId);
		assertEquals("Pushpa", movie.getMovieName());
	}
	@Test
	@DisplayName("Testing By Id Null")
	void testFindByIdNull() {
		int movieId= 789;
		 
		assertThrows(IdNotFoundException.class,()-> movieService.getById(movieId));
	}

	@Test
	@DisplayName("Testing By name")
	void testFindByName() throws MovieNotFoundException {
		String movieName = "3-Idiot";
		Movie movie = movieService.getByName(movieName);
		assertEquals(movieName,movie.getMovieName());
	}

	@Test
	@DisplayName("Testing By name Null")
	void testByNameNull() {
		String movieName = "xyz";
		assertThrows(MovieNotFoundException.class,()->movieService.getByName(movieName));
	}
	@Test
	@DisplayName("Testing By Genre")
	void testFindByGenre() throws MovieNotFoundException  {
		String genre = "Action";
		assertEquals(movies.toString(),movieService.getByGenre(genre).toString());
		
		
	}
	@Test
	@DisplayName("Testing By Genre Null")
	void testFindByGenreNull()  {
		String genre = "dfghjk";
		assertThrows(MovieNotFoundException.class,()->movieService.getByGenre(genre));
		
	}

	@Test
	@DisplayName("Testing By language")
	void testFindByLanguage() throws MovieNotFoundException {
		String langauage = "Telugu";
		assertEquals(movies.toString(),movieService.getByLanguage(langauage).toString());
		
	}
	@Test
	@DisplayName("Testing By language Null")
	void testFindByLanguageNull() throws MovieNotFoundException {
		String langauage = "Japnese";
		assertThrows(MovieNotFoundException.class,()->movieService.getByLanguage(langauage));
		
	}

}
