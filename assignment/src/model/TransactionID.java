package model;

import java.util.Calendar;

/**
 * Generate Transaction ID for each Movie Ticket booking
 * @version 1.0
 */

public class TransactionID {

	/**
	 * Cinema Code
	 */
	private String CinCode = null;
	
	/**
	 * Default Constructor
	 * @param cineplexID ID of the cineplex
	 */
	public TransactionID(int cineplexID) {
		if(cineplexID+1 == 1) {
			CinCode = "FGB";
		} else if (cineplexID+1 == 2) {
			CinCode = "GVV";
		} else {
			CinCode = "SWT";
		}
	}
	
	/**
	 * Create a new transaction ID
	 * @return generated Transaction ID based on format of Assignment Manual
	 */
	private String createTransactionID() {
		String TID = CinCode + Calendar.getInstance().get(Calendar.YEAR) + Calendar.getInstance().get(Calendar.MONTH) + Calendar.getInstance().get(Calendar.HOUR_OF_DAY) + Calendar.getInstance().get(Calendar.MINUTE);
		return TID;
	}
	
	/**
	 * get the transaction ID
	 * @return transaction ID
	 */
	public String getTID() {
		return createTransactionID();
	}
}
