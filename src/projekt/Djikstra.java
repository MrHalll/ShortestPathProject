package projekt;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Stack;

import javax.management.RuntimeErrorException;

public class Djikstra {
	
	private static Map<City, Integer> distanceMap;
	private static Map<City, City> predMap;
	private static PriorityQueue<City> pq;
		
	public static Map<City, Integer> calculateShortestPath(Graph map, City startCity) {
		distanceMap = new HashMap<City, Integer>();
		predMap = new HashMap<City, City>();
		pq = new PriorityQueue<City>();
		
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
				City neighbourCity = map.getCity(branch.getEndCity().toString());
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
	
	public static String getShortestPath(Graph map, City startCity, City endCity) throws RuntimeErrorException{
		String shortestPath = new String();
		Stack<City> cityStack = new Stack<City>();
		if (!map.contains(startCity) || !map.contains(endCity)) {
			throw new RuntimeErrorException(null, "Cities specified do not exist in CityMap");
		}
		Map<City, Integer> distances = calculateShortestPath(map, map.getCity(startCity.toString()));
		shortestPath = "Shortest Path: " + startCity.toString() + " -> ";
		
		City currentCity = map.getCity(endCity.toString());
		while (predMap.get(currentCity) != null && predMap.get(currentCity) != map.getCity(startCity.toString())) {
			cityStack.push(predMap.get(currentCity));
			currentCity = predMap.get(currentCity);
		}
		
		//Stacken anv??nds s?? att st??derna hamnar i r??tt ordning n??r pathen ska skrivas ut
		while (!cityStack.isEmpty()) {
			shortestPath += cityStack.pop().toString() + " -> ";
		}
		shortestPath += endCity.toString();
		shortestPath += "\nDistance: " + distances.get(map.getCity(endCity.toString())) + " mil";
		return shortestPath;
	}
	

}
