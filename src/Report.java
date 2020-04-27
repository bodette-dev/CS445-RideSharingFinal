package main;

import java.util.List;

public class Report {
	private int pid = 0;
	private String name = " ";
	private String startDate = " ";
	private String endDate = " ";
	private int rides = 0;
	private List<LocationInfo> detail;
	
	public Report(String name, String startDate, String endDate, int rides, List<LocationInfo> detail) {
		this.pid = UniqueIdGenerator.getUniqueID();
		this.name = name;
		this.startDate = startDate;
		this.endDate = endDate;
		this.rides = rides;
		this.detail = detail;	
	}

	public int getPid() {
		return pid;
	}

	public String getName() {
		return name;
	}

	public String getStartDate() {
		return startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public int getRides() {
		return rides;
	}

	public List<LocationInfo> getDetail() {
		return detail;
	}
}
