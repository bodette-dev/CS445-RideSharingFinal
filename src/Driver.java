package main;

import java.util.List;

public class Driver {
	private int aid = 0;
	private String firstName = " ";
	private int rides = 0;
	private int ratings = 0;
	private double averageRating = 0.0;
	private List<Rating> detail;
	
	public Driver(int aid, String firstName, int rides, int ratings, double averageRating, List<Rating> detail) {
		this.aid = aid;
		this.firstName = firstName;
		this.rides = rides;
		this.ratings = ratings;
		this.averageRating = averageRating;
		this.detail = detail;
	}

	public int getRides() {
		return rides;
	}

	public void setRides(int rides) {
		this.rides = rides;
	}

	public int getRatings() {
		return ratings;
	}

	public void setRatings(int ratings) {
		this.ratings = ratings;
	}

	public double getAverageRating() {
		return averageRating;
	}

	public void setAverageRating(double averageRating) {
		this.averageRating = averageRating;
	}

	public int getAid() {
		return aid;
	}

	public String getFirstName() {
		return firstName;
	}

	public List<Rating> getDetail() {
		return detail;
	}

	public void setDetail(List<Rating> detail) {
		this.detail = detail;
	}
}