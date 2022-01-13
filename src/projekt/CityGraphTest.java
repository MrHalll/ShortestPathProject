package projekt;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.util.Iterator;
import java.util.Scanner;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CityGraphTest {

	CityGraph cityGraph;
	City start;
	City end;
	int distance;

	@BeforeEach
	void setUp() throws Exception {
		cityGraph = new CityGraph();

		// Filinläsning
		File inputFile = new File("C:\\Users\\melle\\OneDrive\\HIG\\AlgoritmerDatastrukturer\\Projekt\\StadsLista.txt");
		Scanner fileScanner = new Scanner(inputFile);
		while (fileScanner.hasNextLine()) {
			String line = fileScanner.nextLine();
			Scanner lineScanner = new Scanner(line).useDelimiter(" ");
			start = new City(lineScanner.next());
			end = new City(lineScanner.next());
			distance = lineScanner.nextInt();
			cityGraph.addBranch(start, end, distance);
		}
	}

	@AfterEach
	void tearDown() throws Exception {
		cityGraph = null;
		start = null;
		end = null;
		distance = 0;
	}

	@Test
	@DisplayName("Testa CityGraph")
	void testNewCityMap() {
		assertNotNull(cityGraph);
		for (City city : cityGraph.getAllCitys()) {
			System.out.println(city);
		}
	}

	@Test
	@DisplayName("Testa Neighbours")
	void testGetAllNeighbours() {
		for (City city : cityGraph.getAllCitys()) {
			System.out.println();
			for (Branch neighbour : cityGraph.getAllNeighbours(city)) {
				System.out.println(city.toString() + " with ID: " + city.hashCode() + " -> " + neighbour.getEndCity()
						+ " with ID: " + neighbour.hashCode());
			}
		}
	}

}
