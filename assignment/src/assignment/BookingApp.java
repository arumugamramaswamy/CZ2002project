package assignment;

import java.util.*;

public class BookingApp {
	public static void main(String[] args) {

        Scanner sc= new Scanner(System.in);
    
    /* outer do-while loop determines the user mode (STAFF/CUSTOMER) & runs corresponding allowable actions
       in individual do-while loops  
    */

    do { System.out.print("\n"
                            + "Welcome to MOBLIMA! Please select a user mode:\n"
                            + " 1) Customer\n"
                            + " 2) Staff\n");
         int user= sc.nextInt();
        
        if(user==1)

            //do-while loop for user= CUSTOMER 
            do {   System.out.print("\n"
                + "Welcome to MOBLIMA! Please make a selection:\n"
                + " 1) Search/List all movies.\n"
                + " 2) View Movie details - including reviews and ratings.\n"
                + " 3) Check seat availability and selection of seat(s).\n"
                + " 4) Book and purchase movie ticket(s).\n"
                + " 5) View booking history.\n"
                + " 6) List the top 5 ranking by ticket sales OR by overall reviewers' ratings.\n"
                + " 7) Quit MOBLIMA.\n"
                + " Enter your choice below:\n");

                int selection= sc.nextInt();

                switch (selection)
                {
                    case 1:  
                            break;
                    case 2: 
                            break;
                    case 3:  
                            break;
                    case 4:
                            break;
                    case 5: 
                            break;
                    case 6: 
                            break;
                    default: System.out.print("Invalid input, please try again!"); 
                }
                
            } while(selection != 7);
        
        else if(user==2)

            //do-while loop for user= STAFF
            do { System.out.print("\n"
                + "Welcome to MOBLIMA! Please make a selection\n"
                + " 1) LOGIN.\n"
                + " 2) Create/Update/Remove movie listing.\n"
                + " 3) Create/Update/Remove cinema showtimes and movies to be shown.\n"
                //System settings include ticket prices, holidays
                + " 4) Configure system settings. \n"
                + " 5) Quit MOBLIMA\n"
                + " Enter your choice below:\n");

                int selection= sc.nextInt();

                switch (selection)
                {
                    case 1: 
                            break;
                    case 2: 
                            break;
                    case 3: 
                            break;
                    case 4: 
                            break;
                    default: System.out.print("Invalid input, please try again!"); 
                }

            } while(selection!=5);

        } while(user==1 || user==2);

    }

}
