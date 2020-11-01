package Hackethon.TripAdvisor;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import baseClass.BaseSetup;



public class MainPage extends BaseSetup {
	
	public MainPage(WebDriver driver) {
		this.driver=(RemoteWebDriver) driver;
	}
	
	
	@FindBy(xpath="//div[@class='_30P0bmq0']/descendant::a[1]")
	List<WebElement> holidayHomes;

	@FindBy(xpath="//div[@class='KhjlbpT7']/div/div[2]")
	List<WebElement> price;
	
	@FindBy(xpath="//div[@class='lRYY2wxe']/span")
	public WebElement calIcon;
	
	@FindBy(xpath="//div[@class='ui_icon single-chevron-right-circle _3D4AxZN5 ']")
	public WebElement calForward;
	
	@FindBy(xpath="//div[@aria-label='Tue Dec 15 2020']")
	public WebElement checkIn;
	
	@FindBy(xpath="//div[@aria-label='Sun Dec 20 2020']")
	public WebElement checkOut;
	
	@FindBy(xpath="//div[@class='_2uJXqhFj']")
	public WebElement MemberIcon;
	
	@FindBy(xpath="//div[text()='guests']/parent::*//span[2]/span[@class='ui_icon plus HxR7KwIa']")
	public WebElement adultAdd;
	
	@FindBy(xpath="//button[text()='Apply']")
	public WebElement applyMember;
	
	@FindBy(xpath="//*[@id='component_2']/div/div[3]/div/div[1]/div[2]/div[1]/div[2]/div/div/div[1]")
	WebElement sort;
	
	@FindBy(xpath="//div[@class=\'CfqcQ1jD option _1_x2Cz-c TKbFeDUu\']")
	List <WebElement> rating;
	
	@FindBy(xpath="//div[text()='Amenities']/parent::*/div[6]/span[1]")
	public WebElement aminities;
	
	@FindBy(xpath="//div[text()='Elevator/Lift access (269)']")
	public WebElement selectAminities;
	
	
	
	public void Search_Date() {
		
		//Clicking on Calendar Icon
		calIcon.click();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Forwarding the Cal to December month
		
		calForward.click();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Selecting Check-in date
		
		checkIn.click();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		Selecting Check-out Date 
		
		checkOut.click();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
		
		
	public void Add_Member() {
		
		MemberIcon.click();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		adultAdd.click();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		adultAdd.click();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		applyMember.click();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		}
	
	public void sort() {
		sort.click();
		
		int i=2;
		rating.get(i).click();
	}
		
	public void Aminity() {
		
		aminities.click();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		selectAminities.click();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		}
	
	public void printConsole() throws IOException {
		
		
		//display top 5 Holiday Homes and their price
		//Iterating the loop for 5 times
        for(int i=0;i<5;i++)
        {
        	System.out.println(i+1+". "+holidayHomes.get(i).getText()+"  Rs"+price.get(i).getText().substring(1));
        	
        }
            
    }
	
	public void saveToXls() throws IOException {

		//Saving the data retrieved to xlsx file
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook();
	    XSSFSheet sheet = workbook.createSheet("Details");

	    Row row = sheet.createRow(0);
	    row.createCell(0).setCellValue("SNo.");
	    row.createCell(1).setCellValue("Holiday_Home");
	    row.createCell(2).setCellValue("Price");

	    for(int i=0;i<5;i++)
	    {
	    	row = sheet.createRow(i+1);
	    	row.createCell(0).setCellValue(i+1);
	    	row.createCell(1).setCellValue(holidayHomes.get(i).getText());
	    	row.createCell(2).setCellValue(price.get(i).getText());
	    }


	    FileOutputStream fos = new FileOutputStream(new File("Holiday_Homes.xlsx"));

	    workbook.write(fos);

	    fos.close();
	    
	}
	
	public Cruise switch_To() {
	
	return PageFactory.initElements(driver,Cruise.class);	
	
	}

}
