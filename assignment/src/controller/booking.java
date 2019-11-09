package controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


import java.util.ArrayList;


public class booking {

    //the person who has made the booking
    private MovieGoer booker;
    
    //movie object booked by the customer
    private String [] moviesBooked;
    
    //Date of the Booking
    //private Date dateBooked;

    private int numseats;

    private String firstseat;

    public booking(MovieGoer booker, String [] moviesBooked,int numseats, String firstseat){
        this.booker = booker;
        this.moviesBooked = moviesBooked;
        this.numseats = numseats;
        this.firstseat = firstseat;
    }

}

