

package com.movieapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.movieapp.exceptions.IdNotFoundException;
import com.movieapp.exceptions.MovieNotFoundException;
import com.movieapp.model.Movie;
import com.movieapp.util.AllQueries;

public class MovieDaoImpl implements IMovieDao {
	public static Connection connection = null;
	PreparedStatement preparedStatement=null;
	

	@Override
	public void addMovie(Movie movie) {
		connection = ConnectionUtil.openConnection();
		try {
			preparedStatement = connection.prepareStatement(AllQueries.INSERTQUERY);
			preparedStatement.setString(1,movie.getMovieName());
			preparedStatement.setString(2, movie.getGenre());
			preparedStatement.setString(3,movie.getLanguage());
			preparedStatement.setString(4,movie.getType());
			preparedStatement.setInt(5, movie.getYearOfRelease());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(preparedStatement!=null)
					preparedStatement.close();
				
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			ConnectionUtil.closeConnection();
		}
		
	}

	@Override
	public void deleteMovie(int movieId) {
		connection = ConnectionUtil.openConnection();
		try {
			preparedStatement = connection.prepareStatement(AllQueries.DELETEQUERY);
			preparedStatement.setInt(1, movieId);
			preparedStatement.execute();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(preparedStatement!=null)
					preparedStatement.close();
				
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			ConnectionUtil.closeConnection();
		}
		
	}

	@Override
	public void updateMovie(int movieId, String language) {
		connection = ConnectionUtil.openConnection();
		try {
			preparedStatement = connection.prepareStatement(AllQueries.UPDATEQUERY);
			preparedStatement.setInt(1, movieId);
			preparedStatement.setString(2, language);
			preparedStatement.execute();
		} catch (SQLException e) {
			System.out.println();
		}finally {
			try {
				if(preparedStatement!=null)
					preparedStatement.close();
				
			} catch (Exception e2) {
				// TODO: handle exception
			}
			ConnectionUtil.closeConnection();
		}
		
		
	}

	@Override
	public Movie findById(int movieId) throws IdNotFoundException {
		connection = ConnectionUtil.openConnection();
		Movie movie = null;
		try {
			preparedStatement = connection.prepareStatement(AllQueries.IDQUERY);
			preparedStatement.setInt(1, movieId);
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()) {
				String movieName = rs.getString("movieName");
				String genre = rs.getString("genre");
				String language = rs.getString("language");
				String type = rs.getString("type");
				int year = rs.getInt("year");
				movie = new Movie(movieId, movieName, genre, language, type, year);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(preparedStatement!=null)
					preparedStatement.close();
				
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			ConnectionUtil.closeConnection();
		}
		return movie;
	}

	@Override
	public Movie findByName(String movieName) throws MovieNotFoundException {
		connection = ConnectionUtil.openConnection();
		Movie movie = null;
		try {
			preparedStatement = connection.prepareStatement(AllQueries.NAMEQUERY);
			preparedStatement.setString(1, movieName);
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()) {
				int movieId = rs.getInt("movieId");
				String genre = rs.getString("genre");
				String language = rs.getString("language");
				String type = rs.getString("type");
				int year = rs.getInt("year");
				movie = new Movie(movieId, movieName, genre, language, type, year);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(preparedStatement!=null)
					preparedStatement.close();
				
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			ConnectionUtil.closeConnection();
		}
		return movie;
	}

	@Override
	public List<Movie> findByGenre(String genre) throws MovieNotFoundException {
		connection = ConnectionUtil.openConnection();
		List<Movie> movies = new ArrayList<>();
		try {
			preparedStatement = connection.prepareStatement(AllQueries.GENREQUERY);
			preparedStatement.setString(1, genre);
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()) {
				int movieId = rs.getInt("movieId");
				String movieName = rs.getString("movieName");
				String language = rs.getString("language");
				String type = rs.getString("type");
				int year = rs.getInt("year");
				Movie movie = new Movie(movieId, movieName, genre, language, type, year);
				movies.add(movie);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(preparedStatement!=null)
					preparedStatement.close();
				
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			ConnectionUtil.closeConnection();
		}
		return movies;
	}

	@Override
	public List<Movie> findByLanguage(String language) throws MovieNotFoundException {
		connection = ConnectionUtil.openConnection();
		List<Movie> movies = new ArrayList<>();
		try {
			preparedStatement = connection.prepareStatement(AllQueries.LANGUAGEQUERY);
			preparedStatement.setString(1, language);
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()) {
				int movieId = rs.getInt("movieId");
				String movieName = rs.getString("movieName");
				String genre = rs.getString("genre");
				String type = rs.getString("type");
				int year = rs.getInt("year");
				Movie movie = new Movie(movieId, movieName, genre, language, type, year);
				movies.add(movie);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(preparedStatement!=null)
					preparedStatement.close();
				
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			ConnectionUtil.closeConnection();
		}
		return movies;
	}

	@Override
	public List<Movie> findByYear(int year) throws MovieNotFoundException {
		connection = ConnectionUtil.openConnection();
		List<Movie> movies = new ArrayList<>();
		try {
			preparedStatement = connection.prepareStatement(AllQueries.YEARQUERY);
			preparedStatement.setInt(1, year);
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()) {
				int movieId = rs.getInt("movieId");
				String movieName = rs.getString("movieName");
				String genre = rs.getString("genre");
				String language = rs.getString("language");
				String type = rs.getString("type");
				Movie movie = new Movie(movieId, movieName, genre, language, type, year);
				movies.add(movie);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(preparedStatement!=null)
					preparedStatement.close();
				
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			ConnectionUtil.closeConnection();
		}
		return movies;
	}

	@Override
	public List<Movie> findAllMovies() {
		connection = ConnectionUtil.openConnection();
		List<Movie> movies = new ArrayList<>();
		try {
			preparedStatement = connection.prepareStatement(AllQueries.SELECTQUERY);
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()) {
				int movieId = rs.getInt("movieId");
				String movieName = rs.getString("movieName");
				String genre = rs.getString("genre");
				String language = rs.getString("language");
				String type = rs.getString("type");
				int year = rs.getInt("year");
				Movie movie = new Movie(movieId, movieName, genre, language, type, year);
				movies.add(movie);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(preparedStatement!=null)
					preparedStatement.close();
				
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			ConnectionUtil.closeConnection();
		}
		return movies;
	}

}
