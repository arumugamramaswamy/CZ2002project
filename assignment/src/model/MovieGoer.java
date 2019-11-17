package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


import java.util.ArrayList;

/**
 * movie-goer class which holds all the information about him/her including all
 * the bookings made by them.
 * @version 1.0
 * 
 */
public class MovieGoer{
    /**
     * details of the customer
     */
	private int custID;
	
	/**
	 * customer name
	 */
	private String customerName;
    
	/**
	 * customer phone number
	 */
    private int phoneNumber;
    

    /**
     * ArrayList of all the bookings made by the particular customer
     */
    private ArrayList<Booking> customerbookings = new ArrayList<>();
    
    /**
     * 
     */
    public MovieGoer() {};
   
    /**
     * default constructor
     * @param customerName name of the customer
     * @param phoneNumber	phone number of the customer
     * @param emailID	email id of the customer
     * @param customerbookings	list of all bookings made by the customer
     */
    public MovieGoer(String customerName, int phoneNumber, String emailID, ArrayList<Booking> customerbookings){
        this.customerName = customerName;
        this.phoneNumber = phoneNumber;
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
	 * sets the phone number of the customer
	 * @param phoneNumber set the phone number of the customer
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

