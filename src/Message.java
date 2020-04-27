package main;

public class Message {
	private int mid = 0;
	private int aid = 0;
	private String msg = " ";
	
	public Message(int aid, String msg) { 
		this.mid = UniqueIdGenerator.getUniqueID();
		this.aid = aid;
		this.msg = msg;
	}

	public int getMid() {
		return mid;
	}

	public int getAid() {
		return aid;
	}

	public String getMsg() {
		return msg;
	}
}