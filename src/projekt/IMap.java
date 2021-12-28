package projekt;

import java.util.Collection;
import java.util.List;
/**
 * 
 * @author melle
 *
 */
public interface IMap {
	void addBranch(City start, City end, int weight);
	Collection<City> getAllCitys();
	List<Branch> getAllNeighbours(City city);
}
