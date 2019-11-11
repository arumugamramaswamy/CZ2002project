package model;

import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;


public class master {

	
	private ArrayList<movie> movieList;
	private ArrayList<Cineplex> cineplexList;
	
	
	public master() {
		// TODO Auto-generated constructor stub
	}

	public void addMovieListing(movie m) {
		movieList.add(m);
	}
	
	public void addCineplex(Cineplex c) {
		cineplexList.add(c);
	}
	
}
