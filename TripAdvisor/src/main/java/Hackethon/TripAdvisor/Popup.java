package Hackethon.TripAdvisor;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import baseClass.BaseSetup;

public class Popup extends BaseSetup {
	
	public Popup(WebDriver driver) {
		this.driver=(RemoteWebDriver) driver;
	}

	
	@FindBy(xpath="//div[@class='i3bZ_gBa _2RTs3_Ee _3TPJs5_m _3awdcWrG']/form/input[@class='_3qLQ-U8m']")
	public WebElement citySearch;
	
	@FindBy(xpath="//div[@class='_27pk-lCQ']/a[1]/div[2]")
	public WebElement citySelect;
	
	public MainPage popUp() {
		//has parking
		citySearch.sendKeys("Nairobi");
		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		citySelect.click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return PageFactory.initElements(driver,MainPage.class);	
	}

}
