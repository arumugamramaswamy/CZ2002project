package assignment;

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
	
	// Price of the Ticket - Base Price (hardcoded for now, later needed to be retrieved from .flat file
	private double Price = 9.00;
	
	// Default Constructor
	public MovieTicket(boolean is3D, String classOfCinema, String movieGoerCategory, boolean isPublicHoliday) {
		this.is3D = is3D;
		this.classOfCinema = classOfCinema;
		this.movieGoerCategory = movieGoerCategory;
		this.isPublicHoliday = isPublicHoliday;
	}
	
	
	private double calculatePrice() {
		/*
		 * Hardcoding prices for now
		 * Later needed to be retrieved from the .flat file
		 */
		
		// All prices in SGD
		
		// Increase price if the movie is 3D
		if(is3D) 
			Price = Price + 3.5;
		
		// Increase price based on different class of Cinema
		if(classOfCinema == "Standard")
			Price = Price + 3.5;
		else if(classOfCinema == "Premium")
			Price = Price + 5.5;
		else if(classOfCinema == "Platinum")
			Price = Price + 8.5;
		
		// Decrease the price if ticket is of a child or a senior citizen
		if(movieGoerCategory == "Child")
			Price = Price - 2.5;
		else if(movieGoerCategory == "SeniorCitizen")
			Price = Price - 3.5;
		
		// Increase price if it is a public holiday
		if(isPublicHoliday)
			Price = Price + 2;
		
		// Calculating GST
		Price = Price + (7/100) * Price;
		
		return Price;
	}
	
	
	// get total price
	public double getPrice() {
		double totalPrice = calculatePrice();
		return totalPrice;
	}
	
}
