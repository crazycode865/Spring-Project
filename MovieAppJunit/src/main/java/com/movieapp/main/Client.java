package com.movieapp.main;

import java.util.List;
import java.util.Scanner;

import com.movieapp.exceptions.IdNotFoundException;
import com.movieapp.exceptions.MovieNotFoundException;
import com.movieapp.model.Movie;
import com.movieapp.service.BookTicketServiceImpl;
import com.movieapp.service.IBookTicketService;
import com.movieapp.service.IMovieService;
import com.movieapp.service.MovieServiceImpl;

public class Client {
	public static void adminMenu() {
		System.out.println("Choose Admin Operation");
		System.out.println("1.Add Movie");
		System.out.println("2.Delete Movie");
		System.out.println("3.Update Movie");
		System.out.println("4.Get Movie By Id");
	}
	public static void userMenu() {
		System.out.println("Choose User Operation");
		System.out.println("1.Get All Movie");
		System.out.println("2.Get Movie By Name");
		System.out.println("3.Get Movie By Genre");
		System.out.println("4.Get Movie By Language");
		System.out.println("5.Get Movie By Year");
		System.out.println("6.Book Movie Tickets");
	}
	public static void main(String[] args) throws MovieNotFoundException, IdNotFoundException {
		System.out.println("------------Welcome to Movie Application-----------");
		Scanner scanner  = new Scanner(System.in);
		Movie movie = null;
		IMovieService movieService =new MovieServiceImpl();
		
		String choice=null;
		do {
			System.out.println("Select the Role");
			System.out.println("1.Admin");
			System.out.println("2.User");
			int role = scanner.nextInt();
			
			if(role==1) {
				adminMenu();
				int operation = scanner.nextInt();
				
				switch(operation) {
				case 1:
					System.out.println("Enter movie Name");
					String name = scanner.next();
//					scanner.next();
					System.out.println("Enter movie Genre");
					String genre = scanner.next();
//					scanner.next();
					System.out.println("Enter movie Language");
					String language = scanner.next();
//					scanner.next();
					System.out.println("Enter movie Type");
					String type = scanner.next();
//					scanner.next();
					System.out.println("Enter movie Year of Release");
					int year = scanner.nextInt();
					movie = new Movie(name, genre, language, type, year);
					movieService.addMovie(movie);
					break;
				case 2:
					System.out.println("Enter movie Id");
					int movieId = scanner.nextInt();
					movieService.deleteMovie(movieId);
					break;
				case 3:
					System.out.println("Enter movie Id");
					int movieId1 = scanner.nextInt();
					System.out.println("Enter Language");
					String language1 = scanner.next();
					movieService.updateMovie(movieId1, language1);
					break;
				case 4:
					System.out.println("Enter Movie Id");
					int movieId2 = scanner.nextInt();
					System.out.println(movieService.getById(movieId2));
					break;
					default:
						System.out.println("Invalid Operation...");
						break;
					
				}
			}else {
				userMenu();
				int operation  = scanner.nextInt();
				switch(operation) {
				case 1:
					List<Movie> movies = movieService.getAllMovies();
					for(Movie movie1:movies) 
						System.out.println(movie1);
					break;
				case 2:
					System.out.println("Enter Movie name");
					String name = scanner.next();
					System.out.println(movieService.getByName(name));
				    break;
				case 3:
					System.out.println("Enter Genre");
					String genre = scanner.next();
					List<Movie>movieByGenre = movieService.getByGenre(genre);
					for(Movie movie1:movieByGenre)
						System.out.println(movie1);
					break;
				case 4:
					System.out.println("Enter Language");
					String language = scanner.next();
					List<Movie>movieByLanguage = movieService.getByLanguage(language);
					for(Movie movie1:movieByLanguage)
						System.out.println(movie1);
					break;
				case 5:
					System.out.println("Enter Release Year");
					int year = scanner.nextInt();
					List<Movie>movieByYear = movieService.getByYear(year);
					for(Movie movie1:movieByYear)
						System.out.println(movie1);
					break;
				case 6:
					System.out.println("Book Ticket");
					System.out.println("Enter Movie Id");
					int movieId = scanner.nextInt();
					System.out.println("Enter numberOfTickets");
					int numberOfTickets = scanner.nextInt();
					System.out.println("Enter Screen Type");
					String type = scanner.next();
					IBookTicketService bookTickets = new BookTicketServiceImpl();
					bookTickets.bookTicket(movieId, numberOfTickets,type);
					break;
					default:
						System.out.println("Invalid Operation...");
						break;
					
				}
			}
			System.out.println("Do you want to Continue...YES/NO");
			choice = scanner.next();
			
		}while(choice.equalsIgnoreCase("YES"));
		System.out.println("Thank you for Using Movie Application");
		
	scanner.close();	
}
}
