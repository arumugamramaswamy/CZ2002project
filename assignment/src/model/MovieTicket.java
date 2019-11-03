package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
 * MovieTicket Class
 * Used by the movie class to generate a Movie Ticket based on factors like
 * type of the movie,
 * day of the week,
 * etc. 
 */

public class MovieTicket {
	
	// Type of Movie - 3D (true) or 2D (false)
	private boolean is3D;
	
	// Class of Cinema - Standard, Premium, Platinum
	private String classOfCinema;
	
	// Movie Goer Category - Child, Adult, SeniorCitizen
	private String movieGoerCategory;
	
	// Day of the Week - Public Holiday or Weekend(true), Week Day (false)
	private boolean isPublicHoliday;
	
	// Price of the Ticket - Base Price
	private double Price = 9.00;
	
	// Default Constructor
	public MovieTicket(boolean is3D, String classOfCinema, String movieGoerCategory, boolean isPublicHoliday) {
		this.is3D = is3D;
		this.classOfCinema = classOfCinema;
		this.movieGoerCategory = movieGoerCategory;
		this.isPublicHoliday = isPublicHoliday;
	}
	
	
	private double calculatePrice() {
		
		GetPrice getQuotation = new GetPrice();
		
		// All prices in SGD
		
		// Increase price if the movie is 3D
		if(is3D) 
			Price = Price + getQuotation.get3DPrice();
		
		// Increase price based on different class of Cinema
		if(classOfCinema == "Standard")
			Price = Price + getQuotation.getStandardPrice();
		else if(classOfCinema == "Premium")
			Price = Price + getQuotation.getPremiumPrice();
		else if(classOfCinema == "Platinum")
			Price = Price + getQuotation.getPlatinumPrice();
		
		// Decrease the price if ticket is of a child or a senior citizen
		if(movieGoerCategory == "Child")
			Price = Price - getQuotation.getChildPrice();
		else if(movieGoerCategory == "SeniorCitizen")
			Price = Price - getQuotation.getSeniorCitizenPrice();
		
		// Increase price if it is a public holiday
		if(isPublicHoliday)
			Price = Price + getQuotation.getPublicHolidayPrice();
		
		// Calculating GST
		Price = Price + getQuotation.getGSTPrice() * Price;
		
		return Price;
	}
	
	// get total price
	public double getPrice() {
		double totalPrice = calculatePrice();
		return totalPrice;
	}
	
}
	
