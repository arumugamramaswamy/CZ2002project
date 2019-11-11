package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Logger;

public class PasswordHasher {

	static ArrayList<String> passwords = new ArrayList<>();
	
	public static String getHashSHA1 (String password) {
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-1");
			md.update(password.getBytes());
			byte byteData[] = md.digest();
			StringBuilder sb = new StringBuilder();
			for(int i = 0; i < byteData.length; i++) {
				sb.append(Integer.toString(
						(byteData[i] & 0xff) + 0x100, 16).substring(1));
							
			}
			return sb.toString();
		} catch (NoSuchAlgorithmException ex) {
			return null;
		}
	}


	public static ArrayList<String> readPasswords() { 
	        
	        File file = new File("data/passwords.txt");
	        
	        try {
	    
	            Scanner sc = new Scanner(file);
	    
	            while (sc.hasNextLine()) {
	                String i = sc.nextLine();
	                passwords.add(i);
	            }
	            sc.close();
	        } 
	        catch (FileNotFoundException e) {
	            e.printStackTrace();
	        }
	        
	        return passwords;
	        
	}
	
	public static boolean checkPass(String password) {
		
		ArrayList<String> pass = readPasswords();
		boolean valid;
		
		valid = false;
		
		for (int i = 0; i < pass.size(); i++) {

			if (pass.get(i).matches(getHashSHA1(password))) {
				valid = true;
			}
		}

		return valid;
	}
	
}

