package main;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RideManager {
	private static List<Ride> rides = new ArrayList<Ride>();
	
	public Ride createRide(int aid, LocationInfo location, DateTime dateTime, CarInfo carInfo, int maxPassengers, double amountPerPassenger, String conditions) {
        Ride r = new Ride(aid, location, dateTime, carInfo, maxPassengers, amountPerPassenger, conditions);
        rides.add(r);
        return r;
    }
	
	public boolean updateRide(int rid, LocationInfo location, DateTime date, CarInfo car, int max, double amount, String condition) {
		for(int x = 0;x<rides.size();++x) {
			if(rides.get(x).getRid() == rid) {
				rides.get(x).setLocation(location);
				rides.get(x).setDateTime(date);
				rides.get(x).setCarInfo(car);
				rides.get(x).setMaxPassengers(max);
				rides.get(x).setAmountPerPassenger(amount);
				rides.get(x).setConditions(condition);
				return true;
			}
		}
		
		return false;
	}
	
	public boolean deleteRide(int rid) {
		for(int x = 0;x<rides.size();++x) {
			if(rides.get(x).getRid() == rid) {
				rides.remove(x);
				return true;
			}
		}
		
		return false;
	}
	
	public List<Ride> viewAllRides() {
		return rides;
	}
	
	public Ride viewRideDetail(int rid) { 
		for(int x = 0;x<rides.size();++x) {
			if(rides.get(x).getRid()==rid) {
				return rides.get(x);
			}
		}
		return null;
	}
	
	public List<Ride> searchRides(String fromCity, String toCity, String dateTime) {
		List<Ride> matches = new ArrayList<Ride>();
		
		if(fromCity.isEmpty()||toCity.isEmpty()||dateTime==null) {
			return rides;
		}
		
		for(int x = 0; x<rides.size();++x) {
			if(rides.get(x).getLocation().getFromCity().equals(fromCity) || rides.get(x).getLocation().getToCity().equals(toCity) || rides.get(x).getDateTime().equals(dateTime)) {
				matches.add(rides.get(x));
			}
		}
		
		return matches;
	}
	
	public JoinRequest requestJoinRide(int aid, int rid, int passengers) {
		Account act = AccountManager.findAccount(aid);
		JoinRequest join = new JoinRequest(aid,passengers);
		for(int x = 0;x<rides.size();++x) {
			if(rides.get(x).getRid()==rid) {
				rides.get(x).newRequest(join);
			}
		}
		
		return join;
	}
	
	public boolean confirmJoinRequest(int rid, int jid, boolean rideConfirmed) {
		for(int x = 0;x<rides.size();++x) { 
			if(rides.get(x).getRid()==rid) {
				for(int y = 0;y<rides.get(x).getRequests().size();++y) {
					if(rides.get(x).getRequests().get(y).getJid()==jid) { 
						rides.get(x).getRequests().get(y).setRideConfirmed(rideConfirmed);
						return true;
					}
				}
			}
		}
		
		return false;
	}
	
	public boolean confirmPickupRequest(int rid, int jid, boolean pickupConfirmed) {
		for(int x = 0;x<rides.size();++x) { 
			if(rides.get(x).getRid()==rid) { 
				for(int y = 0;y<rides.get(x).getRequests().size();++y) {
					if(rides.get(x).getRequests().get(y).getJid()==jid) { 
						rides.get(x).getRequests().get(y).setPickupConfirmed(pickupConfirmed);
						return true;
					}
				}
			}
		}
		
		return false;
	}
	
	public Message addMessage(int rid, int aid, String msg) {
		Message text = new Message(aid,msg);
		for(int x = 0;x<rides.size();++x) {
			if(rides.get(x).getRid()==rid) {
				rides.get(x).newMessage(text);
			}
		}
		return text;
	}
	
	public List<Message> getMessages(int rid) {
		for(int x = 0;x<rides.size();++x) { 
			if(rides.get(x).getRid()==rid) {
				return rides.get(x).getMessages();
			}
		}
		
		return new ArrayList<Message>();
	}
}