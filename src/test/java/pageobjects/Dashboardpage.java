package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Dashboardpage extends Basepage{
	
	public Dashboardpage(WebDriver driver){
		super(driver);
	}
	
	@FindBy(xpath="//a[@id='logout2']") public WebElement btnlogout;
	@FindBy(xpath="//a[@class='hrefch' and @href='prod.html?idp_=1']") public WebElement galaxys6;
	@FindBy(xpath="//a[text()='Cart']") public WebElement btncart;
	
	
	
	
	
	public void clickLogout() {
		btnlogout.click();
	}
	
	public void selectGalaxys6() {
		galaxys6.click();;
	}
	
	public void clickCart() {
		btncart.click();
	}
	
	
	public boolean displaybutton() {
		
	 boolean status= btnlogout.isDisplayed();
	 return status;
	}

}
