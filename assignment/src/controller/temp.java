package controller;
import java.io.*;

public class temp {

	public temp() {
		// TODO Auto-generated constructor stub
	}
	public static void main(String args[]) {
		holidyIO h =new holidyIO();
		try {
		String[] holidays = h.readHolidays();
		System.out.println(holidays[2]);
		h.writeHoliday(holidays);
		}catch(Exception e) {
			System.out.println(e);
		}
	}
}
