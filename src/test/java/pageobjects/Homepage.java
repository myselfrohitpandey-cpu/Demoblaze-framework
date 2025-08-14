package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Homepage extends Basepage {

	
	
	public Homepage(WebDriver driver) {
		super(driver);
	}


	//webelements
	@FindBy(xpath="//a[@id='signin2']") 
	WebElement btnsignup;

	@FindBy(xpath="//a[@id='login2']") 
	WebElement btnlogin ;
	
	@FindBy(xpath="//a[@id='cartur']") 
	WebElement btncart ;
	
	//methods
	

public void clickLogin()
{
	btnlogin.click();
}

public void clickSignup()
{
	btnsignup.click();
}

public void clickcart()
{
	btncart.click();
}

}

