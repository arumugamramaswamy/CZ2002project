package controller;

import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

public class MovieGoerIO{
    
    private File file = new File("src/controller/Customers.txt");
    
    private static ArrayList<MovieGoer> customers = new ArrayList<>();
    
    private int custID; 
    
    private int bookingID;
  
    private String movieBooked;

    private int numseats;
    
    private String cinema;
    
    private String time;

    private String firstseat;
    
	private String customerName;
    
    private int customerAge;
    
    private static int linecounter = 1;
    
    public int [][] seats = new int[9][9];
    
    public MovieGoerIO() {};
    
    public void readBookingsFile() throws IOException,Exception {
    	
    	
    		
    		FileReader fw = new FileReader("src/controller/Customers.txt");
    		BufferedReader br = new BufferedReader(fw);
    		
    		String s;
    		int i =1;
    		while(i<=linecounter) {
    			s=br.readLine();
    			if(s!=null) {
    			String[] var = s.split("[|]");
    			this.custID = Integer.parseInt(var[0]);
        		this.bookingID = Integer.parseInt(var[1]);
            	this.customerName = var[2];
            	this.customerAge = Integer.parseInt(var[3]);
            	this.movieBooked = var[4];
            	this.cinema = var[5];
            	this.time = var[6];
            	this.numseats = Integer.parseInt(var[7]);
            	this.firstseat = var[8];
            	
            	addMovieGoer();
            	printBookings(i-1);}
            	
            	i+=1;
    			
    		}	
    }
    
    public void writeNewBooking() {
    	file = getCustomerFile();
    	String temp;
    	try {
			Scanner sc = new Scanner(System.in);
			
			
			FileWriter fw = new FileWriter(file, true);
			BufferedWriter bw = new BufferedWriter(fw);
			
			System.out.print("Enter Customer ID: ");
			temp = sc.nextLine();
			int custID = Integer.valueOf(temp);
			
			System.out.print("Enter Booking ID: ");
			temp = sc.nextLine();
			int bookingID = Integer.valueOf(temp);
			
			System.out.print("Enter Customer Name: ");
			String customerName = sc.nextLine();
			
			System.out.print("Enter Customer Age: ");
			temp = sc.nextLine();
			int customerAge = Integer.valueOf(temp);
			
			System.out.print("Enter Movie: ");
			String movieBooked = sc.nextLine();
			
			System.out.print("Enter Cinema: ");
			String cinema = sc.nextLine();
			
			System.out.print("Enter show-time: ");
			String time = sc.nextLine();
			
			System.out.print("Enter Number of Seats to Book: ");
			temp = sc.nextLine();
			int numseats = Integer.valueOf(temp);
			
			System.out.print("Enter FirstSeat Number: ");
			String firstseat = sc.nextLine();
			
			bw.newLine();
			bw.write(Integer.toString(custID) + "|");
			bw.write(Integer.toString(bookingID) + "|");
			bw.write(customerName + "|");
			bw.write(Integer.toString(customerAge) + "|");
			bw.write(movieBooked + "|");
			bw.write(cinema + "|");
			bw.write(time + "|");
			bw.write(Integer.toString(numseats) + "|");
			bw.write(firstseat + "|");
			bw.close();
			
			linecounter+=1;
			
		} catch (IOException e) {
			e.printStackTrace();
		}
    	
    }
    
    
    public void addMovieGoer() {
    		MovieGoer m1 = new MovieGoer();
    		
    		m1.setCustID(custID);
    		m1.setCustomerName(customerName);
    		m1.setCustomerAge(customerAge);
    		m1.setBooking(createBooking());
    		
    		char ch = firstseat.charAt(0);
    		int row = ch - 'a' + 1;
    		int firstseatnum = Character.getNumericValue(firstseat.charAt(1));
    		assignseats(m1, row, numseats, firstseatnum);
    		
    		
    		customers.add(m1);
    	
    }
    
    public Booking createBooking() {
    	Booking b1 = new Booking();	
    	
    	b1.setCustID(custID);
    	b1.setbookingID(bookingID);
    	b1.setfirstseat(firstseat);
    	b1.setmovieBooked(movieBooked);
    	b1.setnumseats(numseats);
    	
    	
    	return b1;
    }
    
    public void assignseats(MovieGoer m, int row, int numseats, int firstseat){
        for(int i=1; i<=numseats; i++){
            if(seats[row][i+firstseat-1]==0){
                seats[row][i+firstseat-1]=1;
            }
        }
        System.out.println(numseats + " seats in row " + row + " from first seat " +  firstseat + "assigned to " + m.getCustomerName());
    }



	public File getCustomerFile() {
		return file;
	}



	public void setCustomerFile(File file) {
		this.file = file;
	}
	
	public void printBookings(int i) {
		System.out.println("Customer Name is " + customers.get(i).getCustomerName());
		System.out.println("Customer Age is " + customers.get(i).getCustomerAge());
		System.out.println("Booking ID: " + customers.get(i).getBooking(i).getbookingID());
		System.out.println("FirstSeat of the Booking: " + customers.get(i).getBooking(i).getfirstseat());
		System.out.println("MovieBooked is: " + customers.get(i).getBooking(i).getmovieBooked());
		System.out.println("Total Number of Seats booked: " + customers.get(i).getBooking(i).getnumseats());
		
		
		
	}


}