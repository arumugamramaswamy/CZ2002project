package controller;
import java.io.IOException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.FileInputStream;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.StringTokenizer;

import model.movie;
import model.show;
import model.master;

public class movieIO {



		public static final String SEPARATOR = "|";

		public static String[] GetStringArray(ArrayList<String> arr) 
	    { 
	  
	        // declaration and initialise String Array 
	        String str[] = new String[arr.size()]; 
	  
	        // Convert ArrayList to object array 
	        Object[] objArr = arr.toArray(); 
	  
	        // Iterating and converting to String 
	        int i = 0; 
	        for (Object obj : objArr) { 
	            str[i++] = (String)obj; 
	        } 
	  
	        return str; 
	    }
		
		public static double[] GetDoubleArray(ArrayList<String> arr) 
	    { 
	  
	        // declaration and initialise Double Array 
	        double db[] = new double[arr.size()]; 
	  

	        
	        // Iterating and Parsing to double
	        int i = 0; 
	        for (String str : arr) { 
	            db[i++] = Double.parseDouble(str); 
	        } 
	  
	        return db; 
	    }
		
	    // an example of reading
		public static ArrayList readMovie(String filename) throws IOException {
			
			// read String from text file
			ArrayList stringArray = (ArrayList)read(filename);
			
			//final array to store movie objects
			ArrayList alr = new ArrayList() ;// to store Movie data
			

			
	        for (int i = 0 ; i < stringArray.size() ; i++) {
	        		
					//temporary array to store sub arrays
					ArrayList alr2 = new ArrayList() ;
					
	        		//read the ith line of the file
					String st = (String)stringArray.get(i);
					
					// get individual 'fields' of the string separated by SEPARATOR
					StringTokenizer star = new StringTokenizer(st , SEPARATOR);	// pass in the string to the string tokenizer using delimiter "|"

					String movieName = star.nextToken().trim();	// first token movieName
					
					String directorName = star.nextToken().trim();	// second token directorName
					
					String all_rev = star.nextToken().trim();	// third token String[] reviews
					StringTokenizer star2 = new StringTokenizer(all_rev , ",");
					String[] reviews;
					if (!all_rev.equals("No Reviews"))
					{
					while (star2.hasMoreTokens()) {
				         alr2.add(star2.nextToken());
				     }
					
					reviews = GetStringArray(alr2);
					}
					else {
						reviews = new String[0];
					}
					alr2 = new ArrayList() ;
					String all_ratings = star.nextToken().trim();	// 4th token double[] ratings
					double[] ratings;
					if (!all_ratings.equals("No Ratings")) {
					star2 = new StringTokenizer(all_ratings , ",");
					while (star2.hasMoreTokens()) {
				         alr2.add(star2.nextToken());
				     }
					ratings = GetDoubleArray(alr2);
					}else {
						ratings = new double[0];
					}
					alr2 = new ArrayList() ;
					
					String showingStatus = star.nextToken().trim(); //5th token String showingStatus
					
					String Synopsis = star.nextToken().trim(); //6th token String Synopsis
					
					String all_Cast = star.nextToken().trim();	//7th token String[] Cast
					star2 = new StringTokenizer(all_Cast , ",");
					while (star2.hasMoreTokens()) {
				         alr2.add(star2.nextToken());
				     }
					String[] Cast = GetStringArray(alr2);
					int tSales = Integer.parseInt(star.nextToken());
					// create Professor object from file data
					movie mov = new movie(movieName,directorName,reviews,ratings,showingStatus,Synopsis,Cast,tSales);
					
					// add to movie list
					alr.add(mov) ;
					
//					//print all fields
//					System.out.println(movieName);
//					System.out.println(directorName);
//					System.out.println(all_rev);
//					for(int x =0;x<reviews.length;x++) 
//						System.out.printf("%s ",reviews[x]);
//					
//					System.out.printf("\n");
//					System.out.println(all_ratings);
//					for(int x =0;x<ratings.length;x++) 
//						System.out.printf("%f ",ratings[x]);
//					System.out.printf("\n");
//
//					System.out.println(showingStatus);
//					System.out.println(Synopsis);
//					System.out.println(all_Cast);
//					for(int x =0;x<Cast.length;x++) 
//						System.out.printf("%s ",Cast[x]);
//					System.out.printf("\n");


	        }
				return alr ;
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
		  
	  // an example of saving
	public static void saveMovie(String filename, List al) throws IOException {
			List alw = new ArrayList() ;// to store Professors data

	        for (int i = 0 ; i < al.size() ; i++) {
					movie mov = (movie)al.get(i);
					StringBuilder st =  new StringBuilder() ;
					st.append(mov.getMovieName().trim());
					st.append(SEPARATOR);
					st.append(mov.getDirectorName().trim());
					st.append(SEPARATOR);
					String[] temp = mov.getReviews();
					if (temp.length == 0) {
						st.append("No Reviews");
					}else {
					for (int j =0;j<temp.length;j++) {
						
						st.append(temp[j]);
						if(j<temp.length-1)
						st.append(",");
					}
					}
					st.append(SEPARATOR);
					double[] temp2 = mov.getAllRatings();
					if (temp2.length == 0) {
						st.append("No Ratings");
					}else {
					for (int j =0;j<temp2.length;j++) {
						st.append(String.valueOf(temp2[j]));
						if(j<temp2.length-1)
						st.append(",");
					}
					}
					st.append(SEPARATOR);
					st.append(mov.getShowingStatus());
					st.append(SEPARATOR);
					st.append(mov.getSynopsis());
					st.append(SEPARATOR);
					temp = mov.getCast();
					for (int j =0;j<temp.length;j++) {
						
						st.append(temp[j]);
						if(j<temp.length-1)
						st.append(",");
					}
					st.append(SEPARATOR);
					st.append(String.valueOf(mov.getTsales()));
					alw.add(st.toString());
				}
				write(filename,alw);
		}
	
	public static ArrayList<show> readShows(movie mov,String filename) throws IOException {
		
		// read String from text file
		ArrayList stringArray = (ArrayList)read(filename);
		
		//final array to store movie objects
		ArrayList<show> alr = new ArrayList<show>() ;// to store Movie data
		

		
        for (int i = 0 ; i < stringArray.size() ; i++) {
        		
				//temporary array to store sub arrays
				ArrayList alr2 = new ArrayList() ;
				
        		//read the ith line of the file
				String st = (String)stringArray.get(i);
				
				// get individual 'fields' of the string separated by SEPARATOR
				StringTokenizer star = new StringTokenizer(st , SEPARATOR);	// pass in the string to the string tokenizer using delimiter "|"

				String dateTime = star.nextToken().trim();	// first token dateTime
				
				String strCineplexID = star.nextToken().trim();	// second token cineplexID
				
				int cineplexID = Integer.parseInt(strCineplexID);
				
				String strScreenNum = star.nextToken().trim();	// third token cineplexID

				int screenNum = Integer.parseInt(strScreenNum);
				
				String seats = star.nextToken().trim(); //4th tokem
				
				StringTokenizer star2 = new StringTokenizer(seats , ",");

				while (star2.hasMoreTokens()) {
			         alr2.add(star2.nextToken());
			     }
				double[] Seats = GetDoubleArray(alr2);
				
				int[][] seats_final = new int[9][9];
				
				for (int x = 0;x<9;x++) {
					for (int y = 0;y<9;y++) {
						seats_final[x][y] = (int)Math.round(Seats[9*x+y]);
					}
				}
				boolean is3D = Boolean.parseBoolean(star.nextToken().trim());
				show s = new show(mov,dateTime,cineplexID,screenNum,is3D,seats_final);
				
//				s.assignSeat(0, 1);
//				s.printSeats();
				alr.add(s);
				
        }
			return alr ;
	}
	
	public static void saveShows(String filename, List Shows) throws IOException {
		if(Shows==null)
			return;
		List alw = new ArrayList() ;// to store Professors data

        for (int i = 0 ; i < Shows.size() ; i++) {
				show s = (show) Shows.get(i);
				StringBuilder st =  new StringBuilder() ;
				st.append(s.getDateTime().trim());
				st.append(SEPARATOR);
				st.append(String.valueOf(s.getCineplexID()).trim());
				st.append(SEPARATOR);
				st.append(String.valueOf(s.getScreenNum()).trim());
				st.append(SEPARATOR);
				int[][] temp2 = s.getSeats();
				for (int j =0;j<9;j++) {
					for (int k =0;k<9;k++) {
						st.append(String.valueOf(temp2[j][k]));
						if(j!=8 || k!=8)
						st.append(",");
					}
				}
				st.append(SEPARATOR);
				st.append(String.valueOf(s.get3D()));
				
				alw.add(st.toString());
			}
			write(filename,alw);
	}
		
}
