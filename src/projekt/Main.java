package projekt;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
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
				lineScanner.close();
			}
			fileScanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		Map<City, Integer> distanceMap = Djikstra.calculateShortestPath(karta, karta.getCity("Stockholm"));
		System.out.println("Shortest distance from every city to Stockholm");
		for (Object object : distanceMap.keySet()) {
			System.out.println(object.toString() + " " + distanceMap.get(object).toString());
		}
		System.out.println("Shortest path and distance between two citys:");
		System.out.println(Djikstra.getShortestPath(karta, karta.getCity("Gävle"), karta.getCity("Stockholm")));
	}
}
