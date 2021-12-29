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
	
	public int getDistance(City start, City end) {
		return distance;
	}
	
	public String toString(){
		return start + "->" + end + " : " + distance;
	}
}
