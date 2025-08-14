package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Purchaseflowpage extends Basepage {

	public Purchaseflowpage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//a[normalize-space()='Add to cart']") public WebElement addtocart;
	
	
	
	
	
	
	
	public void addToCart() {
		addtocart.click();
	}

}
