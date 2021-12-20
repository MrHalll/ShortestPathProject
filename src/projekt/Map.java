package projekt;

public interface Map {
	void addPlace(Place place);
	void addPath(Place start, Place end, int length);
	List<Place> getAllPlaces();
	List<Place> getPlacesNearby();
}
