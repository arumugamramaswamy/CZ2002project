package model;

import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
import controller.*;
import java.io.IOException;



public class master {

	
	private ArrayList<movie> movieList;
	private ArrayList<Cineplex> cineplexList;
	private static String filename = "";

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
		temp.readMovie(filename, this);
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
			temp.readCineplex(this);
			
	}
	
	public void saveCineplexes(String filename) {

		CineplexIO temp = new CineplexIO();
		try {
		temp.saveCineplex(filename,cineplexList);
		}
		catch(IOException e){
			
		}
	}
}
