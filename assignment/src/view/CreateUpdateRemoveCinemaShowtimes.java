package view;

import java.util.ArrayList;
import java.util.Scanner;

import model.AdminChangeStatus;
import model.Cineplex;
import model.master;
import model.movie;
import model.show;

public class CreateUpdateRemoveCinemaShowtimes {
	
private static master Master;
	
	
	public CreateUpdateRemoveCinemaShowtimes(master m){
		Master = m;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		ArrayList<movie> movies=new ArrayList<movie>();
		int i;
		
		ArrayList<Cineplex> Cineplexes_1 =new ArrayList<Cineplex>();
		
		Cineplexes_1 = Master.getCineplexes();
        
        for(i=0; i< Cineplexes_1.size();i++)
        	System.out.printf("%d) "+Cineplexes_1.get(i).getCineplexName()+"\n",i+1);
        
        System.out.println("");
        
        System.out.print("Select a Cineplex: ");
        int choice_1 = sc.nextInt();
        
        System.out.print("Select a Screen (1 / 2 / 3): ");
        int cinema_id = sc.nextInt();
       
        System.out.print("Is the Movie 3D? (true/false): ");
        boolean threed = sc.nextBoolean();
        
        System.out.print("Enter the Date Time:  ");
        String s_1 = sc.nextLine(); 
		
        System.out.println("");
        
        movies = Master.getMovies();
		
        movie mov;
        show s;
        System.out.println("-- All Movies --");
        
        for(i=0; i< movies.size();i++)
        	System.out.printf("%d) "+movies.get(i).getMovieName()+"\n",i+1);
        
        System.out.println("");
        
        System.out.print("Please select a Movie to be added: ");
        int mov_num = sc.nextInt();
        
        movie m = movies.get(mov_num-1);
        
        s = m.createShowListing(s_1, cinema_id, choice_1, threed);
        
        Cineplexes_1.get(choice_1-1).getCinemaList().get(cinema_id-1).addShow(s);
        
        Master.setCineplexes(Cineplexes_1);
	}


}
