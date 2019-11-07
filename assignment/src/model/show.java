package model;

public class show{ // figure out how to implement extends movie
	private String dateTime;
	private movie mov;
	private int screenNum;
	private int cineplexID;
	private int[][] seats = new int[9][9];
	private boolean is3D;
	
	// auto construct seats
	public show(movie mov, String dt, int cineplexID, int screenNum, boolean is3D) {
		this.mov = mov;
		dateTime = dt;
		for(int i=0;i<9;i++) {
			for(int j=0;j<9;j++) {
				seats[i][j] = 0;
			}
		}
		this.cineplexID = cineplexID;
		this.screenNum = screenNum;
		this.is3D = is3D;
	}
	
	// manually construct seats, called by readShows in movieIO
	public show(movie mov, String dt, int cineplexID, int screenNum, boolean is3D, int[][] seats) {
		this.mov = mov;
		dateTime = dt;
		
			
		this.seats = seats;

		this.cineplexID = cineplexID;
		this.screenNum = screenNum;
		this.is3D = is3D;
	}
	
	// print Seats 
	public void printSeats() {
		System.out.printf("%s by %s\n",mov.getMovieName(),mov.getDirectorName());
		System.out.printf("Show location: Cineplex id: %d, Screen number: %d\n",cineplexID,screenNum);
		System.out.printf("Show time: %s\n\n\n",dateTime);
		System.out.printf("      1 2 3   4 5 6   7 8 9\n");
		
		for(int i=0;i<9;i++) {
			for(int j=0;j<9;j++) {
				if (j%3 == 0) {
					System.out.print("  ");
				}
				if (j == 0) {
					System.out.printf("%c   ",(char)i+65);
				}
				if (seats[i][j]==1) {
					System.out.printf("X ");
				}
				else {
					System.out.printf("_ ");
				}
			}
			System.out.print("\n");
		}
		System.out.printf("\n           Screen Here     \n");
		System.out.printf("\n          X  -  Occupied   \n");
		System.out.printf("          _  -  Vaccant    \n");

	}
	
	// assign seat
	public void assignSeat(int s1,int s2) {
		if (seats[s1][s2] == 0)
			seats[s1][s2] = 1;
		else
			System.out.println("Error");
	}
	
	public String getDateTime() {
		return dateTime;
	}
	
	public int getCineplexID() {
		return cineplexID;
	}
	
	public int getScreenNum() {
		return screenNum;
	}
	
	public int[][] getSeats(){
		return seats;
	}
	
	public boolean get3D() {
		return is3D;
	}
}
