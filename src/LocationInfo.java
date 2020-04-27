package main;

public class LocationInfo {
	private String from_city = " ";
	private int from_zip = 0;
	private String to_city = " ";
	private int to_zip = 0;
	
	public LocationInfo(String from_city, String to_city) {
		this.from_city = from_city;
		this.to_city = to_city;
	}
	
	public LocationInfo(String from_city, int from_zip, String to_city, int to_zip) {
		this.from_city = from_city;
		this.from_zip = from_zip;
		this.to_city = to_city;
		this.to_zip = to_zip;
	}
	
	public String getFromCity() {
		return this.from_city;
	}
	
	public int getFromZip() {
		return this.from_zip;
	}
	
	public String getToCity() {
		return this.to_city;
	}
	
	public int getToZip() {
		return this.to_zip;
	}
}
