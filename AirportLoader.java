package prob1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class AirportLoader {
	
	// Write this method. It should read the airport file and return
	// a list of Airports.
	public static List<Airport> getAirportList(String fileName) throws FileNotFoundException {

		File inFile = new File(fileName);
		
		Scanner input = new Scanner(inFile);

		List<Airport> airports = new LinkedList<>();

		while (input.hasNext()) {
			String code = input.next();
			double latitude = input.nextDouble();
			double longitude = input.nextDouble();
			String city = input.next();
			String state = input.next();
			
			Airport a = new Airport(code, latitude, longitude, city, state);
			
			if(! airports.contains(a)){
				airports.add(a);
			}
		}
		input.close();
		
		return airports;
		}
	}
