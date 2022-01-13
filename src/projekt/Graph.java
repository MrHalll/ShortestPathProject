package projekt;

import java.util.Collection;
import java.util.List;
/**
 * An interface for the Abstract Data Type <code>IMap</code>
 * 
 * @author Melvin Hall
 * @author Oskar Persson
 * @version 2022-01-13
 */
public interface Graph {
	/**
	 * Adds a branch to the graph
	 * 
	 * @param start city the branch should start from
	 * @param end city the branch should end at
	 * @param distance between the two citys
	 */
	void addBranch(City start, City end, int distance);
	/**
	 * Returns all the citys in the graph
	 * 
	 * @return a collection of all the citys
	 */
	Collection<City> getAllCitys();
	/**
	 * Returns a list of all the branches to a city
	 * 
	 * @param city to get the branches from
	 * @return list containing branches
	 */
	List<Branch> getAllNeighbours(City city);
	/**
	 * Returns true if the graph contains a specific city
	 * 
	 * @param city to check if the graph contains
	 * @return true if graph contains city, false otherwise
	 */
	boolean contains(City city);
	/**
	 * Returns a city from the graph
	 * 
	 * @param cityName name of the city
	 * @return a city object
	 */
	City getCity(String cityName);
}
