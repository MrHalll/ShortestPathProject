package projekt;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Djikstra {
	
	private static Map<City, Integer> distanceMap = new HashMap<City, Integer>();
	private static Map<City, City> predMap = new HashMap<City, City>();
	private static PriorityQueue<City> pq = new PriorityQueue<City>();
	
	int testAttribut = 0;
	
	public static Map<City, Integer> calculateShortestPath(CityMap map, City startCity) {
		for (City city : map.getAllCitys()) {
			predMap.putIfAbsent(city, null);

			if (city.toString() != startCity.toString()) {
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
				
				//Temp lösning för att få neighbourCity att peka på rätt objekt
				City neighbourCity = map.getCity(branch.getEndCity().toString());
				
				/*
				//**Felsökning**
				System.out.println("Current: " + currentCity.toString() + " with ID: " + currentCity.hashCode() + ": " + distanceMap.get(currentCity));
				System.out.println("Neighbour: " + neighbourCity.toString() + " with ID: " + neighbourCity.hashCode() + ": " + distanceMap.get(neighbourCity));
				System.out.println(pq);
				System.out.println(); */

				if (distanceMap.get(neighbourCity).compareTo(distanceMap.get(currentCity) + branch.getDistance()) > 0) {
					distanceMap.replace(neighbourCity, (distanceMap.get(currentCity) + branch.getDistance()));
					predMap.replace(neighbourCity, currentCity);
					pq.remove(neighbourCity);
					neighbourCity.setWeight(distanceMap.get(currentCity) + branch.getDistance());
					pq.add(neighbourCity);
				}
			}

		}		
		System.out.println(predMap);
		return distanceMap;
	}
	

}
