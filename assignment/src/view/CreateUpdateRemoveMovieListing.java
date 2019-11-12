package view;

import java.util.*;

import model.AdminChangeStatus;
import model.movie;
import model.*;

public class CreateUpdateRemoveMovieListing {

	private master Master;
	
	public CreateUpdateRemoveMovieListing(master m){
		Master = m;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("1. Create a new Movie Listing\n"
				+ 	"2. Update a Movie Listing\n"
				+ 	"3. Remove a Movie Listing");
		
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
			
			while(incorrectInput) {
				System.out.print("Enter Movie Status (COMING_SOON, PREVIEW, NOW_SHOWING): ");
				showingStatus = sc.nextLine();
				
				if(showingStatus != "COMING_SOON" || showingStatus != "PREVIEW" || showingStatus != "NOW_SHOWING") {
					System.err.println("Please enter a valid Movie Status!");
				} else {
					incorrectInput = false;
				}
			}
			
			System.out.print("Enter Synopsis: ");
			Synopsis = sc.nextLine();
			
			incorrectInput = true;
			int num =0;
			
			while(incorrectInput) {
				
				try {
				System.out.println("Enter the number of Cast in the movie (MAX 5): ");
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
			
			
			
			for(int i = 0; i < num; i++) {
				System.out.print("Enter Cast No. " + i + " Name: ");
				Cast[i] = sc.nextLine();
				System.out.println("");
			}
			
			System.out.println("");
			
			String[] rev = new String[0]; 
			double[] rat = new double[0]; 
						
			movie newMovie = new movie(name,director,rev,rat,showingStatus, Synopsis, Cast);
			
			master.addMovieListing(newMovie);
			
			
			System.out.println(AdminChangeStatus.SUCCESSFUL.returningStatus());
			
			System.out.println("");
			
			break;
			
			
		case 2: 
			
			
			
			break;
			
		case 3: 
			
			
			
			break;
		
		default: System.out.print("Invalid Input, Please Try Again!");
				 break;
		
		}
		
		
	}

}
