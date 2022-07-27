package POMClasses;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import UtilityClasses.Util1;

public class ProfilePage extends Util1{
	
WebDriver driver;
	
	@FindBy(xpath="//div[text()='Mohini Patil']")
	WebElement profileFullName;
	
	@FindBy(xpath="//div[text()='Manage Addresses']")
	WebElement manageAddressesText;
	
	@FindBy(xpath="//div[text()='ADD A NEW ADDRESS']")
	WebElement addNewAddressText;
	
	@FindBy(xpath="//div[@class='_1lRtwc _1Jqgld']/input")
	List <WebElement> addressInputFields;
	
	@FindBy(xpath="//textarea[@autocomplete='street-address']")
	WebElement detailAddress;
		
	@FindBy(xpath="//button[text()='Save']")
	WebElement saveBtn;
	
	@FindBy(xpath="//div[@class='_1CeZIA']")
	List <WebElement> savedAddressCount;
		
	
	public ProfilePage(WebDriver driver) 
	{
	  PageFactory.initElements(driver, this);	
	  this.driver = driver;
	}
	
	public boolean getFullProfileName()
	{
		WebElement element = explicitWait(driver,profileFullName);
		String fullName = element.getText();
		
		if(fullName.contains("Mohini"))
		{
			return true;
		}
		return false;
	}
	
	public void clickOnManageAddress() throws InterruptedException
	{
		manageAddressesText.click();
//		Thread.sleep(2000);
	}
	
	public void clickOnAddNewAddress()
	{
		explicitWait(driver,addNewAddressText);
		addNewAddressText.click();
	}
	
	public void addAddressDetails()
	{	
		List<String> fieldDetails = new ArrayList<>();
		fieldDetails.add("rohini");
		fieldDetails.add("9763345600");
		fieldDetails.add("413402");
		fieldDetails.add("vairag");
		
		System.out.println(fieldDetails);
		
		for(int i=0;i<4;i++)
		{
			addressInputFields.get(i).sendKeys(fieldDetails.get(i));
		    if(i==4)
		    break;
		}
		
	}
	
	public void addMainAddress()
	{
		detailAddress.sendKeys("ShivajiNagar,Madha road,Vairag");
	}
    public void clickOnSaveBtn()
	{
			Actions act = new Actions(driver);
			act.click(saveBtn).perform();
	}
    
    public int addressCount()
    {	
    	return savedAddressCount.size();
    }
	
	
	}


