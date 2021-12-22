package projekt;

import java.util.Map;
import java.util.HashMap;
import java.util.List;


public class CityMap implements IMap{
	
	private Map<String, Integer> map = new HashMap<String, Integer>();
	int distance;
	City startCity;

	@Override
	public void addBranch(City start, int distance) {
		map.put(start.getName(), distance);
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
