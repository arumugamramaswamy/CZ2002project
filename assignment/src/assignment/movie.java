package assignment;

import java.io.IOException;
import java.util.ArrayList;

public class movie {
	private String movieName;
	private String directorName;
	private String[] reviews;
	private double[] ratings;
	private String showingStatus; // preview, now showing, coming soon
	private String Synopsis;
	private String[] Cast;
	private show[] Shows;
	
	// main constructor
	public movie(String name,String director,String[] reviews, double[] ratings,
								String showingStatus, String Synopsis, String[] Cast) {
		movieName = name;
		directorName = director;
		this.Cast = Cast;
		this.Synopsis = Synopsis;
		this.showingStatus = showingStatus;
		this.ratings = ratings;
		this.reviews = reviews;
		//read ratings and review from file
		//implement here
	}
	
	// constructor used by show
	public movie(movie mov) {
		movieName = mov.movieName;
		directorName = mov.directorName;
		reviews = mov.reviews;
		ratings = mov.ratings;
		showingStatus = mov.showingStatus; // preview, now showing, coming soon
		Synopsis = mov.Synopsis;
		Cast = mov.Cast;
	}
	
	public String getMovieName() {
		return movieName;
	}
	
	public String getShowingStatus() {
		return showingStatus;
	}
	
	public String getSynopsis() {
		return Synopsis;
	}
	
	public String getDirectorName() {
		return directorName;
	}
	
	public String[] getCast() {
		return Cast;
	}
	
	public double getTotalRating() {
		if (ratings.length == 0)
			return -1;
		double sum = 0;
		for (int i = 0;i<ratings.length;i++) {
			sum+=ratings[i];
		}
		sum/=ratings.length;
		return sum;
	}
	
	public double[] getAllRatings() {
		return ratings;
	}
	
	public String[] getReviews() {
		return reviews;
	}
	
	public void writeReview(String rev) {
		String[] temp;
		if (reviews == null) {
			temp = new String[1];
			temp[0] = rev;
			}
		else {
		temp = new String[reviews.length+1];
		for (int i=0;i<reviews.length;i++) {
			temp[i] = reviews[i];
		}
		temp[reviews.length] = rev;
	}
		reviews = temp;
	}
	
	public void giveRating(double rat) {
		double[] temp;
		if(ratings == null) {
			temp = new double[1];
			temp[0] = rat;
		}
		else{
			temp = new double[ratings.length+1];
		for (int i=0;i<ratings.length;i++) {
			temp[i] = ratings[i];
		}
		temp[ratings.length] = rat;
	}
		ratings = temp;
	}
	
	//create a show for this movie, currently set to protected to be used by admin module
	void createShowListing(String dt,int screenNum,int cineplexID) {
		show[] temp;
		show s = new show(this,dt,screenNum,cineplexID);
		if(Shows == null) {
			temp = new show[1];
			temp[0] = s;
		}else {
		temp = new show[Shows.length+1];
		for (int i=0;i<Shows.length;i++) {
			temp[i] = Shows[i];
		}
		temp[Shows.length] = s;
		}
		Shows = temp;
	}
	
	//save all shows to a text file under the Shows folder with file name as the movie name
	void saveShowDetails() {
		movieIO m = new movieIO();
		try {
		m.saveShows("Shows/"+movieName+".txt", Shows);
		}catch(IOException e) {
			System.out.println("IOException > " + e.getMessage());
		}
	}
	
	//read show details from the shows folder with file name as movie name
	void readShowDetails() {
		movieIO m = new movieIO();
		try {
		ArrayList arr = m.readShows(this,"Shows/"+movieName+".txt");
		Shows = new show[arr.size()];
		for(int i =0;i<arr.size();i++) {
			Shows[i] = (show)arr.get(i);
		}
			
		}catch(IOException e) {
			System.out.println("IOException > " + e.getMessage());
		}
	}
	
}
