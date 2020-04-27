package main;

import java.util.List;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class AccountTest {
	
	@Test
	void testCreateAccount() {
		AccountManager a = new AccountManager();
		Account act = a.createAccount("Blake","Odette","773-234-8765","my.iit.edu",true);
		assertTrue(act.getAid()>0);
	}
	
	@Test
	void testActivateAccount() {
		AccountManager a = new AccountManager();
		Account act = a.createAccount("Blake","Odette","773-234-8765","my.iit.edu",true);
		boolean activate = a.activateAccount(act.getAid(),false);
		assertTrue(activate);
	}
	
	@Test
	void testViewAllAccounts() {
		AccountManager a = new AccountManager();
		Account act = a.createAccount("Blake","Odette","773-234-8765","my.iit.edu",true);
		List<Account> accounts = a.viewAllAccounts();
		assertTrue(accounts.size()>0);
	}
	
	@Test
	void testUpdateAccount() {
		AccountManager a = new AccountManager();
		Account act = a.createAccount("Blake","Odette","773-234-8765","my.iit.edu",true);
		boolean updated = a.updateAccount(act.getAid(),"Odette","Blake","773-125-4321","my.iit.edu",false);
		assertTrue(updated);
	}
	
	@Test
	void testViewDriverRatings() {
		AccountManager a = new AccountManager();
		DriverManager d = new DriverManager();
		Account act = a.createAccount("Blake","Odette","773-234-8765","my.iit.edu",true);
		Driver driver = d.createDriver(act.getAid(),"Blake",2,5,5.0,null);
		Rating rate = new Rating(1,23,"02-FEB-19",5,"Great driving!");
		assertTrue(rate.getSid()>0);
	}
	
	@Test
	void testViewRiderRatings() {
		AccountManager a = new AccountManager();
		RiderManager r = new RiderManager();
		Account act = a.createAccount("Blake","Odette","773-234-8765","my.iit.edu",true);
		Rider rider = r.createRider(act.getAid(),"Blake",2,5,5.0,null);
		Rating rate = new Rating(1,23,"02-FEB-19",5,"Great passenger!");
		assertTrue(rate.getSid()>0);
	}
	
	@Test
	void testRateAccount() {
		AccountManager a = new AccountManager();
		DriverManager d = new DriverManager();
		Account act = a.createAccount("Blake","Odette","773-234-8765","my.iit.edu",true);
		Driver driver = d.createDriver(act.getAid(),"Blake",2,5,5.0,null);
		Rating rate = new Rating(1,23,"02-FEB-19",5,"Great driving!");
		assertTrue(rate!=null);
	}
	
	@Test
	void testSearchAccounts() {
		AccountManager a = new AccountManager();
		Account act = a.createAccount("Blake","Odette","773-234-8765","my.iit.edu",true);
		List<Account> matches = a.searchAccounts("Blake");
		assertTrue(matches != null);
	}
}