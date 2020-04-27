package main;

import java.util.List;
import java.util.ArrayList;

public class DriverManager {
	private static List<Driver> drivers = new ArrayList<Driver>();
	
	public Driver createDriver(int aid, String firstName, int rides, int ratings, double averageRating, List<Rating> detail) {
		Driver drive = new Driver(aid,firstName,rides,ratings,averageRating,detail);
		drivers.add(drive);
		return drive;
	}
	
	public List<Driver> getDrivers() {
		return drivers;
	}
	
	
}