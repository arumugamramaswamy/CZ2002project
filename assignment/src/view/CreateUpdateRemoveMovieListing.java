package view;

import java.util.*;
import java.io.*;
import model.*;

/**
 * UI Class to Create, Update, Remove Movie Listings
 * @version 1.0
 *
 */
public class CreateUpdateRemoveMovieListing {

	private static master Master;
	
	/**
	 * Initialises the master class which calls the backend of the application
	 * @param m object of the UI master class
	 */
	public CreateUpdateRemoveMovieListing(master m){
		Master = m;
	}
	
	/**
	 * UI to Create, Update and Remove Movie Listings
	 * @param args	argument
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		/**
		 * used to go back to the main program
		 */
		boolean back_btn = false;
		
		ArrayList<movie> movies = new ArrayList<movie>();
		int i;
		
		System.out.println("1. Create a new Movie Listing\n"
				+ 	"2. Update a Movie Listing\n"
				+ 	"3. Remove a Movie Listing\n"
				+   "4. Back");
		
		System.out.println("");
		
		System.out.print("Select an option: ");
		int choice = sc.nextInt();
		
		switch(choice) {
		
		case 1: 
			
			String name, director, showingStatus = null, Synopsis;
			String[] Cast = new String[5];
			
			sc.nextLine();
			
			System.out.print("Enter Movie Name: ");
			name = sc.nextLine();
			
			System.out.print("Enter Director's Name: ");
			director = sc.nextLine();
			
			boolean incorrectInput = true;
			

				System.out.print("Enter Movie Status (COMING_SOON, PREVIEW, NOW_SHOWING): ");
				showingStatus = sc.nextLine();
				showingStatus = showingStatus.trim();

			System.out.print("Enter Synopsis: ");
			Synopsis = sc.nextLine();
			
			incorrectInput = true;
			int num =0;
			
			while(incorrectInput) {
				
				try {
				System.out.print("Enter the number of Cast in the movie (MAX 5): ");
				num = sc.nextInt();
				sc.nextLine();
					if(num <= 5) {
					incorrectInput = false;
					} else {
						System.err.println("Please enter a valid number!");
					}
				} catch(Exception e) {
					System.err.println("Please enter a valid number!");
				}
			}

			
			for(i = 0; i < num; i++) {
				System.out.printf("Enter Cast No. %d Name: ",(i+1));
				Cast[i] = sc.nextLine();
				System.out.println("");
			}
			
			String[] rev = new String[0]; 
			double[] rat = new double[0]; 
						
			movie newMovie = new movie(name,director,rev,rat,showingStatus, Synopsis, Cast, 0);
			
			master.addMovieListing(newMovie);
			
			System.out.println("");
			
			System.out.println(AdminChangeStatus.SUCCESSFUL.returningStatus());
			
			System.out.println("");
			
			break;
			
			
		case 2: 

    		movies = Master.getMovies();
    		
            movie mov;
            show s;
            for(i=0; i< movies.size();i++)
            	System.out.printf("%d) "+movies.get(i).getMovieName()+"\n",i+1);
            
            System.out.print("Please select a Movie Number: ");
            int mov_num = sc.nextInt();
            
            System.out.print("Current Status of the Movie: ");
            
            System.out.println(movies.get(mov_num-1).getShowingStatus());
            
            System.out.println("Enter new Status of the Movie (COMING_SOON, PREVIEW, NOW_SHOWING): ");
			sc.nextLine();
            String newStatus = sc.nextLine();
            
            movies.get(mov_num-1).setShowingStatus(newStatus); 
            
			System.out.println("");
			
			System.out.println(AdminChangeStatus.SUCCESSFUL.returningStatus());
			
			System.out.println("");
			
			break;
			
		case 3: 

    		movies = Master.getMovies();
            movie mov_1;
            show s_1;
            for(i=0; i< movies.size();i++)
            	System.out.printf("%d) "+movies.get(i).getMovieName()+"\n",i+1);
            
            System.out.print("Please select a Movie Number: ");
            int mov_num_1 = sc.nextInt();
            File file = new File("data/Shows/"+movies.get(mov_num_1-1).getMovieName()+".txt");
            file.delete();
            Master.deleteMovie(mov_num_1-1);
            System.out.println("");
            
            System.out.println(AdminChangeStatus.SUCCESSFUL.returningStatus());
			
			System.out.println("");
			
			break;
			
		case 4: back_btn = true;
			
				break;
		
		default: System.out.print("Invalid Input, Please Try Again!");
				 break;
		
		}
		
		if(back_btn == true) {
			return;
		}
		
	}

}
