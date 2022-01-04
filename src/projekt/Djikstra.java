package projekt;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Stack;

import javax.management.RuntimeErrorException;

public class Djikstra {
	
	private static Map<City, Integer> distanceMap = new HashMap<City, Integer>();
	private static Map<City, City> predMap = new HashMap<City, City>();
	private static PriorityQueue<City> pq = new PriorityQueue<City>();
	
	int testAttribut = 0;
	
	public static Map<City, Integer> calculateShortestPath(CityMap map, City startCity) {
		distanceMap.clear();
		predMap.clear();
		pq.clear();
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
		return distanceMap;
	}
	
	public static String getShortestPath(CityMap map, City startCity, City endCity) throws RuntimeErrorException{
		String shortestPath = new String();
		Stack<City> cityStack = new Stack<City>();
		if (!map.contains(startCity) || !map.contains(endCity)) {
			throw new RuntimeErrorException(null, "Cities specified do not exist in CityMap");
		}
		Map<City, Integer> distances = calculateShortestPath(map, map.getCity(startCity.toString()));
		shortestPath = "Distance: " + distances.get(map.getCity(endCity.toString())) + " km" + "\nPath: " + startCity.toString() + " -> ";
		
		City currentCity = map.getCity(endCity.toString());
		while (predMap.get(currentCity) != null && predMap.get(currentCity) != map.getCity(startCity.toString())) {
			cityStack.push(predMap.get(currentCity));
			currentCity = predMap.get(currentCity);
		}
		
		//Stacken används så att städerna hamnar i rätt ordning i pathen
		while (!cityStack.isEmpty()) {
			shortestPath += cityStack.pop().toString() + " -> ";
		}
		
		shortestPath += endCity.toString();
		return shortestPath;
	}
	

}
