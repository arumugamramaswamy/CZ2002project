package model;

import java.util.ArrayList;
import model.master;


public class Cineplex {
    private String cineplexName;
    private int cineplexId;
    private ArrayList<Cinema> cinemaList;

    public Cineplex(master m) {
        cinemaList=new ArrayList<>();
        cineplexId=0;
        cineplexName="";
    }

    public Cineplex(String cineplexName, int cineplexId,master m) {
        this.cineplexName = cineplexName;
        this.cineplexId = cineplexId;
        m.addCineplex(this);
    }

    public Cineplex(String cineplexName, int cineplexId, ArrayList<Cinema> cinemaList,master m) {
        this.cineplexName = cineplexName;
        this.cineplexId = cineplexId;
        this.cinemaList = cinemaList;
        m.addCineplex(this);
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

