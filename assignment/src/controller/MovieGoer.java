package controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import model.movie;

import java.util.ArrayList;

/**
 * Hello
 * It's me.
 */



public class MovieGoer{
    // name of the Customer
    //use the PERSON class
	private String customerName;
    
    private int customerAge;

    private String [] customerAddress;

    private booking [] customerBookings;

    private int[][] seats = new int[9][9];

    //default constructor
    public MovieGoer(String customerName, int customerAge, String [] customerAddress, booking [] customerBookings){
        this.customerAddress = customerAddress;
        this.customerAge = customerAge;
        this.customerBookings = customerBookings;
        this.seats = seats;

        
    }
    
    //0 is empty, 1 is oppupied
    public void assignseats(int row, int numseats, int firstseat){
        for(int i=0; i<=numseats; i++){
            if(seats[row][i+firstseat]==0){
                seats[row][i+firstseat]=1;
            }
        }    

    

        

    }



    


	

}

