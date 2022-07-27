package POMClasses;

import java.sql.Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import UtilityClasses.Util1;

public class HomePage extends Util1{
	
WebDriver driver;
	
	@FindBy(xpath="//div[text()='Mohini']")
	WebElement profileName;
	
	@FindBy(xpath="//div[text()='My Profile']")
	WebElement myProfileText;
	
	@FindBy(xpath="//img[@class='_2xm1JU']")
	WebElement flipkartLogo;
	
	
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	public boolean getProfileName() throws InterruptedException
	{
		Thread.sleep(1000);
		String pName = profileName.getText();
		
		if(pName.equals("Mohini"))
		{
			return true;
		}
		return false;
	}


	public void moveToprofileName()
	{
		Actions act = new Actions(driver);
		act.moveToElement(profileName).perform();		
	}
	
	public void clickOnProfileText()
	{
		WebElement element = explicitWait(driver,myProfileText);
		element.click();	
	}
	
	public void moveToFlipkartLogo()
	{
		Actions act = new Actions(driver);
		act.moveToElement(flipkartLogo).perform();		
	}
	
	public void explicitWaitProfileName()
	{
		explicitWait(driver,profileName);
	}
	
	
}
