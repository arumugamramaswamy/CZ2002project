package view;

import model.*;
import controller.*;

import java.io.IOException;
import java.util.*;

public class BookingApp {
	
	public static void main(String[] args) throws IOException, Exception {

    Scanner sc= new Scanner(System.in);
    
    /* outer do-while loop determines the user mode (STAFF/CUSTOMER) & runs corresponding allowable actions
       in individual do-while loops  
    */
    int selection;
    int user;
    int i;	//common variable for any instance of iteration in this class
    master Master = new master();
    Master.readMovies();
    
    ArrayList<movie> tempMovList = Master.getMovies();
    
    Master.readCineplexes();

    for (movie mov: tempMovList) {
    	mov.readShowDetails(Master);
    }
    
    do { System.out.print("\n"
                            + "Welcome to MOBLIMA! Please select a user mode:\n"
                            + "1) Customer\n"
                            + "2) Staff\n"
                            + "3) Quit MOBLIMA\n");  
		    user= sc.nextInt();
        
        if(user==1) {
        	
        	boolean back_cust = false;

            //do-while loop for user= CUSTOMER 
            do {   System.out.print("\n"
                + "Welcome to MOBLIMA! Please make a selection:\n"
                + " 1) List all movies and movie details\n"
                + " 2) Check seat availability\n" 
                + " 3) Book and purchase movie ticket(s)\n"
                + " 4) View booking history\n"
                + " 5) List the top 5 movies ranking by ticket sales OR by overall reviewers' ratings\n"
                + " 6) List all Cinplexes\n"
                + " 7) Quit MOBILMA\n"
                + " 8) Back\n");
            
                System.out.print("Enter your choice below: ");
                selection = sc.nextInt();

                switch (selection)
                {	//List all movies and movie details.
                    case 1: 
                    		ArrayList<movie> movies=new ArrayList<movie>();
                    		
                    		movies = Master.getMovies();
                            movie mov;
                            show s;
                            System.out.println("");
                            System.out.println("-- All Movies --");
                            for(i=0; i< movies.size();i++)
                            	System.out.printf("%d) "+movies.get(i).getMovieName()+"\n",i+1);
                            
                            do {	System.out.print("\n"
                                    + "Please make a selection:\n"
                                    + " 1) Select Movie\n"
                                    + " 2) Back\n");
                                    selection = sc.nextInt();
                                    
                                    if (selection == 3) {
                                    	System.out.println("");
                                    	System.err.print("Invalid Input, Please Try Again!"); 
                                    	System.out.println("");
                                    }
                                    
                                    if (selection == 1) {
                                    	System.out.print("Please select a Movie Index to list its details and shows: ");
                                    	selection = sc.nextInt();
                                    	if (selection-1 > movies.size()) {
                                    		System.out.println("");
                                    		System.err.println("Please enter a valid movie number!");
                                    		continue;
                                    	}
                                    	
                                    	System.out.println("");
                                    	mov = movies.get(selection-1);
                    					System.out.println(mov.getMovieName());
                    					System.out.println(mov.getDirectorName());
                    					String [] reviews = mov.getReviews();
                    					for(int x =0;x<reviews.length;x++) 
                    						System.out.printf("%s ",reviews[x]);
                    					
                    					System.out.printf("\n");
                    					double [] ratings = mov.getAllRatings();
                    					for(int x =0;x<ratings.length;x++) 
                    						System.out.printf("%f ",ratings[x]);
                    					System.out.printf("\n");
                    
                    					
                    					System.out.println(mov.getShowingStatus());
                    					System.out.println(mov.getSynopsis());
                    					String[] Cast = mov.getCast();
                    					for(int x =0;x<Cast.length;x++) 
                    						System.out.printf("%s ",Cast[x]);
                    					System.out.printf("\n");

                    					ArrayList<show> temp = mov.getShows();
                    					
                    					for (int k =0 ;k<temp.size();k++) {
                    						s = temp.get(k);
                    						System.out.printf("\n\nShow %d:\n",k+1);
                    						System.out.println(s.getDateTime());
                    						System.out.printf("CineplexID: %d\n",s.getCineplexID());
                    						System.out.printf("CinemaID: %d\n",s.getScreenNum());
                    						s.printSeats();
                    					}
                    					
                                    }
                            } while(selection!= 2);
                            
                            break;
                    
                    //Check seat availability and selection of seat(s).        
                    case 2:  
                    	
                    	System.out.println("");
                        System.out.println("-- Check seat availability --");
                        System.out.println("");
                        
                		ArrayList<Cineplex> Cineplexes_1 =new ArrayList<Cineplex>();
                		
                		Cineplexes_1 = Master.getCineplexes();
                        
                        for(i=0; i< Cineplexes_1.size();i++)
                        	System.out.printf("%d) "+Cineplexes_1.get(i).getCineplexName()+"\n",i+1);
                        
                        System.out.println("");
                        
                        System.out.print("Select a Cineplex: ");
                        int choice_1 = sc.nextInt();
                        
                        System.out.print("Select a Screen (1 / 2 / 3): ");
                        int cinema_id = sc.nextInt();
                        
                        System.out.println("");
                        
                        System.out.println("-- All Movies in the Selected Cinema: --");
                        System.out.println("");
                        
                        ArrayList<show> s1 = Master.getCineplexes().get(choice_1-1).getCinemaList().get(cinema_id-1).getCinemaShows();
                        
                        for(show s_1:s1) {
                        	s_1.printSeats();
                        }
                        
                            break;
                    
                    //Book and purchase movie ticket(s).
                    case 3: //Initialising variables for this case. 
                    	
                    	System.out.println("");
                        System.out.println("-- Book and purchase movie ticket(s) --");
                        
                    		int customerID, movieID, firstseat;
                    		String movieBooked;
                    		movie m;
                    		movies = Master.getMovies();
                    		//Enter customer ID. 
                    		System.out.println("Enter customer ID:");
                    		customerID = sc.nextInt();
                    		
                    		//Enter movie ID to be booked, retrieve movie name from movies. 
                    		System.out.println("Enter movie ID of movie to be booked:");
                    		movieID = sc.nextInt();
                    		while(true)
                    		{
                    			if (movieID-1 > movies.size()) {
                            		System.out.println("Please enter a valid movie number");
                            		continue;
                    			}
                            	m = movies.get(movieID-1);
                            	movieBooked = m.getMovieName();
                            	break; 
                    		}
                    		
                    		//Enter first seat.
                    		System.out.println("Enter first seat:");
                    		sc.nextLine();
        		        	firstseat = sc.nextInt();
        		        	
                    		
                            break;
                    
                    // View booking history.        
                    case 4: //Inititalising for this case. 
                    		int id;
                    		MovieGoerIO M = new MovieGoerIO(); 
                    		MovieGoer moviegoer = new MovieGoer();
                    		ArrayList<Booking> customerbookings = new ArrayList<>();
                    		
                    		//Accepting Customer ID to retrieve booking history. 
                    		System.out.println("Please enter Customer ID to view booking history:");
                    		id = sc.nextInt();
                    		
                    		//Get corresponding MovieGoer object from MoverGoerIO class using CustomerID. 
                    		moviegoer = M.getMovieGoer(id);
                    		
                    		//Use MovieGoer object to retrieve customerbooking ArrayList for corresponding cutomer ID. 
                    		customerbookings = moviegoer.getBooking();
                    		
                    		//Iterate through customerbookings ArrayList to print movie names of bookings made by customer. 
                    		for(i=0; i< customerbookings.size(); i++)
                    			System.out.println(customerbookings.get(i).getmovieBooked());
				
				//have to handle case of invalid custID
                    		
                            break;
                            
                    //List the top 5 movies ranking by ticket sales OR by overall reviewers' ratings.
                    case 5: do {System.out.println("\n"
			                + "List top 5 movies according to:\n"
			                + " 1) Ticket sales.\n"
			                + " 2) Overall reviewers' ratings.\n"
			                + " 3) Back.\n");
                    
                    		selection= sc.nextInt();
                    		
                    		movies = Master.getMovies();
                    		
                    		if(selection==1)
                    		{
                    			//sort movies ArrayList according to ticket sales.
                        		Collections.sort(movies,movie.topticketsales);
                        		
                        		//Iterating through movies list to print top five movies
                        		System.out.println("The top 5 movies ranking by total ticket sales are:");
                        		for(i= movies.size() -1 ; i >=0 ; i--)
                        			System.out.println(movies.get(i).getMovieName() + ": " + movies.get(i).getTsales());
                    		}
                    		else if(selection==2)
                    		{
	                    		//sort movies ArrayList according to reviewers' ratings.
	                    		Collections.sort(movies,movie.topratings);
	                    		
	                    		//Iterating through movies list to print top five movies
	                    		System.out.println("The top 5 movies ranking by overall reviwers' ratings are:");
	                    		for(i= movies.size() -1 ; i >=0 ; i--)
	                    			System.out.println(movies.get(i).getMovieName() + ": " + movies.get(i).getTotalRating());
                    		}
                    		else
                    			System.out.println("Invalid input!"); 
                    		
                    		} while(selection!=3);
                            
                            
                    //List all Cineplexes. 
                    case 6: 
                		ArrayList<Cineplex> Cineplexes=new ArrayList<Cineplex>();
                		
                		Cineplexes = Master.getCineplexes();
                        
                        for(i=0; i< Cineplexes.size();i++)
                        	System.out.printf("%d) "+Cineplexes.get(i).getCineplexName()+"\n",i+1);
                        
                        
                        break;
                    
                    //Quit MOBLIMA.     
                    
                    case 7: 
                    	
                    	Master.saveCineplexes();
                	    Master.saveMovies();
                	    tempMovList = Master.getMovies();
                	    for (movie mov1: tempMovList) {
                	    	mov1.saveShowDetails();
                	    }
                    	System.out.println("Thank you for using our Application!");
                		System.exit(0);
                	    break;
                	    
                    
                    case 8: 
                    	Master.saveCineplexes();
                	    Master.saveMovies();
                	    tempMovList = Master.getMovies();
                	    for (movie mov2: tempMovList) {
                	    	mov2.saveShowDetails();
                	    }
                    	back_cust = true;
                    		break;

                    default: 
                    	System.out.println("");
                    	System.err.print("Invalid Input, Please Try Again!"); 
                    	System.out.println("");
                }
                
            } while(!back_cust);
            
            if (back_cust == true) {
            	break;
            }
        
        }
        
     // do-while loop for user = STAFF
        else if(user==2) {

        	// Initializing for user= STAFF. 
        	boolean incorrectInput = true;
        	int username = -1; 
        	String password = null;
        	// To check for Staff Login Authorization (flag==1 means authorized). 
        	int flag = 0;
        	System.out.println("");
        	System.out.println("Please LOGIN to continue:");
        	
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
        
        	} 
        	
        	else {
        	flag = 1;
        	
        	boolean back = false;
        	
        	System.out.println("");
        	System.out.println(LoginStatus.SUCCESSFUL.returningStatus());
        	
            do { System.out.print("\n"
                + "Welcome to MOBLIMA! Please make a selection\n"
                + " 1) Create/Update/Remove Movie Listing\n"
                + " 2) Create/Update/Remove Cinema Showtimes and Movies to be Shown\n"
                //System settings include ticket prices, holidays
                + " 3) Configure Ticket prices\n"
                + " 4) Configure Holidays\n"
                + " 5) Quit MOBLIMA\n"
                + " 6) Back\n"
                + " Please enter your choice below: ");

                selection= sc.nextInt();

                switch (selection)
	                {	
                		//Create/Update/Remove Movie Listing.
	                    case 1: 
	                    	
	                    		System.out.println("-- Create/Update/Remove Movie Listing --");
	                    		CreateUpdateRemoveMovieListing CURML = new CreateUpdateRemoveMovieListing(Master);
	                    		CURML.main(args);
	                    		break;
	                    
	                    //Create/Update/Remove cinema showtimes and movies to be shown.
	                    case 2: 
	                    	
	                    	System.out.println("");
	                    	System.out.println("-- Create/Update/Remove Cinema Showtimes and Movies to be Shown --");
                    		CreateUpdateRemoveCinemaShowtimes CURCS = new CreateUpdateRemoveCinemaShowtimes(Master);
                    		
                    		CURCS.main(args);
	                    	
	                            break;
	                    
	                    //Configure System settings (ticket prices, holidays).       
	                    case 3: ConfigureTicketPrices CTP = new ConfigureTicketPrices();
	                    		CTP.main(args);
	                    		break;
	                    		
	                    //Configure System settings (ticket prices, holidays).
	                    case 4: 
                            	break;
	                    
                        //Quit MOBLIMA.     	
	                    case 5: 
	                    	 	Master.saveCineplexes();
	                    	    Master.saveMovies();
	                    	    tempMovList = Master.getMovies();
	                    	    for (movie mov: tempMovList) {
	                    	    	mov.saveShowDetails();
	                    	    }
	                    		System.out.println("Thank you for using our Application!");
	                    		System.exit(0);
	                    
	                    case 6: 
	                    	Master.saveCineplexes();
                    	    Master.saveMovies();
                    	    tempMovList = Master.getMovies();
                    	    for (movie mov: tempMovList) {
                    	    	mov.saveShowDetails();
                    	    }
	                    	back = true;
	                    	break;
	                    default: System.out.print("Invalid Input, Please Try Again!"); 
	                }

            	} while(!back);
            
            if (back == true) {
            	break;
            }
            
        }
        	
        } while(flag == 1);				  // User= STAFF and authorized (flag=1).
        	
        } else if (user == 3) {
        	System.out.println("");
        	System.out.println("Thank you for using our Application!");
        	System.out.println("");
    		System.exit(0);
        }
        	
        } while(user == 1 || user == 2);  // Select user loop. 

    Master.saveCineplexes();
    Master.saveMovies();
    tempMovList = Master.getMovies();
    
    for (movie mov: tempMovList) {
    	mov.saveShowDetails();
    }
    } // public static void main(String[] args) throws IOException, Exception

} //class BookingApp
