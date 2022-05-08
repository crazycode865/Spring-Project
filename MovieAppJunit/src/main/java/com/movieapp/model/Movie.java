package com.movieapp.model;

public class Movie {
	int movieId;
	String movieName;
	String genre;
	String language;
	String type;
	int yearOfRelease;
	public Movie() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Movie(String movieName, String genre, String language, String type, int yearOfRelease) {
		super();
		this.movieName = movieName;
		this.genre = genre;
		this.language = language;
		this.type = type;
		this.yearOfRelease = yearOfRelease;
	}

	public Movie(int movieId, String movieName, String genre, String language, String type, int yearOfRelease) {
		super();
		this.movieId = movieId;
		this.movieName = movieName;
		this.genre = genre;
		this.language = language;
		this.type = type;
		this.yearOfRelease = yearOfRelease;
	}

	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getYearOfRelease() {
		return yearOfRelease;
	}

	public void setYearOfRelease(int yearOfRelease) {
		this.yearOfRelease = yearOfRelease;
	}

	@Override
	public String toString() {
		return "Movie [movieId=" + movieId + ", movieName=" + movieName + ", genre=" + genre + ", language=" + language
				+ ", type=" + type + ", yearOfRelease=" + yearOfRelease + "]";
	}
	

}
