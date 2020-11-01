package Hackethon.TripAdvisor;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;

import baseClass.BaseSetup;

public class CruiseSearch extends BaseSetup{
	
	public CruiseSearch(WebDriver driver) {
		this.driver=(RemoteWebDriver) driver;
	}
//	
	
	@FindBy(xpath="//div[@id='cruise_line_dropdown']")
	public WebElement cruiseLine_dropdown;
	
	@FindBy(xpath= "//div[@class='CfqcQ1jD option TKbFeDUu']")
	List< WebElement> cruiseLine_choice;
	
	@FindBy(xpath="/html/body/div[2]/div/div/div[3]/div/div[2]/div")
	public WebElement cruiseShip_dropdown;
	
	@FindBy(xpath="//div[@class=\'CfqcQ1jD option TKbFeDUu\']")
	List< WebElement> cruiseShip_choice;
	
	@FindBy(xpath="//button [@class=\'_1JOGv2rJ _1_M9wxW9 _32M3JNKp _3yBiBka1 _3fiJJkxX\']")
	public WebElement searchButton;
	
	@FindBy(xpath="//div[@class='_30ZCn9lR']/div")
	List<WebElement> description;
	
	@FindBy(xpath="//li[@class='ui_radio _3gEj_Jb5 _2SqbCAu5']/label/span[1]")
	List<WebElement> lang;
	
	public void cruiseSearch() throws InterruptedException  {
		
		//selecting the Cruise Line
		Thread.sleep(5000);
		cruiseLine_dropdown.click();
		//selecting the Norwegian CruiseLine
		int i=73;
		cruiseLine_choice.get(i).click();
		
		Thread.sleep(5000);
		//selecting the ShipLine
		 cruiseShip_dropdown.click();
		//selecting Norwegian Epic
		 
		 Thread.sleep(5000);
		int j=3;
		cruiseShip_choice.get(j).click();
		Thread.sleep(5000);
		
		
		
		searchButton.click();
		
		Set<String> id = driver.getWindowHandles();
		Iterator<String> it= id.iterator();
	    String id1= it.next();
	    String id2= it.next();
		
	    driver.switchTo().window(id2);
	    
	    
	    Thread.sleep(10000);
	    

				
		    for(int k=0;k<4;k++){
		    	
		    	System.out.println((k+1)+description.get(k).getText());
		    }
		

	        for(int k=0;k<4;k++){
	        	System.out.println((k+1)+". "+lang.get(k).getText());
	        }
	        
	 }
	
	public void disXls() throws IOException {

		//Saving the data retrieved to xlsx file
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook();
	    XSSFSheet sheet = workbook.createSheet("Details");

	    Row row = sheet.createRow(0);
	    row.createCell(0).setCellValue("SNo.");
	    row.createCell(1).setCellValue("Cruise Discription");

	    for(int i1=0;i1<4;i1++)
	    {
	    	row = sheet.createRow(i1+1);
	    	row.createCell(0).setCellValue(i1+1);
	    	row.createCell(1).setCellValue(description.get(i1).getText());
	    }


	    FileOutputStream fos = new FileOutputStream(new File("Cruise_Discription.xlsx"));

	    workbook.write(fos);

	    fos.close();
	    
	} 
	
	public void langXls() throws IOException {

		//Saving the data retrieved to xlsx file
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook();
	    XSSFSheet sheet = workbook.createSheet("Details");

	    Row row = sheet.createRow(0);
	    row.createCell(0).setCellValue("SNo.");
	    row.createCell(1).setCellValue("Language Offered");

	    for(int i1=0;i1<4;i1++)
	    {
	    	row = sheet.createRow(i1+1);
	    	row.createCell(0).setCellValue(i1+1);
	    	row.createCell(1).setCellValue(lang.get(i1).getText());
	    }


	    FileOutputStream fos = new FileOutputStream(new File("Cruise_Language.xlsx"));

	    workbook.write(fos);

	    fos.close();
	    
	}   
	

}
