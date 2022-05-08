package com.movieapp.model;

public enum TicketType {
	GOLD(120),SILVER(90),ORDINARY(50),PLATINUM(250);
	public double price;

	TicketType(double price) {
		this.price = price;
	}
	

}
