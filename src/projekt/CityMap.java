package projekt;

import java.util.Map;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;


public class CityMap implements IMap{
	
	private Map<City, List<City>> map = new HashMap<City, List<City>>();
	int distance;
	City startCity;

	@Override
	public void addBranch(City start, City end, int weight) {
		
		if (!map.containsKey(start)) {
			addCity(start);
		}else if (!map.containsKey(end)) {
			addCity(end);
		}
		
	}
	
	private void addCity(City city){
		map.put(city, new LinkedList<City>());
	}

	@Override
	public List<City> getAllCitys() {
		return null;
	}

	@Override
	public List<City> getAllCitysNearby() {
		return null;
	}
}
