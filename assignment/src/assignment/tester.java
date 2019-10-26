package assignment;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;


public class tester {

	
	public static void main(String[] args) {
		movie m = new movie("YOYO","supsup?", null, null, null, null, args);
//		m.readShowDetails();
//		m.saveShowDetails();
		show s = new show(m,"10/10/19 12:00:00", 0, 0);
		s.printSeats();
////		s.assignSeat(0, 0);
////		System.out.print("\n");
////		s.printSeats();
////		m.writeReview("YOYOYO!!!");
////		m.writeReview("Hi");
////		m.giveRating(10);
////		for (String str:m.getReviews()) {
////			System.out.println(str);
////		}
////		for (double d:m.getAllRatings()) {
////			System.out.println(d);
////		}
//		//read and write read object + extra movie entry
//		ArrayList arr = new ArrayList();
//		movieIO w = new movieIO();
////		
////		//code to read comments.txt and extract movie data
////		try {
////		arr = w.readMovie("comments.txt");
////		}
////		catch (IOException e){
////			System.out.println("IOException > " + e.getMessage());
////		}
////		String[] Cast = {"yoo","yo"};
////		double[] rats = {4};
////		String[] revs = {"Great"};
////		movie mov =new movie("asuran","siddy",revs,rats,"now showing","asuran daw",Cast);
////		arr.add(mov);
////		try {
////			w.saveMovie("comments.txt", arr);
////		}catch(IOException e){
////			System.out.println("IOException > " + e.getMessage());
////		}
//		
//		//read and write comment to read object
//		
////		ArrayList alw = new ArrayList();
////		for (Object obj:arr) {
////			movie mov = (movie)obj;
////			mov.giveRating(0.0);
////			alw.add(mov);
////		}
////		try {
////			w.saveMovie("comments.txt", arr);
////		}catch(IOException e){
////			System.out.println("IOException > " + e.getMessage());
////		}
//		
//		try {
//		arr = w.readShows(m,"YOYO.txt");
//		}
//		catch (IOException e){
//			System.out.println("IOException > " + e.getMessage());
//		}
//		show[] Shows = new show[arr.size()];
//		for (int i =0; i<arr.size(); i++) {
//			Shows[i] = (show)arr.get(i);
//		}
////		
////		try {
////			w.saveShows("YOYO.txt",Shows);
////		}
////		catch (IOException e){
////			System.out.println("IOException > " + e.getMessage());
////		}
////		try {
////		PrintWriter writer = new PrintWriter(new PrintWriter(new FileWriter("movie.txt")));
////		writer.println("10");
////		writer.close();
////		}
////		catch(IOException e) {
////			System.out.println("IOException > " + e.getMessage());
////		}

		
	}
}
