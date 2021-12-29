package projekt;

public class Node implements Comparable<Node>{
	private City city;
	private int weight;

	public Node(City city, int weight) {
		this.city = city;
		this.weight = weight;
	}
	
	public int getWeight() {
		return weight;
	}
	
	public City getCity() {
		return city;
	}

	@Override
	public int compareTo(Node otherNode) {
		if (this.getWeight() < otherNode.getWeight()) {
			return -1;
		}
		if (this.getWeight() > otherNode.getWeight()) {
			return 1;
		}
		
		return 0;
	}

}
