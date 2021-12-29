package projekt;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Djikstra {
	
	private static Map<City, Integer> distanceMap = new HashMap<City, Integer>();
	private static Map<City, City> predMap = new HashMap<City, City>();
	private static BSTreePriorityQueue<Node> pq = new BSTreePriorityQueue<Node>();
	
	public static CityMap calculateShortestPath(CityMap map, City startCity) {
		for (City city : map.getAllCitys()) {
			predMap.putIfAbsent(city, value);

			if (city != startCity) {
				distanceMap.putIfAbsent(city, Integer.MAX_VALUE);
			} else {
				distanceMap.putIfAbsent(city, 0);
			}
			Node node = new Node(city, distanceMap.get(city));
			pq.enqueue(node);
		}
		while (!pq.isEmpty()) {
			Node u = pq.dequeue();
			for (Branch branch : map.getAllNeighbours(u.getCity())) {
				City currentCity = u.getCity();
				City neighbourCity = branch.getEndCity();
				if (distanceMap.get(neighbourCity).compareTo(distanceMap.get(currentCity) + branch.getDistance()) > 0) {
					distanceMap.replace(neighbourCity, (distanceMap.get(currentCity) + branch.getDistance()));
					predMap.replace(neighbourCity, currentCity);
					
				}
			}
			
		}
		
		return null;
	}
	

}
