package projekt;

import java.util.Map;

class City {
	//attributes
	String name;
	Map<City, Integer> map;
	
	int testVariabel = 0;
	
	//Testar att skriva en test-kommentar för push
	
	public City(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
}
