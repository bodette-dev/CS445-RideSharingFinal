package main;

import java.util.List;
import java.util.ArrayList;

public class ReportManager {
	private static List<Report> reports = new ArrayList<Report>();
	
	public Report createReport(String name, String startDate, String endDate, int rides, List<LocationInfo> detail) {
		Report rep = new Report(name,startDate,endDate,rides,detail);
		reports.add(rep);
		return rep;
	}
	
	public List<Report> viewAllReports() {
		return reports;
	}
	
	public Report getReport(int pid) {
		for(int x = 0;x<reports.size();++x) {
			if(reports.get(x).getPid()==pid) {
				return reports.get(x);
			}
		}
		
		return null;
	}
}
