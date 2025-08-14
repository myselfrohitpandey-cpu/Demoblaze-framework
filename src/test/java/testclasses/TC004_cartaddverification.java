package testclasses;

import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageobjects.Dashboardpage;
import pageobjects.Homepage;
import pageobjects.Loginpage;
import pageobjects.Cartaddpage;
import testbase.Basetest;

public class TC004_cartaddverification extends Basetest{
	
	@Test(groups={"master","sanity"})
	public void purchasetest() throws InterruptedException {
		
		Homepage hp=new Homepage(driver);
		Dashboardpage dp=new Dashboardpage(driver);

		hp.clickLogin();
	
		Loginpage lp=new Loginpage(driver);	
		
		super.mywait.until(ExpectedConditions.visibilityOf(lp.luname));
		lp.fillLuname("Krishna123@gmail.com");
		Thread.sleep(500);
		
		super.mywait.until(ExpectedConditions.visibilityOf(lp.lpwd));
		lp.fillLpwd("Krishn@123");
		
		super.mywait.until(ExpectedConditions.visibilityOf(lp.loginbtn));
		lp.clickLlogin();
		
		super.mywait.until(ExpectedConditions.visibilityOf(dp.btnlogout));
		super.mywait.until(ExpectedConditions.visibilityOf(dp.galaxys6));
		dp.selectGalaxys6();
		
		Cartaddpage pp=new Cartaddpage(driver);
		super.mywait.until(ExpectedConditions.visibilityOf(pp.addtocart));
		pp.addToCart();
		
		
		super.mywait.until(ExpectedConditions.alertIsPresent());
		Alert al= driver.switchTo().alert() ;
		
		String alertmsg= al.getText();
		
		al.accept();
		Assert.assertEquals(alertmsg, "Product added.");
		
		
	}
	
	
	

}
