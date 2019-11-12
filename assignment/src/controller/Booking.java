package controller;

import model.show;

/**
 * holds information about a particular booking
 * @version 1.0
 *
 */
public class Booking{

    /**
     * customer ID of the person who has made the booking
     */
	private int custID;
	/**
	 * unique booking ID of the booking
	 */
    private int bookingID;
    /**
     * movie name booked by the customer
     */
    private String movieBooked;
    /**
     * number of seats to be booked
     */
    private int numseats;
    /**
     * first and last seat to be booked
     */
    private String firstseat, lastseat;
    /**
     * show object of the show to booked
     */
    private show show;
    
    public Booking() {};
    /**
     * booking constructor 
     * @param custID customer ID of the person making the booking
     * @param movieBooked name of the movie booked
     * @param numseats number of seats to be booked
     * @param firstseat first seat of the booking
     * @param lastseat last seat of the booking
     * @param show show object of the show to be booked
     */
    public Booking(int custID, String movieBooked,int numseats, String firstseat, String lastseat, show show){
        this.custID = custID;
    	
        //assign according to number of bookings
   
        this.movieBooked = movieBooked;
        
        
        this.numseats = numseats;
        
        //check if last-first = num?
        this.firstseat = firstseat;
        this.lastseat = lastseat;
        
        this.setShow(show);
    }
    /**
     * gets the name of the movie booked
     * @return name of the movie booked
     */
    public String getmovieBooked() {
    	return movieBooked;
    }
    /**
     * gets the ID of the booking made
     * @return ID of the booking
     */
    public int getbookingID() {
    	return bookingID;
    }
    /**
     * gets the number of seats booked in the booking
     * @return number of seats booked
     */
    public int getnumseats() {
    	return numseats;
    }
    /**
     * gets the first seat of the booking
     * @return first seat of the booking
     */
    public String getfirstseat() {
    	return firstseat;
    }
    /**
     * sets the name of the movie booked
     * @param movieBooked
     */
    public void setmovieBooked(String movieBooked) {
    	this.movieBooked = movieBooked;
    }
    /**
     * sets the booking ID of the booking
     * @param bookingID
     */
    public void setbookingID(int bookingID ) {
    	this.bookingID = bookingID;
    }
    /**
     * sets the number of seats booked
     * @param numseats number of seats
     */
    public void setnumseats(int numseats) {
    	this.numseats = numseats;
    }
    /**
     * sets the first seat of the booking
     * @param firstseat first seat of the booking
     */
    public void setfirstseat(String firstseat) {
    	this.firstseat = firstseat;
    }
    /**
     * gets the customer ID of the person making the booking
     * @return customer ID of the booker
     */
	public int getCustID() {
		return custID;
	}
	/**
	 * sets the customer ID of the booker
	 * @param custID customer ID of the booker
	 */
	public void setCustID(int custID) {
		this.custID = custID;
	}
	/**
	 * gets the show for which the booking is done
	 * @return shwo object for which the booking is made
	 */
	public show getShow() {
		return show;
	}
	/**
	 * sets the show for which the booking is made
	 * @param show show for which the booking is to be made
	 */
	public void setShow(show show) {
		this.show = show;
	}
}

