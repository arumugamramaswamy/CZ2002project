package cineplex;

import java.util.ArrayList;


public class Cineplex {
    private String cineplexName;
    private int cineplexId;
    private ArrayList<Cinema> cinemaList;

    public Cineplex() {
        cinemaList=new ArrayList<>();
        cineplexId=0;
        cineplexName="";
    }

    public Cineplex(String cineplexName, int cineplexId) {
        this.cineplexName = cineplexName;
        this.cineplexId = cineplexId;
    }

    public Cineplex(String cineplexName, int cineplexId, ArrayList<Cinema> cinemaList) {
        this.cineplexName = cineplexName;
        this.cineplexId = cineplexId;
        this.cinemaList = cinemaList;
    }

    public String getCineplexName() {
        return cineplexName;
    }

    public void setCineplexName(String cineplexName) {
        this.cineplexName = cineplexName;
    }

    public int getCineplexId() {
        return cineplexId;
    }

    public void setCineplexId(int Id) {
        this.cineplexId = Id;
    }

    public ArrayList<Cinema> getCinemaList() {
        return cinemaList;
    }

    public void setCinemaList(ArrayList<Cinema> cinemaList) {
        this.cinemaList = cinemaList;
    }
}

