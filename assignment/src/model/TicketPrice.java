package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class TicketPrice {

	
private static ArrayList<Double> prices = new ArrayList<>(); 
	
public static void main(String[] args) {
        
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
        
   }

	public static double get3DPrice() {
		return prices.get(0);
	}
	
	public static double getStandardPrice() {
		return prices.get(1);
	}
	
	public static double getPremiumPrice() {
		return prices.get(2);
	}
	
	public static double getPlatinumPrice() {
		return prices.get(3);
	}
	
	public static double getChildPrice() {
		return prices.get(4);
	}
	
	public static double getSeniorCitizenPrice() {
		return prices.get(5);
	}
	
	public static double getPublicHolidayPrice() {
		return prices.get(6);
	}
	
	public static double getGSTPrice() {
		return prices.get(7);
	}

}