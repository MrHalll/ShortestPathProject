package projekt;

import java.util.List;

public class OurMap implements Map{
	
	City city;
	int distance;

	@Override
	public void addPlace(String name) {
		city = new City(name);
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
