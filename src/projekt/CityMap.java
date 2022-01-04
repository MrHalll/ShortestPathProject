package projekt;

import java.util.Map;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;


public class CityMap implements IMap{
	
	private Map<String, City> citys = new HashMap<String, City>();
	private Map<City, ArrayList<Branch>> neighbours = new HashMap<City, ArrayList<Branch>>();
	
	public CityMap(){
		
	}
	
	@Override
	public void addBranch(City start, City end, int distance) {
		addCity(start);
		addCity(end);
		neighbours.get(getCity(start.toString())).add(new Branch(start, end, distance));
		neighbours.get(getCity(end.toString())).add(new Branch(end, start, distance));
	}
	
	private void addCity(City city){
		citys.putIfAbsent(city.toString(), city);
		neighbours.putIfAbsent(citys.get(city.toString()), new ArrayList<Branch>());
	}

	@Override
	public Collection<City> getAllCitys() {
		return citys.values();
	}

	@Override
	public List<Branch> getAllNeighbours(City city) {
		return neighbours.get(city);
	}
	
	public City getCity(String cityName) {
		return citys.get(cityName);
	}
	
	public boolean contains(City city) {
		if (citys.containsKey(city.toString())) {
			return true;
		}
		return false;
	}
}
