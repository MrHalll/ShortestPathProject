package projekt;

import java.util.List;

public interface IMap {
	void addBranch(City start, int length);
	List<City> getAllCitys();
	List<City> getAllCitysNearby();
}
