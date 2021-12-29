package projekt;

public class Branch {
	City start;
	City end;
	int distance;
	
	public Branch(City start, City end, int distance) {
		this.start = start;
		this.end = end;
		this.distance = distance;
	}
	
	public int getDistance() {
		return distance;
	}
	
	public City getStartCity() {
		return start;
	}
	
	public City getEndCity() {
		return end;
	}
	
	public String toString(){
		return start + "->" + end + " : " + distance;
	}
}
