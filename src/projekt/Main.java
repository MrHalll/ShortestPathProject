package projekt;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collection;
import java.util.Map;
import java.util.Scanner;


public class Main {
	

	public static void main(String[] args) {
		City start;
		City end;
		int distance;
		CityMap karta = new CityMap();
		
		//Filinläsning
		File inputFile = new File("C:\\Users\\OskarLaptop\\Documents\\Högskola\\2021\\Algoritmer och datastrukturer\\Projekt\\Stadsfil1.txt");
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
		
		Map<City, Integer> distances = Djikstra.calculateShortestPath(karta, karta.getCity("Gävle"));
		for (Object Object : distances.keySet()) {
			System.out.println(Object.toString() + " " + distances.get(Object).toString());
		}
		
		
	}
}
