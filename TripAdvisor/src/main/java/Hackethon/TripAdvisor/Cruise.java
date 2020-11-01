package Hackethon.TripAdvisor;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import baseClass.BaseSetup;

public class Cruise extends BaseSetup{
	
	public Cruise(WebDriver driver) {
		this.driver=(RemoteWebDriver) driver;
	}

	@FindBy(xpath="//*[(text()='Cruises')]")
	public WebElement cruise_button;
	
	public CruiseSearch clickCruiseButton() {
		cruise_button.click();
		return PageFactory.initElements(driver, CruiseSearch.class);
	}

}
