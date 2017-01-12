package prob1;

import java.io.FileNotFoundException;
import java.util.*;

public class AirportDriver {

	public static void main(String[] args) throws FileNotFoundException {
		
		String airportFileSmall = "src\\prob1\\airportFileSmall.txt";
		String airportFileMedium = "src\\prob1\\airportFileMedium.txt";
		String airportFileSameCities = "scr\\prob1\\airportFileSameCities.txt";
		List<Airport> airports;
		double dist;
		Airport a1, a2;
		
		// Test 1
		airports = AirportLoader.getAirportList(airportFileSmall);
		System.out.println("Test 1: AirportLoader.getAirportList()\n");
		print(airports);

		// Test 2
		AirportManager airportManager;
		airports = AirportLoader.getAirportList(airportFileSmall);
		airportManager = new AirportManager(airports);

		a1 = airportManager.getAirport("ANB");
		a2 = airportManager.getAirport("VLD");
		System.out.println("\nTest 2a: AirportManager.getAirport('ANB')\n");
		System.out.println(a1);
		System.out.println("\nTest 2b: AirportManager.getAirport('VLD')\n");
		System.out.println(a2);

		// Test 3
		airports = AirportLoader.getAirportList(airportFileSmall);		
		airportManager = new AirportManager(airports);
		a1 = airportManager.getAirport("ANB");
		a2 = airportManager.getAirport("VLD");
		dist = airportManager.getDistanceBetween(a1,a2);
		System.out.println("\nTest 3: AirportManager.getDistanceBetween(a1,a2)\n");
		System.out.println(dist);
		
		// Test 4
		airports = AirportLoader.getAirportList(airportFileSmall);		
		airportManager = new AirportManager(airports);
		dist = airportManager.getDistanceBetween("ANB", "VLD");
		System.out.println("\nTest 4: AirportManager.getDistanceBetween('ANB', 'VLD')\n");
		System.out.println(dist);
		
		// Test 5
		airports = AirportLoader.getAirportList(airportFileSmall);		
		airportManager = new AirportManager(airports);
		Airport closest;
		closest = airportManager.getAirportClosestTo("ANB");
		System.out.println("\nTest 5a: AirportManager.getAirportClosestTo('ANB')\n");
		System.out.println(closest);
		closest = airportManager.getAirportClosestTo("VLD");
		System.out.println("\nTest 5b: AirportManager.getAirportClosestTo('VLD')\n");
		System.out.println(closest);

		// Test 6
		airports = AirportLoader.getAirportList(airportFileMedium);
		airportManager = new AirportManager(airports);
		List<Airport> within = airportManager.getAirportsWithin("ANB", 150);
		System.out.println("\nTest 6a: AirportManager.getAirportsWithin('ANB', 150)\n");
		print(within);
		within = airportManager.getAirportsWithin("VLD", 150);
		System.out.println("\nTest 6b: AirportManager.getAirportsWithin('VLD', 150)\n");
		print(within);
		
		// Test 7
		airports = AirportLoader.getAirportList(airportFileMedium);
		airportManager = new AirportManager(airports);
		within = airportManager.getAirportsWithin("ANB", "VLD", 150);
		System.out.println("\nTest 7: AirportManager.getAirportsWithin('ANB', 'VLD', 150)\n");
		print(within);

		// Test 8
		airports = AirportLoader.getAirportList("src\\prob1\\airportFileSameCities.txt");
		airportManager = new AirportManager(airports);
		List<Airport> sorted = airportManager.getAirportsSortedBy("City");
		System.out.println("\nTest 8a: AirportManager.getAirportsSortedBy('City')");
		print(sorted);
		sorted = airportManager.getAirportsSortedBy("State");
		System.out.println("\nTest 8b: AirportManager.getAirportsSortedBy('State')");
		print(sorted);
		
		// Test 9
		airports = AirportLoader.getAirportList(airportFileSmall);
		airportManager = new AirportManager(airports);
		List<Airport> closestAirports = airportManager.getAirportsClosestTo("ANB", 1);
		System.out.println("\nTest 9a: AirportManager.getAirportsClosestTo('ANB', 1)");
		print(closestAirports);
		closestAirports = airportManager.getAirportsClosestTo("ANB", 2);
		System.out.println("\nTest 9b: AirportManager.getAirportsClosestTo('ANB', 2)");
		print(closestAirports);
		closestAirports = airportManager.getAirportsClosestTo("ANB", 3);
		System.out.println("\nTest 9c: AirportManager.getAirportsClosestTo('ANB', 3)");
		print(closestAirports);
		
	}

	public static void print(List<Airport> airports){
		for( Airport a : airports )
			System.out.println(a);
	}

}