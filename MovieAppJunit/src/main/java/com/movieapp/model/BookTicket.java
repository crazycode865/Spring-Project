package com.movieapp.model;

import java.time.LocalDate;

public class BookTicket {
	private Integer bookingId;
	private LocalDate bookingDate;
	private int numberofTickets;
	private double price;
	private double totalCost;
	public BookTicket() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BookTicket(LocalDate bookingDate, int numberofTickets, double price) {
		super();
		this.bookingDate = bookingDate;
		this.numberofTickets= numberofTickets;
		this.price = price;
	}
	
	public BookTicket(Integer bookingId, LocalDate bookingDate, int numberofTickets, double price, int totalCost) {
		super();
		this.bookingId = bookingId;
		this.bookingDate = bookingDate;
		this.numberofTickets = numberofTickets;
		this.price = price;
		this.totalCost = totalCost;
	}
	public Integer getBookingId() {
		return bookingId;
	}
	public void setBookingId(Integer bookingId) {
		this.bookingId = bookingId;
	}
	public LocalDate getBookingDate() {
		return bookingDate;
	}
	public void setBookingDate(LocalDate bookingDate) {
		this.bookingDate= bookingDate;
	}
	
	
	public int getNumberofTickets() {
		return numberofTickets;
	}
	public void setNumberofTickets(int numberofTickets) {
		this.numberofTickets = numberofTickets;
	}
	public double getTotalCost() {
		return totalCost;
	}
	public void setTotalCost(int totalCost) {
		this.totalCost = totalCost;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "BookTicket [bookingId=" + bookingId + ", bookingDay=" + bookingDate + ", numberOfSeats=" + numberofTickets + ", price="
				+ price + "]";
	}
	
	

}
