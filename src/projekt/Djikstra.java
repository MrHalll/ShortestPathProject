package projekt;

import java.util.HashMap;
import java.util.Map;

public class Djikstra {
	
	Map<City, Integer> distanceMap = new HashMap<City, Integer>();
	Map<City, City> predMap = new HashMap<City, City>();
	BSTreePriorityQueue<Node> pq = new BSTreePriorityQueue<Node>();
	
	public static CityMap calculateShortestPath(CityMap map, City startCity) {
		return null;
	}

}
