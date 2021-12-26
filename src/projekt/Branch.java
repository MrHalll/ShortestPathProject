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
}
