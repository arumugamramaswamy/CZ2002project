package model;

import java.util.ArrayList;

/**
 * Class to create Cinemas in Cineplexes and initialize shows in it
 * @version 1.0
 */



public class Cinema {
	
	/**
	 * Name of Cinema
	 */
    private String cinemaName;
    
    /**
     * Class of Cinema
     */
    private String cinemaClass;
    
    /**
     * ID of Cinema
     */
    private int cinemaID;
    
    /**
     * Array of all the shows in the Cinema
     */
    private ArrayList<show> showList;
    
    /**
     * Default Constructor
     * @param cinemaName 	name of the Cinema
     * @param cinemaClass	class of the Cinema
     * @param cinemaID		ID of the Cinema
     */
    public Cinema(String cinemaName, String cinemaClass, int cinemaID) {
        this.cinemaName = cinemaName;
        this.cinemaClass = cinemaClass;
        this.cinemaID = cinemaID;
        showList=new ArrayList<show>();

        
    }

    /**
     * @return Name of the cinema
     */
    public String getCinemaName() {
        return cinemaName;
    }

    /**
     * @return Class of the cinema
     */
    public String getCinemaClass() {
        return cinemaClass;
    }

    /**
     * @return ID of the Cinema
     */
    public int getCinemaID() {
        return cinemaID;
    }

    /**
     * Add a show to the cinema
     * @param s add a particular show to the cinema
     */
    public void addShow(show s) {
    	showList.add(s);
    }
 
    /**
     * @return array of all shows in the Cinema
     */
    public ArrayList<show> getCinemaShows(){
    	return showList;
    }

}

