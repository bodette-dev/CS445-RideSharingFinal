package main;

public class JoinRequest {
	private int jid = 0;
	private int aid = 0;
	private int passengers = 0;
	private boolean rideConfirmed;
	private boolean pickupConfirmed;
	
	public JoinRequest(int aid, int passengers) {
		this.jid = UniqueIdGenerator.getUniqueID();
		this.aid = aid;
		this.passengers = passengers;
	}

	public int getPassengers() {
		return passengers;
	}

	public void setPassengers(int passengers) {
		this.passengers = passengers;
	}

	public int getJid() {
		return jid;
	}

	public int getAid() {
		return aid;
	}

	public void setRideConfirmed(boolean rideConfirmed) {
		this.rideConfirmed = rideConfirmed;
	}

	public void setPickupConfirmed(boolean pickupConfirmed) {
		this.pickupConfirmed = pickupConfirmed;
	}
}
