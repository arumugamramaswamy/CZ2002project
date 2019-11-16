package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


import java.util.ArrayList;

/**
 * 
 * @version 1.0
 * movie-goer class which holds all the information about him/her including all
 * the bookings made by them.
 */
public class MovieGoer{
    /**
     * details of the customer
     */
	private int custID;
	
	private String customerName;
    
    private int phoneNumber;
    
    String emailID;

    /**
     * ArrayList of all the bookings made by the particular customer
     */
    private ArrayList<Booking> customerbookings = new ArrayList<>();

    public MovieGoer() {};
   
    /**
     *  constructor of the MovieGoer class
     * @param customerName name of the customer
     * @param customerAge age of the customer
     * @param customerbookings All the bookings made by the customer
     */
    public MovieGoer(String customerName, int phoneNumber, String emailID, ArrayList<Booking> customerbookings){
        this.customerName = customerName;
        this.phoneNumber = phoneNumber;
        this.emailID = emailID;
        this.customerbookings = customerbookings;
    }
    
    /**
     *  sets the customer Name 
     * @param customerName name of the customer
     */
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	/**
	 * sets the age of the customer
	 * @param customerAge age of the customer
	 */
	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	/**
	 * gets the name of the customer
	 * @return name of the customer
	 */
	public String getCustomerName() {
		return customerName;
	}
	/**
	 * gets the age of the customer
	 * @return age of the customer
	 */
	public int getphoneNumber() {
		return phoneNumber;
	}
	/**
	 * gets the customer ID of the customer
	 * @return ID of the customer
	 */
	public int getCustID() {
		return custID;
	}
	/**
	 * sets the customer ID of the customer
	 * @param custID customer ID of the customer
	 */
	public void setCustID(int custID) {
		this.custID = custID;
	}
	
	public String getemailID() {
		return emailID;
	}
	/**
	 * sets the customer email ID of the customer
	 * @param emailID customer ID of the customer
	 */
	public void setemailID(String emailID) {
		this.emailID = emailID;
	}
	/**
	 * adds a new bookings made by the customer to the booking ArrayList
	 * @param b booking made by the customer
	 */
	public void setBooking(Booking b) {
		if(!customerbookings.contains(b)) {
		customerbookings.add(b);}
	}
	
	/**
	 * returns the complete arrayList of all the bookings made by a particular customer
	 * @return bookings ArrayList
	 */
	public ArrayList<Booking> getBooking() {
		return customerbookings;
	}

}

