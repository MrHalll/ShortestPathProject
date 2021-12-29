package projekt;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.PriorityQueue;

public class Djikstra {
	
	private static Map<City, Integer> distanceMap = new HashMap<City, Integer>();
	private static Map<City, City> predMap = new HashMap<City, City>();
	private static PriorityQueue<City> pq = new PriorityQueue<City>();
	
	
	public static Map calculateShortestPath(CityMap map, City startCity) {
		for (City city : map.getAllCitys()) {
			predMap.putIfAbsent(city, null);

			if (city != startCity) {
				distanceMap.putIfAbsent(city, Integer.MAX_VALUE);
			} else {
				distanceMap.putIfAbsent(city, 0);
			}
			city.setWeight(distanceMap.get(city));
			pq.add(city);
		}
		while (!pq.isEmpty()) {
			City currentCity = pq.poll();
			for (Branch branch : map.getAllNeighbours(currentCity)) {
				City neighbourCity = branch.getEndCity();
				if (distanceMap.get(neighbourCity).compareTo(distanceMap.get(currentCity) + branch.getDistance()) > 0) {
					distanceMap.replace(neighbourCity, (distanceMap.get(currentCity) + branch.getDistance()));
					predMap.replace(neighbourCity, currentCity);
					pq.remove(neighbourCity);
					neighbourCity.setWeight(distanceMap.get(currentCity) + branch.getDistance());
					pq.add(neighbourCity);
				}
			}
			
		}		
		return distanceMap;
	}
	

}
