package cineplex;
import java.io.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;






public class Main {
	private static ArrayList<Cinema> cinemasList = new ArrayList<>();
    private static ArrayList<Cineplex> cineplexesList = new ArrayList<>();
    
    private static Scanner systemScanner = new Scanner(System.in);
    private static  Cineplex selectedCineplex;
    private static Cinema selectedCinema;
  


    public static boolean tryParseInteger(String string){
        try{
            Integer.parseInt(string);
            return true;
        }catch (Exception e){
            return false;
        }
    }
    
    public static int scannerIntegerInput(){
        int temp=0;
        String test="";
        test = systemScanner.nextLine();
        while (!Main.tryParseInteger(test)) {
            System.out.println("Wrong input please check!");
            test = systemScanner.nextLine();
        }
        return Integer.parseInt(test);
    }
    
    public static Scanner getSystemScanner() {
        return systemScanner;
    }

private static void readCineplex(){
    try{
        String[] temp;
        Scanner fileScanner = new Scanner(new File("C:\\Users\\tianyi\\eclipse-workspace\\storage\\Cineplexs.txt"));
        while (fileScanner.hasNext()) {
            temp = fileScanner.nextLine().split(";");

                    ArrayList<Cinema> tempCinemaList = new ArrayList<>();
                    for (int i = 2; i < temp.length; i++) {
                        tempCinemaList.add(findCinemaByName(temp[i]));
                    }
                    cineplexesList.add(new Cineplex(
                            temp[0], Integer.parseInt(temp[1]),
                            tempCinemaList
                    ));
                }

        fileScanner.close();
    }catch (Exception e){
        System.err.println(e);
        e.printStackTrace();
    }
}

private static void readCinema(){
    try{
        String[] onelinetemp;
        Scanner fileScanner = new Scanner(new File("C:\\Users\\tianyi\\eclipse-workspace\\storage\\Cinemas.txt"));
        while (fileScanner.hasNext()) {
            onelinetemp = fileScanner.nextLine().split(";");
//            if (onelinetemp.length >= 3) {
//                if (onelinetemp.length == 4) {
//                    String[] temp = onelinetemp[3].split(",");
//                    cinemasList.add(new Cinema(
//                            onelinetemp[0], onelinetemp[1], onelinetemp[2],
//                            Integer.parseInt(temp[0]), Integer.parseInt(temp[1])));
//                } 
//                else {
//                    String[] temp = onelinetemp[3].split(";");
                    cinemasList.add(new Cinema(
                            onelinetemp[0], onelinetemp[1],
                            onelinetemp[2]));
//                            Integer.parseInt(temp[0]), Integer.parseInt(temp[1])));
//                }
//            } 
            
        }
       fileScanner.close();
    }catch (Exception e){
        System.err.println(e);
        e.printStackTrace();
    }
}

private static Cinema findCinemaByName(String name) {
    for(Cinema c:cinemasList){
        if(c.getCinemaName().contains(name)){
            return c;
        }
    }
    return null;
}

public static ArrayList<Cinema> getCinemasList() {
    return cinemasList;
}

public static ArrayList<Cineplex> getCineplexesList() {
    return cineplexesList;
}
private static boolean readFile(){
    try {
        
        readCinema();
        readCineplex();
       
        return true;

    }catch (Exception e){
        e.printStackTrace();
    }
    return false;
}
public static Cineplex selectCineplex() throws IOException {
	String selection=null;
	Scanner scanner = Main.getSystemScanner();
	
	while(true) {
		int counter = 1;
		int ccounter =1 ;
		System.out.println("List of Cineplexes");
		for (Cineplex c : cineplexesList) {
			System.out.println(counter + "." + c.getCineplexName());
			counter++;
		}
		System.out.println("Please select one of cineplexes above! ");

		while(scanner.hasNext()) {
			selection = scanner.nextLine();

			if (Main.tryParseInteger(selection)) {
				int temp = Integer.parseInt(selection) - 1;
				if (temp < cineplexesList.size()) {
					selectedCineplex = cineplexesList.get(temp);
					for (Cinema c : selectedCineplex.getCinemaList()) {
						System.out.println(ccounter + "." + c.getCinemaName());
						ccounter++;
					
					}
					System.out.println("Please select one of cinemas above! ");
					String selectionCinema =scanner.nextLine();
					if (Main.tryParseInteger(selection)) {
						int k = Integer.parseInt(selection) - 1;
						if(k<cinemasList.size()) {
							System.out.println("Terminator\nPokemon\nHarry Potter ");
							
						}else {
							System.out.println("Wrong cinema selected! Please try again!");
							continue;
						}
					} else{
						System.out.println("Input cannot be recognised! Please try again!");
					}
				} else {
					System.out.println("Wrong cineplex selected! Please try again!");
					continue;
				}
			 
			} else {
				System.out.println("Input cannot be recognised! Please try again!");
			}
		}
	}
}

//public Cinema selectCinema() throws IOException {
//	Scanner scanner = Main.getSystemScanner();
//	
//	while(true) {
//		int counter = 1;
//		for (Cinema c : selectedCineplex.getCinemaList()) {
//			System.out.println(counter + "." + c.getCinemaName());
//			counter++;
//		}
//		System.out.println("Please select one of cinemas above! ");
//		String selection =scanner.nextLine();
//		if (Main.tryParseInteger(selection)) {
//			int temp = Integer.parseInt(selection) - 1;
//			if(temp<this.selectedCineplex.getCinemaList().size()) {
//				this.selectedCinema = selectedCineplex.getCinemaList().get(temp);
//				return this.selectedCinema;
//			}else {
//				System.out.println("Wrong cinema selected! Please try again!");
//				continue;
//			}
//		
//		}else{
//			System.out.println("Input cannot be recognised! Please try again!");
//		}
//	}
//}

public static void main(String[] aArgs) throws IOException  {
	
	readFile();
	selectCineplex();
	


}
}

   

