package controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.util.*;
import java.io.IOException;
import java.io.PrintWriter;

import model.Cinema;
import model.Cineplex;
import model.master;

public class CineplexIO {

//	private static String SEPERATOR = "|";
	public static String filename ="";
	public CineplexIO() {
		// TODO Auto-generated constructor stub
	}

	public ArrayList<Cineplex> readCineplex(master m){
	    try{
	    	ArrayList<Cineplex> cineplexesList = new ArrayList<Cineplex>();
	        String[] temp;
	        String[] temp2;
	        Cinema c;
	        Scanner fileScanner = new Scanner(new File("C:\\Users\\tianyi\\eclipse-workspace\\storage\\Cineplexs.txt"));
	        while (fileScanner.hasNext()) {
	            temp = fileScanner.nextLine().split(";");

	                    ArrayList<Cinema> tempCinemaList = new ArrayList<>();
	                    for (int i = 2; i < temp.length; i++) {
	                    	temp2 = temp[i].split("|");
	                    	c = new Cinema(temp2[0],temp2[1],Integer.parseInt(temp2[2]));
	                        tempCinemaList.add(c);
	                    }
	                    cineplexesList.add(new Cineplex(
	                            temp[0], Integer.parseInt(temp[1]),
	                            tempCinemaList,
	                            m
	                    ));
	                }

	        fileScanner.close();
	        return cineplexesList;
	    }catch (Exception e){
	        System.err.println(e);
	        e.printStackTrace();
	        return null;
	    }
	}
	
	public static void saveCineplex(String filename, List al) throws IOException {
		List alw = new ArrayList() ;
		Cineplex c;
		ArrayList<Cinema> temp1;
		Cinema cm;
		StringBuilder st;
		final String SEPARATOR = ";";
		
	    for (int i = 0 ; i < al.size() ; i++) {
				c = (Cineplex)al.get(i);
				st =  new StringBuilder() ;
				st.append(c.getCineplexName().trim());
				st.append(SEPARATOR);
				st.append(c.getCineplexId());
				st.append(SEPARATOR);
				temp1 = c.getCinemaList();
				for(int j=0; j<temp1.size(); j++) {
					cm = temp1.get(j);
					st.append(cm.getCinemaName());
					st.append("|");
					st.append(cm.getCinemaClass());
					st.append("|");
					st.append(String.valueOf(cm.getCinemaID()));
				}
				

				alw.add(st.toString());
			}
			write(filename,alw);
	}
	
	
	public static List read(String fileName) throws IOException {
			List data = new ArrayList() ;
		    Scanner scanner = new Scanner(new FileInputStream(fileName));
		    try {
		      while (scanner.hasNextLine()){
		        data.add(scanner.nextLine());
		      }
		    }
		    finally{
		      scanner.close();
		    }
		    return data;
		  }
	
	/** Write fixed content to the given file. */
	public static void write(String fileName, List data) throws IOException  {
	  PrintWriter out = new PrintWriter(new FileWriter(fileName));
	
	  try {
			for (int i =0; i < data.size() ; i++) {
	    		out.println((String)data.get(i));
			}
	  }
	  finally {
	    out.close();
	  }
	}
}
