package main;

public class Rating {
	private int sid = 0;
	private int rid = 0;
	private int sentByID = 0;
	private String date = " ";
	private int rating = 0;
	private String comment = " ";
	
	public Rating(int rid, int sentByID, String date, int rating) {
		this.sid = UniqueIdGenerator.getUniqueID();
		this.rid = rid;
		this.sentByID = sentByID;
		this.date = date;
		this.rating = rating;
	}
	
	public Rating(int rid, int sentByID, String date, int rating, String comment) {
		this.sid = UniqueIdGenerator.getUniqueID();
		this.rid = rid;
		this.sentByID = sentByID;
		this.date = date;
		this.rating = rating;
		this.comment = comment;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public int getSid() {
		return sid;
	}

	public int getRid() {
		return rid;
	}

	public int getSentByID() {
		return sentByID;
	}
	
	public String getDate() { 
		return date;
	}
}
