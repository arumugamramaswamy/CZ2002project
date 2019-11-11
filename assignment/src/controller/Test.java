package controller;

import java.io.*;


public class Test {

	public static void main(String[] args) throws IOException, Exception{
		// TODO Auto-generated method stub
		MovieGoerIO mgio = new MovieGoerIO();
		mgio.writeNewBooking();
		
		mgio.readBookingsFile();
		
		
	
		

	}

}
