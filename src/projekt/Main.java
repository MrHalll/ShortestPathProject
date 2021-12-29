package projekt;

import java.util.Collection;

public class Main {

	public static void main(String[] args) {
		IMap karta = new CityMap();
		City stockholm = new City("Stockholm");
		City gävle = new City("Gävle");
		City hedesunda = new City("Hedesunda");
		City tierp = new City("Tierp");
		City uppsala = new City("Uppsala");
		City göteborg = new City("Göteborg");
		
		karta.addBranch(gävle, uppsala, 10);
		karta.addBranch(gävle, hedesunda, 4);
		karta.addBranch(hedesunda, tierp, 3);
		karta.addBranch(tierp, uppsala, 4);
		karta.addBranch(uppsala, stockholm, 8);
		karta.addBranch(stockholm, göteborg, 40);
		
		Collection<City> collection = karta.getAllCitys();
		
		for (City city : collection) {
			System.out.println(city.toString());
		}
		
		for (Branch branch : karta.getAllNeighbours(gävle)) {
			System.out.println(branch.toString());
		}
	}
}
