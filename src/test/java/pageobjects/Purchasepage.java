package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Purchasepage extends Basepage{

	public Purchasepage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//button[text()='Place Order']") public WebElement placeorder;
	@FindBy(xpath="//input[@id='name' and @class='form-control']") public WebElement inputname;
	@FindBy(xpath="//input[@id='country' and @class='form-control']") public WebElement inputcountry;
	@FindBy(xpath="//input[@id='city' and @class='form-control']") public WebElement inputcity;
	@FindBy(xpath="//input[@id='card' and @class='form-control']") public WebElement inputcard;
	@FindBy(xpath="//input[@id='month' and @class='form-control']") public WebElement inputmonth;
	@FindBy(xpath="//input[@id='year' and @class='form-control']") public WebElement inputyear;
	@FindBy(css="div.sweet-alert.showSweetAlert.visible") public WebElement cnfmsg;
	
	@FindBy(xpath="//button[text()='Purchase']") public WebElement btnpurchase;
	
	
	
	public void fillName(String name) {
		inputname.sendKeys(name);
	}
	
	public void fillCountry(String name) {
		inputcountry.sendKeys(name);
	}
	
	public void fillCity(String name) {
		inputcity.sendKeys(name);
	}
	
	public void fillCardNumber(String name) {
		inputcard.sendKeys(name);
	}
	
	public void fillMonth(String name) {
		inputmonth.sendKeys(name);
	}
	
	public void fillYear(String name) {
		inputyear.sendKeys(name);
	}
	
	public void clickPurchase() {
		btnpurchase.click();
	}
	
	public void clickPlace() {
		placeorder.click();
	}
	
	public String confirm() {
		String msg=cnfmsg.getText();
		return msg;
	}
	

}
