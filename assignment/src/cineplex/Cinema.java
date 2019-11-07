package cineplex;

import java.util.ArrayList;





public class Cinema {
    private String cinemaName;
    private String cinemaClass;
    private String cinemaCode;
//    private ArrayList<MovieInCinema> moviesList;


    public Cinema() {
        cinemaName="";
        cinemaClass="";
        cinemaCode="";
        
      
    }




  
    public Cinema(String cinemaName, String cinemaClass, String cinemaCode) {
        this.cinemaName = cinemaName;
        this.cinemaClass = cinemaClass;
        this.cinemaCode = cinemaCode;
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



    public String getCinemaCode() {
        return cinemaCode;
    }

 
//    public ArrayList<MovieInCinema> getMoviesList() {
//        return moviesList;
//    }

   
}

