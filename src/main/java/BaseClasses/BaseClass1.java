package BaseClasses;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import UtilityClasses.Util1;

public class BaseClass1 {
	
	static WebDriver driver = null;
	static ExtentHtmlReporter extentReporter ;
	static ExtentReports report;
	static ExtentTest test ;
	
	
	
	public static WebDriver getDriver(String browser) throws IOException {
		
		if(driver==null) {
		
		if(browser.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\Browsers\\chromedriver.exe");
		     driver = new ChromeDriver();
		}
		else if(browser.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "src\\main\\resources\\Browsers\\geckodriver_1.exe");
		     driver = new FirefoxDriver();
		}
		
		driver.get(Util1.getProperty("url"));
	    driver.manage().window().maximize();
	    
	    return driver;
    }
		else
		{
			return driver;
		}	
}
	public static ExtentHtmlReporter getHtmlReporter()
	{
		if(extentReporter == null)
		{
			extentReporter= new ExtentHtmlReporter("ExtentReporter.html");
		}
		return extentReporter;
	}
	
	public static ExtentTest getExtentTest(String testName)
	{
		
			test= report.createTest(testName);
			return test;
		
	} 
	
	public static ExtentReports getReports()
	{
		if(report == null)
		{
			report= new ExtentReports();
		 report.attachReporter(extentReporter);
		}
			return report;
		
	}
	
	
	

}
