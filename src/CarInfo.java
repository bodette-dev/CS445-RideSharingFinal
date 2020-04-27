package main;

public class CarInfo {
	private String make = " ";
	private String model = " ";
	private String color = " ";
	private String plate_state = " ";
	private String plate_serial = " ";
	
	public CarInfo(String make, String model, String color, String plate_state, String plate_serial) {
		this.make = make;
		this.model = model;
		this.color = color;
		this.plate_state = plate_state;
		this.plate_serial = plate_serial;
	}
	
	public String getMake() {
		return this.make;
	}
	
	public String getModel() {
		return this.model;
	}
	
	public String getColor() { 
		return this.color;
	}
	
	public String getPlateState() { 
		return this.plate_state;
	}
	
	public String getPlateSerial() {
		return this.plate_serial;
	}
}
