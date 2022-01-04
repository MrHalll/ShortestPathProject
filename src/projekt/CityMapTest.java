package projekt;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.util.Iterator;
import java.util.Scanner;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CityMapTest {
	
	CityMap cityMap;
	City start;
	City end;
	int distance;

	@BeforeEach
	void setUp() throws Exception {
		cityMap = new CityMap();

		//Filinläsning
		File inputFile = new File("C:\\Users\\OskarLaptop\\Documents\\Högskola\\2021\\Algoritmer och datastrukturer\\Projekt\\Stadsfil1.txt");
		Scanner fileScanner = new Scanner(inputFile);
		while (fileScanner.hasNextLine()) {
			String line = fileScanner.nextLine();
			Scanner lineScanner = new Scanner(line).useDelimiter(" ");
			start = new City(lineScanner.next());
			end = new City(lineScanner.next());
			distance = lineScanner.nextInt();
			cityMap.addBranch(start, end, distance);
		}
	}

	@AfterEach
	void tearDown() throws Exception {
		cityMap = null;
		start = null;
		end = null;
		distance = 0;
	}

	@Test
	@DisplayName("Testa ny CityMap")
	void testNewCityMap() {
		assertNotNull(cityMap);
		for (City city : cityMap.getAllCitys()) {
			System.out.println(city);
		}
	}
	
	@Test
	@DisplayName("Testa Neighbours")
	void testGetAllNeighbours() {
		for (City city : cityMap.getAllCitys()) {
			System.out.println();
			for (Branch neighbour : cityMap.getAllNeighbours(city)) {
				System.out.println(city.toString() + " with ID: " + city.hashCode() + " -> " + neighbour.getEndCity() + " with ID: " + neighbour.hashCode());
			}
		}
	}

}
