package projekt;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collection;
import java.util.Scanner;


public class Main {
	

	public static void main(String[] args) {
		City start;
		City end;
		int distance;
		IMap karta = new CityMap();
		
		//Filinläsning
		File inputFile = new File("C:\\Users\\melle\\OneDrive\\HIG\\AlgoritmerDatastrukturer\\Projekt\\StadsLista.txt");
		try {
			Scanner fileScanner = new Scanner(inputFile);
			while (fileScanner.hasNextLine()) {
				String line = fileScanner.nextLine();
				Scanner lineScanner = new Scanner(line).useDelimiter(" ");
				start = new City(lineScanner.next());
				end = new City(lineScanner.next());
				distance = lineScanner.nextInt();
				karta.addBranch(start, end, distance);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		Collection<City> collection = karta.getAllCitys();
		for (City city : collection) {
			System.out.println(city.toString());
		}
		
	}
}
