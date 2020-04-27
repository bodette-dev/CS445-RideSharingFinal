package main;

public class DateTime {
	private String date = " ";
	private String time = " ";
	
	public DateTime(String date, String time) {
		this.date = date;
		this.time = time;
	}
	
	public String getDate() { 
		return this.date;
	}
	
	public String getTime() {
		return this.time;
	}
}