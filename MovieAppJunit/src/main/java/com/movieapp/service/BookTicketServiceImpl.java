package com.movieapp.service;

import com.movieapp.dao.BookTicketDaoImpl;
import com.movieapp.dao.IBookTicketDao;

public class BookTicketServiceImpl implements IBookTicketService {

	@Override
	public void  bookTicket(int movieId,int numberOfTickets,String type) {
		IBookTicketDao bookTicketDao = new BookTicketDaoImpl();
		 bookTicketDao.bookTicket(movieId, numberOfTickets, type);
		
		
	}

}
