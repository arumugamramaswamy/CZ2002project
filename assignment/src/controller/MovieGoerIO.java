package controller;

import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

import model.*;

/**
 * 
 * @version 1.0
 * Used to read and write bookings made by a MovieGoer
 */

public class MovieGoerIO{
    
	/**
	 * text file for the input and output
	 */
    private File file = new File("data/Customers.txt");
    
    /**
     * ArrayList of the MovieGoers
     */
    private static ArrayList<MovieGoer> customers = new ArrayList<>();
    
    /**
     * Different parameters to be recorded with the booking
     */
    private int custID; 
    
    private String bookingID;
  
    private String movieBooked;

    private int numseats;
    
    private String cineplexID;
    
    private String dateTime;

    private String firstseat;
    
	private String customerName;
    
    private int phoneNumber;
   
    private static int linecounter=0;
    
    public int [][] seats = new int[9][9];
    
    public MovieGoerIO() {};
	
    /**
     * to count the number of previous bookings in the Bookings file
     * @throws IOException
     * @throws Exception
     */
    public void countPreviousBookings() throws IOException,Exception {
    	FileReader fw = new FileReader("data/Customers.txt");
		BufferedReader br = new BufferedReader(fw);
		
		String s;
		while((s=br.readLine())!=null) {
			linecounter ++;
		}
		br.close();
    }	
    
    /**
     * to read all the previous bookings from the text file
     * @throws IOException
     * @throws Exception
     */
    public void readBookingsFile() throws IOException,Exception {
    	
    		countPreviousBookings();
    		
    		FileReader fw = new FileReader("data/Customers.txt");
    		BufferedReader br = new BufferedReader(fw);
    		
    		String s;
    		int i =1;
    		while(i<=linecounter) {
    			s=br.readLine();
    			if(s!=null) {
    			String[] var = s.split("[|]");
    			this.custID = Integer.parseInt(var[0]);
        		this.bookingID = var[1];
            	this.customerName = var[2];
            	this.phoneNumber = Integer.parseInt(var[3]);
            	this.movieBooked = var[4];
            	this.cineplexID = var[5];
            	this.dateTime = var[6];
            	this.numseats = Integer.parseInt(var[7]);
            	this.firstseat = var[8];
            	
            	addMovieGoer();
            	}
    			i+=1;
            	}
            	
            	
    			
    		}	
    
    
    /**
     * to write a new bookings into the text file
     * @throws IOException
     * @throws Exception
     */
    public void writeNewBooking(int custID, String bookingID, String customerName, int phoneNumber, String movieBooked, int cineplexID, String time, int numseats, String firstseat) throws IOException,Exception{
	countPreviousBookings();    
    	file = getCustomerFile();
    	String temp;
    	try {
			Scanner sc = new Scanner(System.in);
			
			
			FileWriter fw = new FileWriter(file, true);
			BufferedWriter bw = new BufferedWriter(fw);
			
			bw.newLine();
			bw.write(Integer.toString(custID) + "|");
			bw.write(bookingID + "|");
			bw.write(customerName + "|");
			bw.write(Integer.toString(phoneNumber) + "|");
			bw.write(movieBooked + "|");
			bw.write(Integer.toString(cineplexID) + "|");
			bw.write(time + "|");
			bw.write(Integer.toString(numseats) + "|");
			bw.write(firstseat + "|");
			bw.close();
			
			linecounter+=1;
			
		} catch (IOException e) {
			e.printStackTrace();
		}
    	
    }
    
    
    /**
     * to add a movieGoer to the ArrayList of customers
     */
    public void addMovieGoer() {
    		MovieGoer m1 = new MovieGoer();
    		
    		m1.setCustID(custID);
    		m1.setCustomerName(customerName);
    		m1.setPhoneNumber(phoneNumber);
    		
    		int length = customers.size();
    		int flag=1;
    		int i;
    		for(i=0; i<length; i++) {
    			int c = customers.get(i).getCustID();
    			if(c==custID) {flag = 0; addBooking(i); break;}
    		}
    		
    		if(flag==1){m1.setBooking(createBooking());}
    		
   
    		
    		if(!customers.contains(m1)){customers.add(m1);}
    		
    	
    }
    
    /**
     * to add a booking to an existing customer
     * @param i index of the existing customer in the ArrayList
     */
    public void addBooking(int i) {
    	MovieGoer m = new MovieGoer();
    	m = customers.get(i);
    	
    	m.setBooking(createBooking());
    	
    }
    
    /**
     * to create a Booking object to be associated with the customer
     * @return booking
     */
    public Booking createBooking() {
    	Booking b1 = new Booking();	
    	
    	b1.setCustID(custID);
    	b1.setbookingID(bookingID);
    	b1.setfirstseat(firstseat);
    	b1.setmovieBooked(movieBooked);
    	b1.setnumseats(numseats);
    	b1.setDateTime(dateTime);
    	
    	
    	return b1;
    }
    
    
	/**
	 * assign seats to a customer
	 * @param m MovieGoer object
	 * @param b Booking details of the movie-goer
	 * @param row row of the theater to be booked
	 * @param numseats number of seats to be booked
	 * @param firstseat first seat of the booking
	 * @throws Exception 
	 * @throws IOException 
	 */
   public void assignFinalSeatsbyMovie(movie mo, int index, String custName, int custID, int phoneNumber, String bookingID, int numseats, String firstseat) throws IOException, Exception {
    	try{
    		readBookingsFile();
    		
    		this.movieBooked = mo.getMovieName();
    		this.numseats = numseats;
    		this.bookingID = bookingID;
    		
    		Booking b = new Booking();
    		
    		int length = customers.size();
    		int flag=1;
    		int i;
    		for(i=0; i<length; i++) {
    			int c = customers.get(i).getCustID();
    			if(c==custID) {flag = 0; break;}
    		}
    		
    		if(flag==1){
    			MovieGoer m = new MovieGoer();
    			m.setCustomerName(custName);
    			m.setCustID(custID);
    			
    			
    			b = createBooking();
            	m.setBooking(b);
    			}
    		else {
    			MovieGoer m = new MovieGoer();
    			m = customers.get(i);
    			addBooking(i);
    			ArrayList<Booking> bookings = new ArrayList<>();
    			bookings = m.getBooking();
    			int numofbookings = bookings.size();
    			
    			m.setBooking(bookings.get(numofbookings-1));
    		}
    	
    	ArrayList<show> shows = new ArrayList<>();
    	
    	shows = mo.getShows();
    	
    	char ch = firstseat.charAt(0);
		int row = ch - 'a' + 1;
		int firstseatnum = Character.getNumericValue(firstseat.charAt(1));
    	
    	show s = shows.get(index);
    	int cineplexID = s.getCineplexID()+1;
    
    	    	for(int j=1; j<=numseats; j++) {
    		s.assignSeat(row-1, j+firstseatnum-2);
    	}   
    	String time = s.getDateTime(); 	
    	writeNewBooking(custID, bookingID, custName, phoneNumber, movieBooked, cineplexID, time, numseats, firstseat); 	
    	}finally{customers.clear();}
    	    	//write new booking after assigning seats
    }

    /**
     * get the bookings file
     * @return customer file
     */
    public File getCustomerFile() {
		return file;
	}

	/**
	 * search and return the movieGoer object by customer ID
	 * @param custID customer ID of the movie-goer
	 * @return MovieGoer Object
	 * @throws IOException
	 * @throws Exception
	 */
	public MovieGoer getMovieGoer(int custID) throws IOException, Exception {
		try{
		readBookingsFile();
		int length = customers.size();
		int i;
		for(i=0; i<length; i++) {
			int c = customers.get(i).getCustID();
			if(c==custID) break;
		}
		
		return customers.get(i);}finally {customers.clear();}
		
		
	}
	
//	public void printBookings(int i) {
//		System.out.println("Customer Name is " + customers.get(i).getCustomerName());
//		System.out.println("Customer Age is " + customers.get(i).getCustomerAge());
//		System.out.println("Booking ID: " + customers.get(i).getBooking(i).getbookingID());
//		System.out.println("FirstSeat of the Booking: " + customers.get(i).getBooking(i).getfirstseat());
//		System.out.println("MovieBooked is: " + customers.get(i).getBooking(i).getmovieBooked());
//		System.out.println("Total Number of Seats booked: " + customers.get(i).getBooking(i).getnumseats());
//		
//		
//		
//	}


}
