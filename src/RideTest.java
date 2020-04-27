package main;

import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class RideTest {
	@Test
	void testCreateRide() {
		RideManager r = new RideManager();
		Account a = new Account("Blake","Odette","773-663-5522","my.iit.edu",true);
		LocationInfo l = new LocationInfo("Chicago",60652,"Oak Lawn",60415);
		CarInfo c = new CarInfo("Pontiac","Aztec","Green","IL","COVID19");
		DateTime d = new DateTime("25-Apr-2020","9:00");
		r.createRide(a.getAid(),l,d,c,3,12.0,"Please don't cough");
		assertTrue(r.viewAllRides().size()>0);
	}
	
	@Test
	void testUpdateRide() { 
		RideManager r = new RideManager();
		Account a = new Account("Blake","Odette","773-663-5522","my.iit.edu",true);
		LocationInfo l = new LocationInfo("Chicago",60652,"Oak Lawn",60415);
		CarInfo c = new CarInfo("Pontiac","Aztec","Green","IL","COVID19");
		DateTime d = new DateTime("25-Apr-2020","9:00");
		Ride ride = r.createRide(a.getAid(),l,d,c,3,12.0,"Please don't cough");
		r.updateRide(ride.getRid(),l,d,c,3,12.0,"Please don't sneeze or cough");
		assertEquals(r.viewRideDetail(ride.getRid()).getConditions(),"Please don't sneeze or cough");
	}
	
	@Test
	void testViewRideDetail() {
		RideManager r = new RideManager();
		Account a = new Account("Blake","Odette","773-663-5522","my.iit.edu",true);
		LocationInfo l = new LocationInfo("Chicago",60652,"Oak Lawn",60415);
		CarInfo c = new CarInfo("Pontiac","Aztec","Green","IL","COVID19");
		DateTime d = new DateTime("25-Apr-2020","9:00");
		Ride ride = r.createRide(a.getAid(),l,d,c,3,12.0,"Please don't cough");
		assertTrue(r.viewRideDetail(ride.getRid())!=null);
	}
	
	@Test
	void testViewAllRides() {
		RideManager r = new RideManager();
		Account a = new Account("Blake","Odette","773-663-5522","my.iit.edu",true);
		LocationInfo l = new LocationInfo("Chicago",60652,"Oak Lawn",60415);
		CarInfo c = new CarInfo("Pontiac","Aztec","Green","IL","COVID19");
		DateTime d = new DateTime("25-Apr-2020","9:00");
		r.createRide(a.getAid(),l,d,c,3,12.0,"Please don't cough");
		assertTrue(r.viewAllRides()!=null);
	}
	
	@Test 
	void testDeleteRide() { 
		RideManager r = new RideManager();
		Account a = new Account("Blake","Odette","773-663-5522","my.iit.edu",true);
		LocationInfo l = new LocationInfo("Chicago",60652,"Oak Lawn",60415);
		CarInfo c = new CarInfo("Pontiac","Aztec","Green","IL","COVID19");
		DateTime d = new DateTime("25-Apr-2020","9:00");
		Ride ride = r.createRide(a.getAid(),l,d,c,3,12.0,"Please don't cough");
		r.deleteRide(ride.getRid());
		assertTrue(r.viewRideDetail(ride.getRid())==null);
	}
	
	@Test
	void testSearchRides() {
		RideManager r = new RideManager();
		Account a = new Account("Blake","Odette","773-663-5522","my.iit.edu",true);
		LocationInfo l = new LocationInfo("Chicago",60652,"Oak Lawn",60415);
		CarInfo c = new CarInfo("Pontiac","Aztec","Green","IL","COVID19");
		DateTime d = new DateTime("25-Apr-2020","9:00");
		String dt = d.toString();
		r.createRide(a.getAid(),l,d,c,3,12.0,"Please don't cough");
		List<Ride> rides = r.searchRides("Chicago","Oak Lawn",dt);
		assertTrue(rides!=null);
	}
	
	@Test
	void testAddMessage() {
		RideManager r = new RideManager();
		Account a = new Account("Blake","Odette","773-663-5522","my.iit.edu",true);
		LocationInfo l = new LocationInfo("Chicago",60652,"Oak Lawn",60415);
		CarInfo c = new CarInfo("Pontiac","Aztec","Green","IL","COVID19");
		DateTime d = new DateTime("25-Apr-2020","9:00");
		Ride ride = r.createRide(a.getAid(),l,d,c,3,12.0,"Please don't cough");
		Message m = r.addMessage(ride.getRid(),a.getAid(),"I have arrived");
		assertTrue(m!=null);
	}
	
	@Test
	void testGetMessages() {
		RideManager r = new RideManager();
		Account a = new Account("Blake","Odette","773-663-5522","my.iit.edu",true);
		LocationInfo l = new LocationInfo("Chicago",60652,"Oak Lawn",60415);
		CarInfo c = new CarInfo("Pontiac","Aztec","Green","IL","COVID19");
		DateTime d = new DateTime("25-Apr-2020","9:00");
		Ride ride = r.createRide(a.getAid(),l,d,c,3,12.0,"Please don't cough");
		r.addMessage(ride.getRid(),a.getAid(),"I have arrived");
		List<Message> messages = r.getMessages(ride.getRid());
		assertTrue(messages.size()>0);
	}
	
	@Test
	void testRequestJoinRide() {
		AccountManager a = new AccountManager();
		RideManager r = new RideManager();
		Account act1 = a.createAccount("Blake","Odette","773-499-5667","my.iit.edu",true);
		Account act2 = a.createAccount("John","Doe","708-567-4992","my.iit.edu",true);
		LocationInfo l = new LocationInfo("Chicago",60652,"Oak Lawn",60415);
		CarInfo c = new CarInfo("Pontiac","Aztec","Green","IL","COVID19");
		DateTime d = new DateTime("25-Apr-2020","9:00");
		Ride ride1 = r.createRide(act1.getAid(),l,d,c,3,12.0,"No coughing");
		JoinRequest request = r.requestJoinRide(ride1.getRid(),act2.getAid(),2);
		assertTrue(request.getJid()>0);
	}
	
	@Test
	void testConfirmJoinRequest() {
		AccountManager a = new AccountManager();
		RideManager r = new RideManager();
		Account act1 = a.createAccount("Blake","Odette","773-499-5667","my.iit.edu",true);
		Account act2 = a.createAccount("John","Doe","708-567-4992","my.iit.edu",true);
		LocationInfo l = new LocationInfo("Chicago",60652,"Oak Lawn",60415);
		CarInfo c = new CarInfo("Pontiac","Aztec","Green","IL","COVID19");
		DateTime d = new DateTime("25-Apr-2020","9:00");
		Ride ride1 = r.createRide(act1.getAid(),l,d,c,3,12.0,"No coughing");
		JoinRequest request = r.requestJoinRide(act2.getAid(), ride1.getRid(), 2);
		boolean confirm = r.confirmJoinRequest(ride1.getRid(), request.getJid(), true);
		assertTrue(confirm);
	}
	
	@Test
	void testConfirmPickupRequest() {
		AccountManager a = new AccountManager();
		RideManager r = new RideManager();
		Account act1 = a.createAccount("Blake","Odette","773-499-5667","my.iit.edu",true);
		Account act2 = a.createAccount("John","Doe","708-567-4992","my.iit.edu",true);
		LocationInfo l = new LocationInfo("Chicago",60652,"Oak Lawn",60415);
		CarInfo c = new CarInfo("Pontiac","Aztec","Green","IL","COVID19");
		DateTime d = new DateTime("25-Apr-2020","9:00");
		Ride ride1 = r.createRide(act1.getAid(),l,d,c,3,12.0,"No coughing");
		JoinRequest request = r.requestJoinRide(act2.getAid(), ride1.getRid(), 2);
		boolean confirm = r.confirmPickupRequest(ride1.getRid(), request.getJid(), true);
		assertTrue(confirm);
	}
}