package projekt;

public class Karta implements Map{
	

	@Override
	public void addPlace(Place place) {
		System.out.println("Hej");
	}

	@Override
	public void addPath(Place start, Place end, int length) {
		
	}

	@Override
	public List<Place> getAllPlaces() {
		return null;
	}

	@Override
	public List<Place> getPlacesNearby() {
		return null;
	}

}
