package view;

import java.io.IOException;
import java.util.*;


import model.*;
import controller.CineplexIO;

public class CinemaShowTime {
	private static  Cineplex selectedCineplex;
    private static Cinema selectedCinema;
    private static master Master;
    private int[][] seats = new int[9][9];
    private static boolean is3D;
    private int screenNum;
	
    public static boolean tryParseInteger(String string){
        try{
            Integer.parseInt(string);
            return true;
        }catch (Exception e){
            return false;
        }
    }
	
	public static void main(String[] args) {
		String selection;
		Scanner sc = new Scanner(System.in);
		ArrayList<Cineplex> cineplexesList = new ArrayList<Cineplex>();
		ArrayList<Cinema> cinemasList = new ArrayList<>();
		ArrayList<movie> movies=new ArrayList<movie>();
		ArrayList<show> showList = new ArrayList<show>();
		
		
		while(true) {
			int counter = 1;
			int ccounter =1 ;
			System.out.println("List of Cineplexes");
			for (Cineplex c : cineplexesList) {
				System.out.println(counter + "." + c.getCineplexName());
				counter++;
			}
			System.out.println("Please select one of cineplexes above! ");

			while(sc.hasNext()) {
				selection = sc.nextLine();

				if (tryParseInteger(selection)) {
					int temp = Integer.parseInt(selection) - 1;
					if (temp < cineplexesList.size()) {
						selectedCineplex = cineplexesList.get(temp);
						for (Cinema c : cinemasList) {
							System.out.println(ccounter + "." + c.getCinemaName());
							ccounter++;
						
						}
						System.out.println("Please select one of cinemas above! ");
						String selectionCinema =sc.nextLine();
						if (tryParseInteger(selectionCinema)) {
							int k = Integer.parseInt(selectionCinema) - 1;
							if(k<cinemasList.size()) {
								selectedCinema = cinemasList.get(k);
								System.out.println("1. Create a new Cinema Show Time"
										+ 	"2. Update a Cinema Show Time"
										+ 	"3. Remove a Cinema Show Time");
								System.out.print("Select an option: ");
								int choice = sc.nextInt();
								switch(choice) {
								case 1: 
									
									String dateTime=null;
									int screenNum,cineplexID=  (Integer) null;
									Object movie = null;
									
									System.out.println("Please select one movie to add to the cinema show time");
									 for(int i=0; i< movies.size();i++)
							            	System.out.printf("%d) "+movies.get(i).getMovieName()+"\n",i+1);
									 System.out.print("Please select a Movie Number: ");
							            int mov_num = sc.nextInt();
							            movie mov = movies.get(mov_num);
							         System.out.print("Please enter a Time ");
							            dateTime = sc.nextLine();
							         cineplexID=cineplexesList.get(temp).getCineplexId();
							         show newShow = new show(mov,dateTime,cineplexID,screenNum,is3D);
							        
								case 2: 

						    		
									cineplexesList = Master.getCineplexes();
						            show s;
						            for(int i=0; i< showList.size();i++)
						            	System.out.printf("%d) "+cinemasList.get(k).getCinemaShows()+"\n",i+1);
						            
						            System.out.print("Please select a Show Number: ");
						            int show_num = sc.nextInt();
						       
						            
						            System.out.println("Enter new Show Time for the movie ");
									sc.nextLine();
						            String newTime = sc.nextLine();
						            
						            cinemasList.get(k).getCinemaShows(show_num).setShowingTime(newTime); 
						            
									System.out.println("");
									
									System.out.println(AdminChangeStatus.SUCCESSFUL.returningStatus());
									
									System.out.println("");
									
									break;
									
								case 3: 

									cineplexesList = Master.getCineplexes();
						     
						            for(int i=0; i< showList.size();i++)
						            	System.out.printf("%d) "+cinemasList.get(k).getCinemaShows()+"\n",i+1);
						            
						            System.out.print("Please select a Show Number: ");
						            int show_num_1 = sc.nextInt();
						            
						            master.deleteShow(show_num_1-1);
						            
						            System.out.println("");
						            
						            System.out.println(AdminChangeStatus.SUCCESSFUL.returningStatus());
									
									System.out.println("");
									
									break;
								
								default: System.out.print("Invalid Input, Please Try Again!");
										 break;
								
							}else {
								System.out.println("Wrong cinema selected! Please try again!");
								continue;
							}
						} else{
							System.out.println("Input cannot be recognised! Please try again!");
						}
					} else {
						System.out.println("Wrong cineplex selected! Please try again!");
						continue;
					}
				 
				} else {
					System.out.println("Input cannot be recognised! Please try again!");
				}
			}
		}
	
}
