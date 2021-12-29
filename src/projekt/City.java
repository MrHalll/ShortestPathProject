package projekt;


public class City implements Comparable<City>{
	//attributes
	private String name;
	private int weight;
	
	public City(String name) {
		this.name = name;
	}
	
	public String toString() {
		return name;
	}
	
	public void setWeight(int weight) {
		this.weight = weight;
	}
	
	public int getWeight() {
		return weight;
	}

	@Override
	public int compareTo(City otherCity) {
		if (this.getWeight() < otherCity.getWeight()) {
			return -1;
		}
		if (this.getWeight() > otherCity.getWeight()) {
			return 1;
		}
		
		return 0;
	}
}
