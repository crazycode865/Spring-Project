package com.testcases.bookapp;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.bookapp.exception.BookNotFoundException;
import com.bookapp.model.Book;
import com.bookapp.service.IBookService;
import com.bookapp.service.OrderDetails;

@RunWith(JUnitPlatform.class)
@ExtendWith(MockitoExtension.class)
class OrderDetailsTestCase {
	@Mock
	IBookService bookService;
	@InjectMocks
	OrderDetails orderdetails;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	Book book1 ,book2,book3,book5,book4;
	@BeforeEach
	void setUp() throws Exception {
		
		 book1 = new Book(1,"Java","Kathy",900);
		 book2 = new Book(2,"Spring","james",987);
		 book3 =  new Book(3,"Hibernate","Kathy",87);
		 book4 =  new Book(4,"JSP","Robin",349);
		 book5 =  new Book(2,"python","Kathy",9787);
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	@DisplayName("Testing order")
	void testOrderBook() throws BookNotFoundException {
		int bookId = 2;
		doReturn(book2).when(bookService).getById(bookId);
		
		String actual = orderdetails.orderBook(bookId);
		assertEquals("Ordered Successfully",actual);
	}
	@Test
	@DisplayName("Testing book return as null")
	void testOrderBookNull() throws BookNotFoundException {
		int bookId = 1;
		doReturn(null).when(bookService).getById(bookId);
		String actual = orderdetails.orderBook(bookId);
		assertEquals("Book not ordered",actual);
	}
	
//	@Test
	@DisplayName("Testing book throw an Exception")
	void testOrderBookException() throws BookNotFoundException{
		int bookId = 10;
//		doThrow(new BookNotFoundException()).when(bookService).getById(bookId);
		when(bookService.getById(bookId)).thenThrow(new BookNotFoundException());
	String actual = orderdetails.orderBook(bookId);
	assertEquals("Technical Issue",actual);
		
	}
	@Test
	@DisplayName("Testing add book with void type")
	void testAddBook() {
		doNothing().when(bookService).addBook(book1);
		String actual  = orderdetails.addBook(book1);
		assertEquals("Book Added",actual);
	}
	
	

}
