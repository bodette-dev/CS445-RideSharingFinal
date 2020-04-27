package main;

import java.util.List;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ReportTest {
	
	@Test
	void testCreateReport() {
		ReportManager rm = new ReportManager();
		Report rep = rm.createReport("Blake Odette","12-APR-20","26-APR-20",3,null);
		assertTrue(rep != null);
	}
	
	@Test
	void testViewAllReports() {
		ReportManager rm = new ReportManager();
		Report rep = rm.createReport("Blake Odette","12-APR-20","26-APR-20",3,null);
		List<Report> reports = rm.viewAllReports();
		assertTrue(reports != null);
	}
	
	@Test
	void testGetReport() {
		ReportManager rm = new ReportManager();
		Report rep = rm.createReport("Blake Odette","12-APR-20","26-APR-20",3,null);
		Report rep2 = rm.getReport(rep.getPid());
		assertTrue(rep2 != null);
	}
}
