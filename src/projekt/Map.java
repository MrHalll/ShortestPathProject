package projekt;

import java.util.List;

public interface Map {
	void addPlace(String name);
	void addBranch(City start, City end, int length);
	List<City> getAllCitys();
	List<City> getAllCitysNearby();
}
