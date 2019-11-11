package people;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


import java.util.ArrayList;


public class MovieGoer{
    // name of the Customer
    //use the PERSON class
	private int custID;
	
	private String customerName;
    
    private int customerAge;


    private static ArrayList<Booking> customerbookings = new ArrayList<>();

    //default constructor
    public MovieGoer() {};
    
    public MovieGoer(String customerName, int customerAge){
        this.customerName = customerName;
        this.customerAge = customerAge;
        
    }

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public void setCustomerAge(int customerAge) {
		this.customerAge = customerAge;
	}
	
	public String getCustomerName() {
		return customerName;
	}
	
	public int getCustomerAge() {
		return customerAge;
	}

	public int getCustID() {
		return custID;
	}

	public void setCustID(int custID) {
		this.custID = custID;
	}
	
	public void setBooking(Booking b) {
		customerbookings.add(b);
	}
	
	public Booking getBooking(int i) {
		return customerbookings.get(i);
	}

}

