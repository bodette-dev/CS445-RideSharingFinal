package main;

import java.util.List;
import java.util.ArrayList;

public class RiderManager {
	private static List<Rider> riders = new ArrayList<Rider>();
	
	public Rider createRider(int aid, String firstName, int rides, int ratings, double averageRating, List<Rating> detail) {
		Rider ride = new Rider(aid,firstName,rides,ratings,averageRating,detail);
		riders.add(ride);
		return ride;
	}
	
	public List<Rider> getRiders() {
		return riders;
	}
}