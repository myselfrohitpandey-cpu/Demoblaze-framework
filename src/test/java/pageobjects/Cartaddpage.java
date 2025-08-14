package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Cartaddpage extends Basepage {

	public Cartaddpage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//a[normalize-space()='Add to cart']") public WebElement addtocart;
	
	
	
	
	
	
	
	public void addToCart() {
		addtocart.click();
	}

}
