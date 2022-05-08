package com.testcases.bookapp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.bookapp.exception.BookNotFoundException;
import com.bookapp.model.Book;
import com.bookapp.service.IBookService;
import com.bookapp.service.OrderDetails;

@RunWith(JUnitPlatform.class)
@ExtendWith(MockitoExtension.class)
class OrderDetailsTest {
	
	@Mock
	IBookService bookService;
	@InjectMocks
	OrderDetails orderDetails;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}
	Book book1 ,book2,book3,book5,book4;
	@BeforeEach
	void setUp() throws Exception {
		orderDetails = new OrderDetails();
		orderDetails.setBookService(bookService);
		
		 book1 = new Book(1,"Java","Kathy",900);
		 book2 = new Book(2,"Spring","james",987);
		 book3 =  new Book(3,"Hibernate","Kathy",87);
		 book4 =  new Book(4,"JSP","Robin",349);
		 book5 =  new Book(5,"python","Kathy",9787);
	}

	@AfterEach
	void tearDown() throws Exception {
		orderDetails = null;
	}

	@Test
	@DisplayName("Testing by Author")
	void testBookByAuthor() throws BookNotFoundException {
		List<Book> booksByAuthor = Arrays.asList(book1,book2,book5);
		Mockito.when(bookService.getByAuthor("Kathy")).thenReturn(booksByAuthor);
		List<Book> books = orderDetails.findByAuthor("Kathy");
		assertNotNull(books);
		
	}
	@Test
	@DisplayName("Testing by Author Null")
	void testBookByAuthorNull() throws BookNotFoundException {
		Mockito.when(bookService.getByAuthor("Kathy")).thenReturn(null);
		List<Book> books = orderDetails.findByAuthor("Kathy");
		assertNull(books);
		
	}
	@Test
	@DisplayName("Author Empty")
	void testByAuthorEmpty() throws BookNotFoundException {
		String author = "kathy";
		when(bookService.getByAuthor(author)).thenReturn(new ArrayList<>());
		assertThrows(BookNotFoundException.class,()->orderDetails.findByAuthor(author));
		
	}
	@Test
	@DisplayName("testing Exception")
	void testAuthorException() throws BookNotFoundException {
		String author = "Awadhesh";
		when(bookService.getByAuthor(author)).thenThrow(new BookNotFoundException());
		assertThrows(BookNotFoundException.class,()->orderDetails.findByAuthor(author));
	}
	
	@Test
	@DisplayName("Testing Verify")
	void testVerify() throws BookNotFoundException {
		String author ="Kathy";
        List<Book> expected = Arrays.asList(book3,book1,book5);
        when(bookService.getByAuthor(author)).thenReturn(Arrays.asList(book1,book3,book5));
        List<Book> actualList = orderDetails.findByAuthor(author);
        assertEquals(expected.toString(), actualList.toString());
        assertNotNull(actualList);
        
        when(bookService.getByAuthor(author)).thenReturn(null);
        List<Book> actual = orderDetails.findByAuthor(author);
        assertNull(actual);
        
        Mockito.verify(bookService,times(2)).getByAuthor(author);
        Mockito.verify(bookService,atLeast(1)).getByAuthor(author);
        Mockito.verify(bookService,atLeastOnce()).getByAuthor(author);
		
	}

}
