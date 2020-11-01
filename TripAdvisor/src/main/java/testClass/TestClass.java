package testClass;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import Hackethon.TripAdvisor.Cruise;
import Hackethon.TripAdvisor.CruiseSearch;
import Hackethon.TripAdvisor.HomePage;
import Hackethon.TripAdvisor.MainPage;
import Hackethon.TripAdvisor.Popup;
import baseClass.BaseSetup;

public class TestClass extends BaseSetup {
	
	HomePage home;
	Popup pop;
	MainPage main;
	Cruise cr;
	CruiseSearch cs;
	

	
	@Test(priority =1)
	public void test() throws Exception  {
		
		//Extent report 
		logger = report.createTest("Finding Holiday Homes");
		
		BaseSetup base=new BaseSetup();
//		try {
//		base.invokebrowser();
//		reportPass("Browser invoked successfully");
//		}catch(Exception e) {
//			reportFail(e.getMessage());
//		}
		
		
		try {
		home=openUrl();
		reportPass("Site opened successfullt");
		}catch(Exception e) {
			reportFail(e.getMessage());
		}
		
		try {
		pop = home.city();
		reportPass("Holiday home tab Clicked");
		}catch(Exception e) {
			reportFail(e.getMessage());			
		}

		try {
		main=pop.popUp();
		reportPass("City enter field found");
		}catch(Exception e) {
			reportFail(e.getMessage());
		}
		
		try {
		main.Search_Date();
		reportPass("Check-in and CheckOut date selected successfully");
		}catch(Exception e) {
			reportFail(e.getMessage());
		}
		
		try {
		main.Add_Member();
		reportPass("Member added Successfully");
		}catch(Exception e) {
			reportFail(e.getMessage());
		}
		
		Thread.sleep(10000);
		
		try {
		main.sort();
		reportPass("Member added Successfully");
		}catch(Exception e) {
			reportFail(e.getMessage());
		}
			
		
		try {
		main.Aminity();
		reportPass("Aminities Selected Successfully");
		}catch(Exception e) {
			reportFail(e.getMessage());
		}
		
		
		try {
		main.printConsole();
		reportPass("Data successfully printed on the console");
		}catch(Exception e) {
			reportFail(e.getMessage());
		}
		
		
		try {
		main.saveToXls();
		reportPass("Data saved to excel successfully");
		}catch(Exception e) {
			reportFail(e.getMessage());
		}
		
		try {
		cr=main.switch_To();
		reportPass("Page successfuly switch to cruise");
		}catch(Exception e) {
		reportFail(e.getMessage());	
		}
		
		try {
		cs=cr.clickCruiseButton();
		reportPass("Cruise tab click Successfully");
		}catch(Exception e) {
			reportFail(e.getMessage());
		}
		
		
		try {
		cs.cruiseSearch();
		reportPass("Cruise selected successfully and data is printed on console");	
		}catch(Exception e) {
			reportFail(e.getMessage());
		}
		
		try {
		cs.disXls();
		reportPass("Cruise selected successfully and data is printed on console");	
		}catch(Exception e) {
			reportFail(e.getMessage());
		}
		
		try {
		cs.langXls();
		reportPass("Cruise selected successfully and data is printed on console");	
		}catch(Exception e) {
			reportFail(e.getMessage());
		}
		
		
	}
	
	
	

}
