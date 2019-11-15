package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import controller.GetPrice;

/**
 * Generate a Movie Ticket price
 * @version 1.0
 */


public class MovieTicket {
	
	/**
	 * Type of Movie - 3D (true) or 2D (false)
	 */
	private boolean is3D;
	
	/**
	 * Class of Cinema - Standard, Premium, Platinum
	 */
	private String classOfCinema;
	
	/**
	 * Movie Goer Category - Child, Adult, SeniorCitizen
	 */
	private String movieGoerCategory;
	
	/**
	 * Day of the Week - Public Holiday or Weekend(true), Week Day (false)
	 */
	private boolean isPublicHoliday;
	
	/**
	 * Price of the Ticket - Base Price
	 */
	private double Price = 9.00;
	
	/**
	 * Default Constructor
	 * @param is3D 					true if the movie is 3D
	 * @param classOfCinema			Standard, Premium, Platinum
	 * @param movieGoerCategory		Child, Adult, Senior Citizen
	 * @param isPublicHoliday		true if it is a public holiday
	 */
	public MovieTicket(boolean is3D, String classOfCinema, String movieGoerCategory, boolean isPublicHoliday) {
		this.is3D = is3D;
		this.classOfCinema = classOfCinema;
		this.movieGoerCategory = movieGoerCategory;
		this.isPublicHoliday = isPublicHoliday;
	}
	
	/**
	 * Calculate the ticket price - all prices in SGD
	 * Add a surcharge (3D, Platinum Ticket, etc..) on top of a base price
	 * @return			movie ticket price
	 */
	private double calculatePrice() {
		
		GetPrice getQuotation = new GetPrice();
		
		/**
		 *  All prices in SGD
		 */
		
		/**
		 * Increase price if the movie is 3D
		 */
		if(is3D) 
			Price = Price + getQuotation.get3DPrice();
		
		/**
		 * Increase price based on different class of Cinema
		 */
		if(classOfCinema.equals("Standard"))
			Price = Price + getQuotation.getStandardPrice();
		else if(classOfCinema.equals("Premium"))
			Price = Price + getQuotation.getPremiumPrice();
		else if(classOfCinema.equals("Platinum"))
			Price = Price + getQuotation.getPlatinumPrice();
		
		/**
		 * Decrease the price if ticket is of a child or a senior citizen
		 */
		if(movieGoerCategory.equals("Child"))
			Price = Price - getQuotation.getChildPrice();
		else if(movieGoerCategory.equals("SeniorCitizen"))
			Price = Price - getQuotation.getSeniorCitizenPrice();
		
		/**
		 * Increase price if it is a public holiday
		 */
		if(isPublicHoliday)
			Price = Price + getQuotation.getPublicHolidayPrice();
		
		/**
		 * Calculating GST
		 */
		Price = Price + getQuotation.getGSTPrice() * Price;
		
		return Price;
	}
	
	/**
	 * get total price
	 * @return helper function to return total price
	 */
	public double getPrice() {
		double totalPrice = calculatePrice();
		return totalPrice;
	}
	
}
	
