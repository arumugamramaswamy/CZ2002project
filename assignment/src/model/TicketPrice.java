package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

/*
 * TicketPrice.java
 * Used to read all ticket prices form prices.txt
 */


public class TicketPrice {
	
private static ArrayList<Double> prices = new ArrayList<>(); 
	
public static ArrayList<Double> readPrices() {
        
        /* File Format
            3DPrice
            Class - Standard
            Class - Premium
            Class - Platinum
            Movie Goer Category - Child
            Movie Goer Category - Senior Citizen
            Public Holiday Price
            GST Percentage
        */
        
        File file = new File("assignment/data/prices.txt");
        
        try {
    
            Scanner sc = new Scanner(file);
    
            while (sc.hasNextLine()) {
                double i = sc.nextDouble();
                prices.add(i);
            }
            sc.close();
        } 
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        
        return prices;
        
}

}