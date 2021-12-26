package projekt;

import java.util.List;
/**
 * 
 * @author melle
 *
 */
public interface IMap {
	void addBranch(City start, City end, int weight);
	List<City> getAllCitys();
	List<City> getAllCitysNearby();
}
