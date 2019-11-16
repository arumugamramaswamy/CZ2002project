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
    int selection = 0;
    int user = 0;
    String str;
    int v;
	boolean flag1 = false;

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
    
    boolean inputValidation = true;	
    
    while(inputValidation) {
   
 
    	
    	try {
    	
    		System.out.print("Enter your choice: ");
    		
    	user = sc.nextInt();
    	
    	inputValidation = false;
    	
    	} catch (Exception e) {
    		System.err.println("Invalid Input, Please Try Again!");
    		System.out.println("");
    		sc.nextLine();
    		
    	}
    }
        
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
                
                
                inputValidation = true;	
                
                while(inputValidation) {
               
             
                	
                	try {
                	
                		System.out.print("Enter your choice: ");
                		
                    selection = sc.nextInt();
                	
                	inputValidation = false;
                	
                	} catch (Exception e) {
                		
                		
                		System.err.println("Invalid Input, Please Try Again!");
                		System.out.println("");
                		sc.nextLine();
                		
                	}
                }
                

                switch (selection)
                {	//List all movies and movie details.
                    case 1: 
                    		ArrayList<movie> movies=new ArrayList<movie>();
                    		
                    		movies = Master.getMovies();
                            movie mov;
                            show s;

                            
                            do {	
                            	
                                System.out.println("");
                                System.out.println("-- All Movies --");
                                for(i=0; i< movies.size();i++)
                                	System.out.printf("%d) "+movies.get(i).getMovieName()+"\n",i+1);
                            	
                            	System.out.print("\n"
                                    + "Please make a selection:\n"
                                    + " 1) Select Movie\n"
                                    + " 2) Back\n");
                            

                            inputValidation = true;	
                            
                            while(inputValidation) {
                           
                            	try {
                            	
                            		System.out.print("Enter your choice: ");
                            		
                           selection = sc.nextInt();
                            	
                            	inputValidation = false;
                            	
                            	} catch (Exception e) {
                            		
                            		System.out.println("");
                            		System.err.println("Invalid Input, Please Try Again!");
                            		System.out.println("");
                            		sc.nextLine();
                            		
                            	}
                            }
                                  
                                    
                                    if (selection >= 3) {
                                    	System.out.println("");
                                    	System.err.print("Invalid Input, Please Try Again!"); 
                                    	System.out.println("");
                                    }
                                    
                                    if (selection == 1) {
                                    	
                                    	

                                        inputValidation = true;	
                                        
                                        while(inputValidation) {
                                       
                                        	try {
                                        	
                                        		System.out.print("Please select a Movie Index to list its Details and Shows: ");
                                      
                                        		
                                       selection = sc.nextInt();
                                        	
                                        	inputValidation = false;
                                        	
                                        	} catch (Exception e) {
                                        		
                                        		System.out.println("");
                                        		System.err.println("Invalid Input, Please Try Again!");
                                        		System.out.println("");
                                        		sc.nextLine();
                                        		
                                        	}
                                        }
                                    	
                                    	
                                    	if (selection > movies.size()) {
                                    		System.out.println("");
                                    		System.err.println("Invalid Input, Please Try Again!");
                                    		continue;
                                    	}
                                    	
                                    	System.out.println("");
                                    	System.out.println("-------------------");
                                    	mov = movies.get(selection-1);
                    					System.out.println("Movie Name: " + mov.getMovieName());
                    					System.out.println("Director Name: " + mov.getDirectorName());
                    					System.out.print("Review(s): ");
                    					String [] reviews = mov.getReviews();
                    					
                    					if(reviews.length == 0) {
                    					
                    						System.out.println("No Reviews");
                    						
                    					} else {
                    					for(int x =0;x<reviews.length;x++) 
                    						System.out.printf("%s ",reviews[x]);
                    					
                    					System.out.printf("\n");
                    					
                    					}
                    					
                    					System.out.print("Rating(s): ");
                    					double [] ratings = mov.getAllRatings();
                    					
                    					if (ratings.length == 0) {
                    						System.out.println("No Ratings");
                    					} else {
                    		
                    					for(int x =0;x<ratings.length;x++) 
                    						System.out.printf("%f ",ratings[x]);
                    					System.out.printf("\n");
                    					
                    					}
                    					
                    					System.out.print("Movie Status: ");
                    					System.out.println(mov.getShowingStatus());
                    					
                    					System.out.print("Synopsis: ");
                    					System.out.println(mov.getSynopsis());
                    					String[] Cast = mov.getCast();
                    					
                    					System.out.print("Cast: ");
                    					for(int x = 0;x < Cast.length; x++) {
                    						if(Cast[x].equals("null")) {
                    							continue;
                    						}
                    						System.out.printf("%s # ",Cast[x]);
                    						
                    					}
                    					
                    					System.out.println("");
                    					System.out.println("-------------------");

                    					ArrayList<show> temp = mov.getShows();
                    					
                    					
                    					for (int k =0 ;k<temp.size();k++) {
                    						s = temp.get(k);
                    						System.out.printf("\n\nShow No: %d\n",k+1);
                    						System.out.print("Show Time: ");
                    						System.out.println(s.getDateTime());
                    						System.out.printf("Cineplex ID: %d\n",s.getCineplexID()+1);
                    						System.out.printf("Cinema ID: %d\n",s.getScreenNum()+1);
                    						// s.printSeats();
                    						System.out.println("");
                    						System.out.println("-------------------");
                    						
                    					}
                    					
                                    }
                            } while(selection!= 2);
                            
                            break;
                    
                    //Check seat availability and selection of seat(s).        
                    case 2:  
                    	
                    	boolean looper = true;
                    	
                    
                    	
                    	int choice_1 = 0;
                    	int cinema_id = 0;
                    	
                    	System.out.println("");
                        System.out.println("-- Check seat availability --");
                        System.out.println("");
                        
                		ArrayList<Cineplex> Cineplexes_1 =new ArrayList<Cineplex>();
                		
                		Cineplexes_1 = Master.getCineplexes();
                        
                        for(i=0; i< Cineplexes_1.size();i++)
                        	System.out.printf("%d) "+Cineplexes_1.get(i).getCineplexName()+"\n",i+1);
                        
                        System.out.println(i+1 + ") Back");
                        
                        System.out.println("");
                        
                       
                        
                        inputValidation = true;	
                        
                        while(inputValidation) {
                       
                        	try {
                        	
                        		 System.out.print("Select a Cineplex: ");
                        	
                        		
                        		 choice_1 = sc.nextInt();
                        	
                        		 if ((choice_1-1) > Cineplexes_1.size()) {
                        			 System.out.println("");
                             		System.err.println("Invalid Input, Please Try Again!");
                             		System.out.println("");
                             		sc.nextLine();
                             		continue;
                        		 }
                        	
                        	inputValidation = false;
                        	
                        	} catch (Exception e) {
                        		
                        		System.out.println("");
                        		System.err.println("Invalid Input, Please Try Again!");
                        		System.out.println("");
                        		sc.nextLine();
                        		
                        	}
                        }
                        
                        
                   	 
               		 if(choice_1 != (i+1)) {
                        
                        inputValidation = true;	
                        
                        while(inputValidation) {
                       
                        	try {
                        	      
                                System.out.print("Select a Screen (1 / 2 / 3): ");
                        		
                        	    cinema_id = sc.nextInt();
                                 
                        	    if (cinema_id > 3) {
                       			 System.out.println("");
                            		System.err.println("Invalid Input, Please Try Again!");
                            		System.out.println("");
                            		sc.nextLine();
                            		continue;
                       		 }
                       	
                        	    
                        	    
                        	inputValidation = false;
                        	
                        	} catch (Exception e) {
                        		
                        		System.out.println("");
                        		System.err.println("Invalid Input, Please Try Again!");
                        		System.out.println("");
                        		sc.nextLine();
                        		
                        	}
                        }
                        
                        
                   
                        System.out.println("");
                        
                        System.out.println("-- All Movies in the Selected Cinema: --");
                        System.out.println("");
                        
                        ArrayList<show> s1 = Master.getCineplexes().get(choice_1-1).getCinemaList().get(cinema_id-1).getCinemaShows();
                        
                        for(show s_1:s1) {
                        	s_1.printSeats();
                        }
                        
               		 }
                        
                            break;
                    
                    //Book and purchase movie ticket(s).
                    case 3: //Initialising variables for this case. 
                    	
                    	ArrayList<movie> movies_2 =new ArrayList<movie>();
                    	movies_2 = Master.getMovies();
                    	
                    	System.out.println("");
                        System.out.println("-- Book and purchase movie ticket(s) --");
                        
                    		int customerID = 0, movieID = 0;
                    		String movieBooked, temp, firstseat;
                    		int numseats;
                    		movie m;
                    		movies = Master.getMovies();
                    		
                    		MovieGoerIO mgio = new MovieGoerIO();
                    		//Enter customer ID. 
                    		
                    		 inputValidation = true;	
                             
                             while(inputValidation) {
                            
                             	try {
                             	      
                            		System.out.print("Enter customer ID: ");

                             		
                             		sc.nextLine();
                             		customerID = sc.nextInt();

                             	    
                             	inputValidation = false;
                             	
                             	} catch (Exception e) {
                             		
                             		System.out.println("");
                             		System.err.println("Invalid Input, Please Try Again!");
                             		System.out.println("");
                             		sc.nextLine();
                             		
                             	}
                             }
                             
       
                    		System.out.print ("Enter customer Name: ");
                    		sc.nextLine();
                    		String customerName = sc.nextLine();
                    		
                    		
                    		System.out.print ("Enter Phone Number: ");
                    		
                    		int phoneNumber = sc.nextInt();
                    		
                    		System.out.print ("Enter your email-ID: ");
                    		sc.nextLine();
                    		String emailID = sc.nextLine();
                    		
                    		
                    		
                    		 inputValidation = true;	
                    		 
                    		 String movieGoerCategory = null;
                    		 
                    		 while(inputValidation) {
                    		
                    			System.out.print ("Enter Movie Goer Category (Adult / SeniorCitizen / Child): ");
                    		
                         	
                    			 movieGoerCategory = sc.nextLine();
                    			 
                    			
                    			 
                    			 if(movieGoerCategory.equals("Adult") || movieGoerCategory.equals("SeniorCitizen" )|| movieGoerCategory.equals("Child")) {
                    				
                    				 inputValidation = false;
                                 	
                    			 } else {
                    				System.out.println("");
                              		System.err.println("Invalid Input, Please Try Again!");
                              		System.out.println("");
                    			 }
                    		
                    		 }
                    		
                    		System.out.println("");
                    		
                    		boolean publicHoliday = false;
                    		
                    		System.out.println("-- All Movies --");
                    		
                    		for(i=0; i< movies_2.size();i++)
                            	System.out.printf("%d) "+movies_2.get(i).getMovieName()+"\n",i+1);
                    		
                    		System.out.println("");
                    		
                    		//Enter movie ID to be booked, retrieve movie name from movies. 
                    		
                    		inputValidation = true;	
                             
                             while(inputValidation) {
                            
                             	try {
                             	      
                             		System.out.print("Enter Movie ID to be booked: ");
                            		sc.hasNextLine();
                            		movieID = sc.nextInt();
 
                            		if(movieID > movies_2.size()) {
                            			System.out.println("");
                                 		System.err.println("Invalid Input, Please Try Again!");
                                 		System.out.println("");
                                 		sc.nextLine();
                            		} else {
                            		
                             	inputValidation = false;
                            		}
                             	
                             	} catch (Exception e) {
                             		
                             		System.out.println("");
                             		System.err.println("Invalid Input, Please Try Again!");
                             		System.out.println("");
                             		sc.nextLine();
                             		
                             	}
                             }
                             
                             inputValidation = true;
                    		
                    		while(true)
                    		{
                    			if (movieID > movies.size()) {
                    				
                             		System.err.println("Invalid Input, Please Try Again!");
                             		
                            		sc.nextLine();
                            		continue;
                    			}
                            	m = movies.get(movieID-1);
                            	movieBooked = m.getMovieName();
                            	break; 
                    		}
                    		String[] holidays = null;
                    	    holidyIO h = new holidyIO();
                    	    try {
                    	    holidays = h.readHolidays();
                    	    }catch(Exception e) {
                    	    	System.out.println(e);
                    	    }
                    		
                    	    String tempstring;
                    	    
        					ArrayList<show> temp_1 = m.getShows();
        					
        					for (int k =0 ;k<temp_1.size();k++) {
        						publicHoliday = false;
        						s = temp_1.get(k);
        						tempstring = s.getDateTime().split(" ")[0];
        						for (v=0;v<holidays.length;v++) {
        							if (holidays[v].equals(tempstring)) {
        								publicHoliday = true;
        								break;
        							}
        						}
        						str = Master.getCineplexes().get(s.getCineplexID()).getCinemaList().get(s.getScreenNum()).getCinemaClass();
        						MovieTicket price = new MovieTicket(s.get3D(), str, movieGoerCategory, publicHoliday);
        						System.out.printf("\n\nShow %d:\n",k+1);
        						System.out.println("Date Time: " + s.getDateTime());
        						System.out.printf("Cineplex ID: %d\n",s.getCineplexID()+1);
        						System.out.printf("Cinema ID: %d\n",s.getScreenNum()+1);
        						System.out.printf("Cinema Class: %s\n", str);
        						System.out.printf("3D: %s\n", s.get3D());
        						System.out.printf("Ticket Price: S$%s (Inclusive of GST)\n", price.getPrice());
        						System.out.println("----------------");
        						
        					}
                    		
        					System.out.println("");
                    		
        					
                    		System.out.print("Enter Show Index: ");
                    		sc.nextLine();
        		        	int index = sc.nextInt();
        		        	int showindex = index-1;
        		        	
                    		//Enter first seat.
        		        	s = temp_1.get(showindex);
        		        	s.printSeats();
        		        	
        		        	System.out.println("");
                    		System.out.print("Enter first seat (Enter as 'a1' for row-1 seat-1 or 'd5' for row-4 seat-5): ");
                    		sc.nextLine();
        		        	firstseat = sc.nextLine();
        		        	
        		        	System.out.print("Enter number of seats: ");
        		        	numseats = sc.nextInt();
        		        	
        		        	TransactionID T = new TransactionID(s.getCineplexID());
        		        	String TID = T.getTID();
        		     
        		        	String bookingID = TID;
        		        	char ch = firstseat.charAt(0);
        		    		int firstseatnum = Character.getNumericValue(firstseat.charAt(1))-1;
        		        	int row = ch - 'a';
        		        	for (int t =0;t<numseats;t++) {
        		        		if (s.checkSeat(row, firstseatnum+t)){
        		        			flag1 = true;
        		        		}
        		        	}
        		        	if (!flag1) {
        		        	mgio.assignFinalSeatsbyMovie(m, showindex, customerName, customerID, emailID, phoneNumber, bookingID, numseats, firstseat);
        		        	
        		        	System.out.println("");
        		        	System.out.println("--------------------------------------------");
        		        	System.out.println("Your Movie Tickets have been successfuly booked!");
        		        	System.out.println("Transaction ID: " + bookingID);
        		        	System.out.println("--------------------------------------------");
        		        	System.out.println("");
        		        	
                    		/* Enter specific show to book for movie. */
                    		/*System.out.println("Enter show:");*/
                    		
                            break;
        		        	}
        		        	else {
        		        		System.out.println("");
        		        		System.err.println("Please select different seats, a few of these seats are occupied.");
        		        		System.out.println("");
        		        		break;
        		        	}
        		      
                    // View booking history.        
                    case 4: //Inititalising for this case. 
                    		
                    		System.out.println("");
                    		System.out.println("-- View Booking History --");
                    		int id;
                    		MovieGoerIO M = new MovieGoerIO(); 
                    		MovieGoer moviegoer = new MovieGoer();
                    		ArrayList<Booking> customerbookings = new ArrayList<>();
                    		
                    		//Accepting Customer ID to retrieve booking history. 
                    		System.out.print("Please enter Customer ID to view booking history: ");
                    		id = sc.nextInt();
                    		
                    		//Get corresponding MovieGoer object from MoverGoerIO class using CustomerID. 
                    		moviegoer = M.getMovieGoer(id);
                    		
                    		//Use MovieGoer object to retrieve customerbooking ArrayList for corresponding cutomer ID. 
                    		customerbookings = moviegoer.getBooking();
                    		System.out.println("");
                    		//Iterate through customerbookings ArrayList to print movie names of bookings made by customer. 
                    		for(i=0; i< customerbookings.size(); i++) {
                    			System.out.println("----------------------------");
                    			System.out.println("Customer Email ID: " + customerbookings.get(i).getemailID());
                    			System.out.println("Movie Booked: " + customerbookings.get(i).getmovieBooked());
                    			System.out.println("Date & Time: " + customerbookings.get(i).getDateTime());
                    			System.out.println("Number of Seats booked: " + customerbookings.get(i).getnumseats());
                    			System.out.println("FirstSeat booked: " + customerbookings.get(i).getfirstseat());
                    			System.out.println("Transaction ID: " + customerbookings.get(i).getbookingID());
                    			System.out.println("----------------------------");
                    			System.out.println();
                    		}
				
				//have to handle case of invalid custID
                    		
                            break;
                            
                    //List the top 5 movies ranking by ticket sales OR by overall reviewers' ratings.
                    case 5: do {System.out.println("\n"
			                + "List top 5 movies according to:\n"
			                + " 1) Ticket sales.\n"
			                + " 2) Overall reviewers' ratings.\n"
			                + " 3) Back.\n");
                    		
                    		//getting user's selected option
                    		System.out.print("Enter a Choice: ");
                    		selection= sc.nextInt();
                    		 
                    		//extracting list of all movies (movie objects)
                    		movies = Master.getMovies();
                    		System.out.println("");
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
                        System.out.println("");
                        System.out.println("--- All Cineplexes ---");
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
                	    System.out.println("");
                    	System.out.println("Thank you for using our Application!");
                        Master.saveCineplexes();
                        Master.saveMovies();
                        tempMovList = Master.getMovies();
                        
                        for (movie movi: tempMovList) {
                        	movi.saveShowDetails();
                        }
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
	                    		System.out.println("");
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
	                            
	                    case 3: 
	                    	System.out.println("");
	                    	ConfigureTicketPrices CTP = new ConfigureTicketPrices();
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
	                    	    System.out.println("");
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
            Master.saveCineplexes();
            Master.saveMovies();
            tempMovList = Master.getMovies();
            
            for (movie mov: tempMovList) {
            	mov.saveShowDetails();
            }
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
