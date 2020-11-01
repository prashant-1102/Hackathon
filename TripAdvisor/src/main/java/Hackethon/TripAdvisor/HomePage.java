package Hackethon.TripAdvisor;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.aventstack.extentreports.ExtentTest;

import baseClass.BaseSetup;

public class HomePage extends BaseSetup{
	
	public HomePage(WebDriver driver) {
		this.driver=(RemoteWebDriver) driver;
	}
	
	static Properties prop = readProperties();

	
	
	@FindBy(xpath="//a[@title='Holiday Homes']")
	public WebElement search;
	
	
	
	public Popup city() {
			
		// Clicking on the HolidayHomes Tab
		search.click();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		return PageFactory.initElements(driver, Popup.class);

	}

}
