package model;

import java.util.ArrayList;





public class Cinema {
    private String cinemaName;
    private String cinemaClass;
    private int cinemaID;
    private ArrayList<show> showList;


//    public Cinema() {
//        cinemaName="";
//        cinemaClass="";
//        cinemaCode="";
//        
//      
//    }
//



  
    public Cinema(String cinemaName, String cinemaClass, int cinemaID) {
        this.cinemaName = cinemaName;
        this.cinemaClass = cinemaClass;
        this.cinemaID = cinemaID;
//        moviesList=new ArrayList<>();

        
    }
//  public Cinema(String cinemaName, String cinemaClass, String cinemaCode, ArrayList<MovieInCinema> moviesList) {
//        this.cinemaName = cinemaName;
//        this.cinemaClass = cinemaClass;
//        this.cinemaCode = cinemaCode;
//  	  this.moviesList = moviesList;
//        
//    }
 

    public String getCinemaName() {
        return cinemaName;
    }


    public String getCinemaClass() {
        return cinemaClass;
    }



    public int getCinemaID() {
        return cinemaID;
    }

    public void addShow(show s) {
    	showList.add(s);
    }
 
    public ArrayList<show> getCinemaShows(){
    	return showList;
    }
    
//    public ArrayList<MovieInCinema> getMoviesList() {
//        return moviesList;
//    }

   
}

