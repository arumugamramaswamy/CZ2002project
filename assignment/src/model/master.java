package model;

import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;


public class master {

	
	private ArrayList<movie> movieList;
	private ArrayList<Cineplex> cineplexList;

	public void addMovieListing(movie m) {
		movieList.add(m);
	}
	
	public void addCineplex(Cineplex c) {
		cineplexList.add(c);
	}
	
	public ArrayList<movie> getMovies(){
		return movieList;
	}
	
	public ArrayList<Cineplex> getCineplexes(){
		return cineplexList;
	}
	
	public void deleteMovie(int index) {
		movieList.remove(index);
	}
	
}
