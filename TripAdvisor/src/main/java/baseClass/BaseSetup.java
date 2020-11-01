package baseClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Hackethon.TripAdvisor.HomePage;
import utilities.DateUtil;
import utilities.ExtentReportManager;


public class BaseSetup {
	
	public ExtentReports report = ExtentReportManager.getReportInstance();
	public ExtentTest logger;
	static Properties prop = readProperties();
	DesiredCapabilities cap=null;
	public RemoteWebDriver driver;
  
	//invoke browser
	
	@Parameters("browser")
	@Test(priority=0)
	public void invokebrowser(String browser) {
		try {
			if(browser.equalsIgnoreCase("chrome"))
			{
		     	cap=DesiredCapabilities.chrome();
				/*System.setProperty("webdriver.chrome.driver",prop.getProperty("chrome_path"));*/
		        /*driver=new ChromeDriver();*/
		       }
			else if(browser.equalsIgnoreCase("edge")) {
				cap=DesiredCapabilities.edge();
				/*System.setProperty("webdriver.gecko.driver",prop.getProperty("firefox_path"));*/
		        /*driver=new FirefoxDriver();*/
			     }
		     }catch(Exception e) {
		    	 System.out.println(e.getMessage());
		     }
		
		try {
			driver=new RemoteWebDriver(new URL("http://192.168.137.1:4444/wd/hub"),cap);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		driver.manage().timeouts().implicitlyWait(500,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		String URL = prop.getProperty("URL");
	    driver.get(URL);
		}
	
	//handle property file 
	public static Properties readProperties() {
		File file = new File("config.properties");
		  
		FileInputStream fileInput = null;
		
		try {
			fileInput = new FileInputStream(file);
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		Properties prop = new Properties();
		
		//load properties file
		try {
			prop.load(fileInput);
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		
		return prop;
	}
	
	public void reportPass(String reportString) {
		logger.log(Status.PASS, reportString);
	}

	public void takeScreenShot() {
		TakesScreenshot ss = (TakesScreenshot) driver;
		File src = ss.getScreenshotAs(OutputType.FILE);
		File dest = new File(System.getProperty("user.dir") + DateUtil.getTimeStamp() + ".png");

		try {
			FileUtils.copyFile(src, dest);
			logger.addScreenCaptureFromPath(System.getProperty("user.dir") + DateUtil.getTimeStamp() + ".png");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void reportFail(String reportString) {
		logger.log(Status.FAIL, reportString);
		takeScreenShot();
		Assert.fail();
	}
	
	public void clickElement(String LocatorValue) {

		if (LocatorValue.endsWith("_Id")) {
			driver.findElement(By.id(LocatorValue)).click();
		} else if (LocatorValue.endsWith("_XPath")) {
			driver.findElement(By.xpath(LocatorValue)).click();
		} else if (LocatorValue.endsWith("_ClassName")) {
			driver.findElement(By.className(LocatorValue)).click();
		} else if (LocatorValue.endsWith("_TagName")) {
			driver.findElement(By.tagName(LocatorValue)).click();
		} else if (LocatorValue.endsWith("_LinkText")) {
			driver.findElement(By.linkText(LocatorValue)).click();
		}

	}
	
	public void ExplicitWait(String LocatorValue) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		if (LocatorValue.endsWith("_Id")) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(LocatorValue)));
		} else if (LocatorValue.endsWith("_XPath")) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LocatorValue)));
		} else if (LocatorValue.endsWith("_ClassName")) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(LocatorValue)));
		} else if (LocatorValue.endsWith("_TagName")) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName(LocatorValue)));
		} else if (LocatorValue.endsWith("_LinkText")) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(LocatorValue)));
		}

	}
	
	
	//URL 
	public HomePage openUrl() {
		
	//    timewait(100);
	     return PageFactory.initElements(driver, HomePage.class);
	}
	//Title validation
//	public static boolean getTitle(String expectedTitle) {
//		Assert.assertEquals(driver.getTitle(), expectedTitle);
//		return true;
//	}
	public void timewait(int time) {
			try {
				Thread.sleep(time*500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	
	@AfterSuite
	public void close() {
		driver.close();
		report.flush();
		//
	}

}
