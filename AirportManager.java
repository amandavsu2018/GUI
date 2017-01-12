package prob1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AirportManager {
	
	List<Airport> apList = new ArrayList<>();
	
	public AirportManager(List<Airport> airports){
		this.apList = airports;
	}

	public Airport getAirport(String code){
		
		Airport dummy = new Airport(code);
		int x = apList.indexOf(dummy);
		Airport a = apList.get(x);
		return a;
	}

	public double getDistanceBetween(Airport airport1, Airport airport2){
		double lat1 = airport1.getLatitude();
		double long1 = airport1.getLongitude();
		double lat2 = airport2.getLatitude();
		double long2 = airport2.getLongitude();
		
		double distance = DistanceCalculator.getDistance(lat1, long1, lat2, long2);
		
	return distance;
	}
	
	public double getDistanceBetween(String code1, String code2){
		Airport a1 = getAirport(code1);
		Airport a2 = getAirport(code2);
	
		double distance = getDistanceBetween(a1, a2);
		
		return distance;
	}

	public Airport getAirportClosestTo(String code){
		Airport a = getAirport(code);
		Airport aClosest = null;
		int minDistance = 10000;
		for(Airport x : apList){
			if(! a.equals(x)){
				double y = getDistanceBetween(a, x);
				if(y < minDistance){
					aClosest = x;
				}
			}
		}
		return aClosest;
	}

	public List<Airport> getAirportsWithin(String code, double withinDist) {
		List<Airport> close = new ArrayList<>();
		Airport dummy = getAirport(code);
		
		for(Airport x : apList){
			if(getDistanceBetween(dummy, x) <= withinDist){
				close.add(x);
			}
		}
		
		return close;
	}

	public List<Airport> getAirportsWithin(String code1, String code2, double withinDist){
		List<Airport> close = new ArrayList<>();
		Airport dummy1 = getAirport(code1);
		Airport dummy2 = getAirport(code2);
		
		for(Airport x : apList){
			if((getDistanceBetween(dummy1, x) <= withinDist) && (getDistanceBetween(dummy2, x) <= withinDist)){
				close.add(x);
			}
		}
		
		return close;
	}
	
	public class AirportCityComparator implements Comparator<Airport> {
		public int compare(Airport a1, Airport a2 ) {
			int diff = a1.getCity().compareTo(a2.getCity());
			
			if( diff != 0 ){
				return diff;
			}
			else{ 
				return a1.getState().compareTo(a2.getState());
			}
			
		}
	}

	public class AirportStateComparator implements Comparator<Airport>{
		public int compare(Airport a1, Airport a2 ) {
			int diff = a1.getState().compareTo(a2.getState());
			
			if( diff != 0 ){
				return diff;
			}
			else{ 
				return a1.getCity().compareTo(a2.getCity());
			}
		}
	}

	
	public List<Airport> getAirportsSortedBy(String sortType){		
		ArrayList<Airport> aSorted = new ArrayList<>();
		for(Airport x : apList){
			aSorted.add(x);
		}
		AirportCityComparator comp1 = new AirportCityComparator();
		Collections.sort(aSorted, comp1);
		
		AirportStateComparator comp2 = new AirportStateComparator();
		Collections.sort(aSorted, comp2);

		return aSorted;
	}
	
	public List<Airport> getAirportsClosestTo(String code, int num){
		List<Airport> closest = new ArrayList<>();
		List<Airport> withinDist = new ArrayList<>();
		for(Airport a : apList){
			withinDist.add(a);
		}
		
		for(int i = 0; i < num; i++){
			Airport y = getAirportClosestTo(code, withinDist);
			if(y.getCode() != code){
				closest.add(y);
			}
			withinDist.remove(y);
		}

		return closest;
	}

	private Airport getAirportClosestTo(String code, List<Airport> withinDist){
		Airport a = getAirport(code);
		Airport aClosest = null;
		int minDistance = 10000;
		for(Airport x : withinDist){
			if(! a.equals(x)){
				double y = getDistanceBetween(a, x);
				if(y < minDistance){
					aClosest = x;
				}
			}
		}
		return aClosest;
	}

}
