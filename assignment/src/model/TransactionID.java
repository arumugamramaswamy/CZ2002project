package model;

import java.util.Calendar;


public class TransactionID {

	private String CinCode = null;
		
	public TransactionID(int cineplexID) {
		if(cineplexID+1 == 1) {
			CinCode = "FGB";
		} else if (cineplexID+1 == 2) {
			CinCode = "GVV";
		} else {
			CinCode = "SWT";
		}
	}
	
	private String createTransactionID() {
		String TID = CinCode + Calendar.getInstance().get(Calendar.YEAR) + Calendar.getInstance().get(Calendar.MONTH) + Calendar.getInstance().get(Calendar.HOUR_OF_DAY) + Calendar.getInstance().get(Calendar.MINUTE);
		return TID;
	}
	
	public String getTID() {
		return createTransactionID();
	}
	
	public static void main(String[] args) {
		TransactionID T = new TransactionID(2);
		System.out.println(T.getTID());
	}
}
