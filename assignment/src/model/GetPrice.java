package model;

import java.util.ArrayList;


/**
 * Returns all prices for different categories and types
 * @version 1.0
 */
public class GetPrice {
	
	TicketPrice TP = new TicketPrice();
	
	private ArrayList<Double> prices = TP.readPrices();
	
	/**
	 * @return 3D Movie surcharge
	 */
	public double get3DPrice() {
		return prices.get(0);
	}
	
	/**
	 * @return Standard ticket surcharge
	 */
	public double getStandardPrice() {
		return prices.get(1);
	}
	
	public double getPremiumPrice() {
		return prices.get(2);
	}
	
	public double getPlatinumPrice() {
		return prices.get(3);
	}
	
	public double getChildPrice() {
		return prices.get(4);
	}
	
	public double getSeniorCitizenPrice() {
		return prices.get(5);
	}
	
	public double getPublicHolidayPrice() {
		return prices.get(6);
	}
	
	public double getGSTPrice() {
		return prices.get(7);
	}
	
}
