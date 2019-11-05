package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.ArrayList;

/**
 * Used to write all ticket prices to prices.txt
 * @version 1.0
 */

public class UpdateTicketPrices {
	
	public void writePrices(ArrayList newPrices) {
		
		try {
		
		PrintWriter writer = new PrintWriter("assignment/data/prices.txt");
		
		for(int i = 0; i < 7; i++) {
			writer.println(newPrices.get(i));
		}
		
		writer.print(newPrices.get(7));
		
		writer.close();
		
		}
		
		catch (FileNotFoundException e) {
            e.printStackTrace();
        }
		
	}
	
	
}
