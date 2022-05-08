package com.bookapp.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.bookapp.exception.BookNotFoundException;
import com.bookapp.model.Book;

public class OrderDetails {
	IBookService bookService;
	
	
	public void setBookService(IBookService bookService) {
		this.bookService = bookService;

	}
	public List<Book> findByAuthor(String author) throws BookNotFoundException{
		System.out.println("in orderdetails");
		List<Book> books = bookService.getByAuthor(author);
		if(books!=null) {
			if(books.isEmpty())
				throw new BookNotFoundException("Author not Found");
			return books.stream().sorted(Comparator.comparing(Book::getTitle)).collect(Collectors.toList());
		}else
			return null;
	}
	public String orderBook(int bookId) {
		try {
		Book book = bookService.getById(bookId);
        if(book!=null)
        	return "Ordered Successfully";
        else
        	return "Book not ordered";
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return "Technical Issue";
	}
	public String addBook(Book book) {
		if(book==null)
			return "Book not Added";
		else {
			bookService.addBook(book);
			return "Book Added";
		}
	}


}
