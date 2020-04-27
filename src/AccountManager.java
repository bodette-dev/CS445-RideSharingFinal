package main;

import java.util.ArrayList;
import java.util.List;

public class AccountManager {
	private static List<Account> accounts = new ArrayList<Account>();
	
	public Account createAccount(String firstName, String lastName, String phone, String pictureURL, boolean isActive) {
        Account a = new Account(firstName, lastName, phone, pictureURL, isActive);
        accounts.add(a);
        return a;
    }
	
	public boolean updateAccount(int aid, String firstName, String lastName, String phone, String pictureURL, boolean isActive) {
		for(int x = 0;x<accounts.size();++x) {
			if(accounts.get(x).getAid() == aid) {
				accounts.get(x).setFirstName(firstName);
				accounts.get(x).setLastName(lastName);
				accounts.get(x).setPhone(phone);
				accounts.get(x).setPictureURL(pictureURL);
				accounts.get(x).setIsActive(isActive);
				return true;
			}
		}
		
		return false;
	}
	
	public List<Account> viewAllAccounts() {
		return accounts;
	}
	
	public List<Account> searchAccounts(String key) {
		List<Account> matches = new ArrayList<Account>();
		
		if(key.isEmpty()) {
			return accounts;
		}
		
		for(int x = 0; x<accounts.size();++x) {
			if(accounts.get(x).getFirstName().equals(key) || accounts.get(x).getLastName().equals(key) || accounts.get(x).getPhone().equals(key)) {
				matches.add(accounts.get(x));
			}
		}
		
		return matches;
	}
	
	public static Account findAccount(int aid) {
		for(int x = 0;x<accounts.size();++x) {
			if(accounts.get(x).getAid()==aid) {
				return accounts.get(x);
			}
		}
		
		return null;
	}
	
	public boolean activateAccount(int aid, boolean isActive) {
		for(int x = 0;x<accounts.size();++x) {
			if(accounts.get(x).getAid()==aid) {
				accounts.get(x).setIsActive(isActive);
				return true;
			}
		}
		
		return false;
	}
	
	public Rating rateAccount(int aid, Rating rate) {
		DriverManager d = new DriverManager();
		for(int x = 0;x<d.getDrivers().size();++x) {
			if(d.getDrivers().get(x).getAid()==aid) {
				d.getDrivers().get(x).getDetail().add(rate);
				return rate;
			}
		}
		
		return null;
	}
	
	public List<Rating> viewDriverRatings(int aid) {
		DriverManager d = new DriverManager();
		for(int x = 0;x<d.getDrivers().size();++x) {
			if(d.getDrivers().get(x).getAid()==aid) {
				return d.getDrivers().get(x).getDetail();
			}
		}
		
		return null;
	}
	
	public List<Rating> viewRiderRatings(int aid) {
		RiderManager r = new RiderManager();
		for(int x = 0;x<r.getRiders().size();++x) {
			if(r.getRiders().get(x).getAid()==aid) {
				return r.getRiders().get(x).getDetail();
			}
		}
		
		return null;
	}
}
