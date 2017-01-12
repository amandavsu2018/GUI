package prob1;

import java.text.DecimalFormat;

public final class Airport {

	DecimalFormat df = new DecimalFormat("#.0");
	
	private String code;
	private double latitude;
	private double longitude;
	private String city;
	private String state;
	
	public Airport(String code, double latitude, double longitude, String city, String state){
		this.code = code;
		this.latitude = latitude;
		this.longitude = longitude;
		this.city = city;
		this.state = state;
	}
	
	public Airport(String code){
		this.code = code;
	}
	
	@Override
	public final String toString(){
		String s = code + "-" + city + "," + state + ": " + df.format(latitude) + ", " + df.format(longitude);
		return s;
	}

	public boolean equals(Object o){
		Airport a = (Airport) o;
		if(this.code.equals(a.getCode())){
			return true;
		}
		else{
			return false;
		}
	}
	
	public String getCode() {
		return code;
	}

	public double getLatitude() {
		return latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public String getCity() {
		return city;
	}

	public String getState() {
		return state;
	}


}
