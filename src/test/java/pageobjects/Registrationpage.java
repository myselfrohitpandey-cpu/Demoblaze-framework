package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Registrationpage extends Basepage {

	public Registrationpage(WebDriver driver) {
		super(driver);
	}
	
	//elements
	@FindBy(xpath="//input[@id='sign-username']")
	public WebElement uname;
	@FindBy(xpath="//input[@id='sign-password']") public WebElement pwd;
	@FindBy(xpath="//*[@id=\"signInModal\"]/div/div/div[3]/button[2]") public WebElement btnregister;
	
	
	

	
	//Actions methods
	
	public void fillUname(String name) {
		uname.sendKeys(name);
	}
	
	public void fillPwd(String password) {
		pwd.sendKeys(password);
	}
	
	public void clickSignup() {
		btnregister.click();;
	}
	
}
