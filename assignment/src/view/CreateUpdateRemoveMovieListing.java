package view;

import java.util.*;

import model.AdminChangeStatus;
import model.movie;

public class CreateUpdateRemoveMovieListing {

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
			
			String name, director, showingStatus, Synopsis;
			String[] Cast = new String[5];
			
			sc.nextLine();
			
			System.out.print("Enter Movie Name: ");
			name = sc.nextLine();
			
			System.out.print("Enter Director's Name: ");
			director = sc.nextLine();
			
			System.out.print("Enter showingStatus (COMING_SOON, PREVIEW, NOW_SHOWING): ");
			showingStatus = sc.nextLine();
			
			System.out.print("Enter Synopsis: ");
			Synopsis = sc.nextLine();
			
			System.out.println("Enter the number of Cast in the movie (MAX 5): ");
			int num = sc.nextInt();
			
			sc.nextLine();
			
			for(int i = 0; i < num; i++) {
				System.out.print("Enter Cast No. " + i + " Name: ");
				Cast[i] = sc.nextLine();
				System.out.println("");
			}
			
			System.out.println("");
			
			movie newMovie = new movie(name, director, showingStatus, Synopsis, Cast);
			
			
			// -- arumugam master code --
			
			
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
