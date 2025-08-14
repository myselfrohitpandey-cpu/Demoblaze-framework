package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Loginpage extends Basepage {

	public Loginpage(WebDriver driver) {
		super(driver);
	}
	
	//elements
	@FindBy(xpath="//input[@id=\"loginusername\"]") public WebElement luname;
	@FindBy(xpath="//input[@id='loginpassword']") public WebElement lpwd;
	@FindBy(xpath="//*[@id=\"logInModal\"]/div/div/div[3]/button[2]") public WebElement loginbtn;
	@FindBy(xpath="//*[@id=\"logInModal\"]/div/div/div[3]/button[1]") public WebElement closebtn;
	
	
	
	

	
	//Actions methods
	
	public void fillLuname(String name) {
		luname.sendKeys(name);
	}
	
	public void fillLpwd(String password) {
		lpwd.sendKeys(password);
	}
	
	public void clickLlogin() {
		loginbtn.click();;
	}
	public void clickClose() {
		closebtn.click();;
	}

	
}
