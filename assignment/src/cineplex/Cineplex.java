package cineplex;

import java.util.ArrayList;


public class Cineplex {
    private String cineplexName;
    private String cineplexId;
    private ArrayList<Cinema> cinemaList;

    public Cineplex() {
        cinemaList=new ArrayList<>();
        cineplexId="";
        cineplexName="";
    }

    public Cineplex(String cineplexName, String cineplexId) {
        this.cineplexName = cineplexName;
        this.cineplexId = cineplexId;
    }

    public Cineplex(String cineplexName, String cineplexId, ArrayList<Cinema> cinemaList) {
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

    public String getCineplexId() {
        return cineplexId;
    }

    public void setCineplexId(String Id) {
        this.cineplexId = cineplexId;
    }

    public ArrayList<Cinema> getCinemaList() {
        return cinemaList;
    }

    public void setCinemaList(ArrayList<Cinema> cinemaList) {
        this.cinemaList = cinemaList;
    }
}

