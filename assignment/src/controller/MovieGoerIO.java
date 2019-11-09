package controller.people;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class MovieGoerIO{
    
    File file = new File("Customers.txt");

    Scanner sc = new Scanner(file).useDelimiter("|");


    String customerName = sc.next();
    int customerAge = Integer.parseInt(sc.next());
    String movieBooked = sc.next();
    String cinema = sc.next();
    String time = sc.next();
    int numseats = Integer.parseInt(sc.next());
    String firstseat = sc.next();

    private String [] moviesbooked;
    private Booking [] mb;

    moviesbooked = new ArrayList();
    moviesbooked.add(movieBooked);

    MovieGoer mg = new MovieGoer(customerName, customerAge, "b1", mb);
    Booking mb = new Booking(mg, moviesbooked, numseats, firstseat);



}