package com.bookapp.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.bookapp.exception.AuthorNotFoundException;
import com.bookapp.exception.BookNotFoundException;
import com.bookapp.exception.CategoryNotFoundException;
import com.bookapp.exception.IdNotFoundException;
import com.bookapp.model.Book;

//This Layer interact with the Database 
public class BookDaoImpl implements IBookDao {

	private Connection connection = null;


	//String createQuery  = "create table book(booId integer,title varchar(20),author varchar(20),category varchar(20),price integer)";
	String selectQuery = "Select * from book"; 
	String insertQuery = "insert into book value(?,?,?,?,?)";
	String deleteQuery = "delete from book where bookId=?";
	String updateQuery = "update book set price=? where bookId=?";

	String AUTHORQUERY = "Select * from book where author=?";
	String CATQUERY = "Select * from book where category=?";
	String IDQUERY = "Select * from book where bookId =?";


	//Addition of Books
	@Override
	public void addBook(Book book) {
		//Open Connection
		connection = ConnectionUtil.openConnection();
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		int set=0;
		try {
			preparedStatement = connection.prepareStatement(insertQuery);
			preparedStatement.setInt(1, book.getBookId());
			preparedStatement.setString(2, book.getTitle());
			preparedStatement.setString(3, book.getAuthor());
			preparedStatement.setString(4,book.getCategory());
			preparedStatement.setDouble(5,book.getPrice());

			set = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(preparedStatement!=null)
					preparedStatement.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

		}
		if(set>0)
			System.out.println("Book added ...Successfully");	
	}

	//Deletion of Books
	@Override
	public void deleteBook(int bookId) {
		connection = ConnectionUtil.openConnection();
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		int set=0;
		try {
			preparedStatement  = connection.prepareStatement(deleteQuery);
			preparedStatement.setInt(1,bookId);
			set = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(preparedStatement!=null)
					preparedStatement.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

		}
		if(set>0)
			System.out.println("Book Deleted successfully");


	}
	// Update the details of the Books
	@Override
	public void updateBook(int bookId, double price) throws BookNotFoundException {
		connection = ConnectionUtil.openConnection();
		PreparedStatement preparedStatement=null;

		int set=0;
		try {
			preparedStatement  = connection.prepareStatement(updateQuery);
			preparedStatement.setDouble(1,price);
			preparedStatement.setInt(2,bookId);
			set = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(preparedStatement!=null)
					preparedStatement.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

		}

		if(set>0)
			System.out.println("Book Updated successfully successfully");


	}

	// Get Book By id
	@Override
	public Book findBookById(int bookId) throws IdNotFoundException {
		connection = ConnectionUtil.openConnection();
		Book book =null;
		try {
			PreparedStatement preparedStatement=connection.prepareStatement(IDQUERY);
			preparedStatement.setInt(1, bookId);
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				String title  = resultSet.getString("title");
				String author = resultSet.getString("author");
				String category = resultSet.getString("category");
				double price = resultSet.getDouble("price");
				book = new Book(bookId,title,author,category,price);
				return book;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;

	}

	// Get all Books
	@Override
	public List<Book> findAllBooks() {
		connection = ConnectionUtil.openConnection();
		PreparedStatement preparedStatement=null;
		List<Book> bookList = new ArrayList<>();

		try {
			preparedStatement = connection.prepareStatement(selectQuery);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				int bookId = resultSet.getInt("bookId");
				String title  = resultSet.getString("title");
				String author = resultSet.getString("author");
				String category = resultSet.getString("category");
				double price = resultSet.getDouble("price");
				Book book = new Book(bookId,title,author,category,price);
				bookList.add(book);	
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return bookList;
	}

	// Get Books By Author
	@Override
	public List<Book> findBookByAuthor(String author) throws AuthorNotFoundException {
		connection = ConnectionUtil.openConnection();
		Book book =null;
		List<Book>bookByAuthor = new ArrayList<>();
		try {
			PreparedStatement preparedStatement=connection.prepareStatement(AUTHORQUERY);
			preparedStatement.setString(1, author);
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				int bookId = resultSet.getInt("bookId");
				String title  = resultSet.getString("title");
				String category = resultSet.getString("category");
				double price = resultSet.getDouble("price");
				book = new Book(bookId,title,author,category,price);
				bookByAuthor.add(book);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return bookByAuthor;

	}

	// Get Books By category
	@Override
	public List<Book> findBookByCategory(String category) throws CategoryNotFoundException {
		connection = ConnectionUtil.openConnection();
		List<Book> bookByCategory=  new ArrayList<>();
		try {
			PreparedStatement preparedStatement=connection.prepareStatement(CATQUERY);
			preparedStatement.setString(1, category);
			ResultSet resultSet=preparedStatement.executeQuery();
			Book book =null;


			while(resultSet.next()) {
				int bookId = resultSet.getInt("bookId");
				String title  = resultSet.getString("title");
				String author  = resultSet.getString("author");
				double price = resultSet.getDouble("price");
				book = new Book(bookId,title,author,category,price);
				bookByCategory.add(book);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return bookByCategory;
	}


}
