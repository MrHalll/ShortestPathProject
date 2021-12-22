package projekt;

import java.util.List;

public interface Map {
	void addCity(City city);
	void addBranch(City start, City end, int length);
	List<City> getAllCitys();
	List<City> getAllCitysNearby();
}
