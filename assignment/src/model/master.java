package model;

import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
import controller.*;
import java.io.IOException;



public class master {

	
	private ArrayList<movie> movieList;
	private ArrayList<Cineplex> cineplexList;
	private static String filename = "data/movies.txt";

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
	
	public void readMovies() {
		movieIO temp = new movieIO();
		try {
		movieList = temp.readMovie(filename, this);
		}catch(IOException e){
			
		}
	}
	
	public void saveMovies() {
		movieIO temp = new movieIO();
		try {
		temp.saveMovie(filename, movieList);
		}catch(IOException e){
			
		}
	}
	
	public void readCinplexes() {

			CineplexIO temp = new CineplexIO();
			cineplexList = temp.readCineplex(this);
			
	}
	
	public void saveCineplexes() {

		CineplexIO temp = new CineplexIO();
		try {
		temp.saveCineplex(cineplexList);
		}
		catch(IOException e){
			
		}
	}
}
