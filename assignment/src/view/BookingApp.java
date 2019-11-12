package view;

import model.*;
import controller.*;
import java.util.*;

public class BookingApp {
	public static void main(String[] args) {

    Scanner sc= new Scanner(System.in);
    
    /* outer do-while loop determines the user mode (STAFF/CUSTOMER) & runs corresponding allowable actions
       in individual do-while loops  
    */
    int selection;
    int user;
    master Master = new master();
    Master.readMovies();
    Master.readCineplexes();

//    System.out.println(Master.getCineplexes());
    System.out.println(Master.getCineplexes().get(0));
    do { System.out.print("\n"
                            + "Welcome to MOBLIMA! Please select a user mode:\n"
                            + "1) Customer\n"
                            + "2) Staff\n");  
		    user= sc.nextInt();
        
        if(user==1) {
        	

            //do-while loop for user= CUSTOMER 
            do {   System.out.print("\n"
                + "Welcome to MOBLIMA! Please make a selection:\n"
                + " 1) Search/List all movies.\n"
                + " 2) View Movie details - including reviews and ratings.\n"
                + " 3) Check seat availability and selection of seat(s).\n"
                + " 4) Book and purchase movie ticket(s).\n"
                + " 5) View booking history.\n"
                + " 6) List the top 5 ranking by ticket sales OR by overall reviewers' ratings.\n"
                + " 7) Search/List all Cinplexes.\n"
                + " 8) Quit MOBILMA.\n"
                + " Enter your choice below:\n");
                selection = sc.nextInt();

                switch (selection)
                {
                    case 1:
                    		ArrayList<movie> movies=new ArrayList<movie>();
                    		
                    		int i;
                    		movies = Master.getMovies();
                            
                            for(i=0; i< movies.size();i++)
                            	System.out.printf("%d) "+movies.get(i).getMovieName()+"\n",i+1);
                            
                            break;
                    case 2: 
                            break;
                    case 3:  
                            break;
                    case 4:
                            break;
                            
                    case 5: int id;
                    		MovieGoerIO M = new MovieGoerIO(); 
                    		MovieGoer moviegoer = new MovieGoer();
                    		ArrayList<Booking> customerbookings = new ArrayList<>();
                    		
                    		System.out.println("Please enter Customer ID to view booking history:");
                    		id= sc.nextInt();
                    		
                    		moviegoer = M.getMovieGoer(id);
                    		customerbookings = moviegoer.getBooking();
                    				
                    		for(i=0; i< customerbookings.size(); i++)
                    			System.out.println(customerbookings.get(i));
                    		
                            break;
                    case 6: 
                            break;
                    case 7: 
                		ArrayList<Cineplex> Cineplexes=new ArrayList<Cineplex>();
                		
                		Cineplexes = Master.getCineplexes();
                        
                        for(i=0; i< Cineplexes.size();i++)
                        	System.out.printf("%d) "+Cineplexes.get(i).getCineplexName()+"\n",i+1);
                        
                        
                        break;

                    case 8: System.out.println("Thank you for using our Application!");
                    		System.exit(0);
                    		break;

                    default: System.out.print("Invalid Input, Please Try Again!"); 
                }
                
            } while(true);
        
        }
        
        else if(user==2) {

            // do-while loop for user = STAFF
        	
        	boolean incorrectInput = true;
        	int username = -1; // initialize as a negative 
        	String password = null;
        	
        	System.out.println("Please LOGIN to continue:");
        	
        	int flag = 0;
        	
        	do {
        	
        	while (incorrectInput) {
        		
	        	try {
		        	System.out.print("Enter Password: ");
		        	sc.nextLine();
		        	password = sc.nextLine();
		        	incorrectInput = false;
	        	}
	        	catch (Exception e) {
	        		System.err.println(LoginStatus.FAILED.returningStatus());
	        		sc.nextLine();
	        	}
        	}


        	PasswordHasher login = new PasswordHasher();
        	
        	if(login.checkPass(password) == false) {
        		System.err.println(LoginStatus.FAILED.returningStatus());
        
        	} else {
        	flag = 1;
        	
        	System.out.println(LoginStatus.SUCCESSFUL.returningStatus());
        	
            do { System.out.print("\n"
                + "Welcome to MOBLIMA! Please make a selection\n"
                + " 1) Create/Update/Remove Movie Listing\n"
                + " 2) Create/Update/Remove cinema showtimes and movies to be shown\n"
                //System settings include ticket prices, holidays
                + " 3) Configure Ticket Prices \n"
                + " 4) Quit MOBLIMA\n"
                + " Enter your choice below:\n");

                selection= sc.nextInt();

                switch (selection)
                {
                    case 1: 
                            break;
                    case 2: 
                            break;
                    case 3: ConfigureTicketPrices CTP = new ConfigureTicketPrices();
                    		CTP.main(args);
                            break;
                    case 4: System.out.println("Thank you for using our Application!");
                    		System.exit(0);
                    default: System.out.print("Invalid Input, Please Try Again!"); 
                }

            } while(selection != 4);
            
        }
        	
        } while(flag == 1);
        	
        }
        	
        } while(user == 1 || user == 2);

    }

}
