package main;

public class Account {
	private int aid = 0;
	private String firstName = " ";
	private String lastName = " ";
	private String phone = " ";
	private String pictureURL = " ";
	private boolean isActive;
	
	public Account(String firstName, String lastName, String phone, String pictureURL, boolean isActive) {
		this.aid = UniqueIdGenerator.getUniqueID();
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.pictureURL = pictureURL;
		this.isActive = isActive;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPictureURL() {
		return pictureURL;
	}

	public void setPictureURL(String pictureURL) {
		this.pictureURL = pictureURL;
	}

	public boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(boolean is_active) {
		this.isActive = is_active;
	}

	public int getAid() {
		return aid;
	}
}