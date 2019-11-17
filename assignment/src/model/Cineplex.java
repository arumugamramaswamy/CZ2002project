package model;

import java.util.ArrayList;
import model.master;

/**
 * Cineplex master class
 * @version 1.0
 */

public class Cineplex {
	
	/**
	 * Name of the Cineplex
	 */
    private String cineplexName;
    
    /**
     * ID of the cineplex
     */
    private int cineplexId;
    
    /**
     * Array of all cinemas inside a cineplex
     */
    private ArrayList<Cinema> cinemaList;

    /**
     * default constructor
     * @param cineplexName name of the cineplex
     * @param cineplexId ID of the cinema inside a cineplex
     */
    public Cineplex(String cineplexName, int cineplexId) {
        this.cineplexName = cineplexName;
        this.cineplexId = cineplexId;
        this.cinemaList = new ArrayList<Cinema>();
    }

    /**
     * default constructor
     * @param cineplexName name of the cineplex
     * @param cineplexId ID of the cinema inside the cineplex
     * @param cinemaList array of all cinemas inside a cineplex
     */
    public Cineplex(String cineplexName, int cineplexId, ArrayList<Cinema> cinemaList) {
        this.cineplexName = cineplexName;
        this.cineplexId = cineplexId;
        this.cinemaList = cinemaList;
    }

    /**
     * get the cineplex name
     * @return cineplex name
     */
    public String getCineplexName() {
        return cineplexName;
    }

    /**
     * set the cineplex name
     * @param cineplexName the new cineplex name
     */
    public void setCineplexName(String cineplexName) {
        this.cineplexName = cineplexName;
    }

    /**
     * get the cineplex ID
     * @return cineplex ID
     */
    public int getCineplexId() {
        return cineplexId;
    }
    
    /**
     * get the array of all cinemas inside a cineplex
     * @return list of all cinemas
     */
    public ArrayList<Cinema> getCinemaList() {
        return cinemaList;
    }
    
    /**
     * add a cinema to a cineplex
     * @param c the cinema details
     */
    public void addCinema(Cinema c) {
    	cinemaList.add(c);
    }

}

