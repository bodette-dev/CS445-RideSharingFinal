package main;

import java.util.ArrayList;
import java.util.List;

public class Ride {
	private int rid = 0;
	private int aid = 0;
	private LocationInfo location;
	private DateTime dateTime;
	private CarInfo carInfo;
	private int maxPassengers = 0;
	private double amountPerPassenger = 0.0;
	private String conditions = " ";
	
	private List<Message> messages = new ArrayList<Message>();
	private List<JoinRequest> requests = new ArrayList<JoinRequest>();
	
	public Ride(int aid, LocationInfo location, DateTime dateTime, CarInfo carInfo, int maxPassengers, double amountPerPassenger, String conditions) {
		this.rid = UniqueIdGenerator.getUniqueID();
		this.aid = aid;
		this.location = location;
		this.dateTime = dateTime;
		this.carInfo = carInfo;
		this.maxPassengers = maxPassengers;
		this.amountPerPassenger = amountPerPassenger;
		this.conditions = conditions;
	}

	public int getRid() {
		return rid;
	}

	public int getAid() {
		return aid;
	}

	public LocationInfo getLocation() {
		return location;
	}

	public void setLocation(LocationInfo location) {
		this.location = location;
	}

	public DateTime getDateTime() {
		return dateTime;
	}

	public void setDateTime(DateTime dateTime) {
		this.dateTime = dateTime;
	}

	public CarInfo getCarInfo() {
		return carInfo;
	}

	public void setCarInfo(CarInfo carInfo) {
		this.carInfo = carInfo;
	}

	public int getMaxPassengers() {
		return maxPassengers;
	}

	public void setMaxPassengers(int maxPassengers) {
		this.maxPassengers = maxPassengers;
	}

	public double getAmountPerPassenger() {
		return amountPerPassenger;
	}

	public void setAmountPerPassenger(double amountPerPassenger) {
		this.amountPerPassenger = amountPerPassenger;
	}

	public String getConditions() {
		return conditions;
	}

	public void setConditions(String conditions) {
		this.conditions = conditions;
	}
	
	public void newMessage(Message msg) {
		this.messages.add(msg);
	}
	
	public List<Message> getMessages() {
		return this.messages;
	}
	
	public void newRequest(JoinRequest join) {
		this.requests.add(join);
	}
	
	public List<JoinRequest> getRequests() {
		return this.requests;
	}
}
