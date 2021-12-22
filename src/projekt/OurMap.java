package projekt;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class OurMap implements Map{
	
	private Set<City> citys = new HashSet<City>();
	int distance;

	@Override
	public void addCity(City city) {
		citys.add(city);
	}

	@Override
	public void addBranch(City start, City end, int distance) {
		
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
