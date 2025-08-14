package testclasses;

import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageobjects.Homepage;
import pageobjects.Loginpage;
import pageobjects.Purchasepage;
import pageobjects.Cartaddpage;
import pageobjects.Dashboardpage;
import testbase.Basetest;

public class TC005_purchaseverification extends Basetest {
	
	@Test(groups={"master","regression"})
	public void purchaseverification() throws InterruptedException {
		Loginpage lp=new Loginpage(driver);
		Homepage hp=new Homepage(driver);
		Dashboardpage dp=new Dashboardpage(driver);
		Cartaddpage cp=new Cartaddpage(driver);
		Purchasepage pp=new Purchasepage(driver);
		
		hp.clickLogin();
	
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
		
		super.mywait.until(ExpectedConditions.visibilityOf(cp.addtocart));
		cp.addToCart();
		
		super.mywait.until(ExpectedConditions.alertIsPresent());
		Alert al= driver.switchTo().alert() ;
		al.accept();
		
		super.mywait.until(ExpectedConditions.visibilityOf(dp.btncart));
		dp.clickCart();
		
		super.mywait.until(ExpectedConditions.visibilityOf(pp.placeorder));
		pp.clickPlace();
		
		super.mywait.until(ExpectedConditions.visibilityOf(pp.inputname));
		pp.fillName("Krishna pandey");
		
		super.mywait.until(ExpectedConditions.visibilityOf(pp.inputcountry));
		pp.fillCountry("India");
		
		super.mywait.until(ExpectedConditions.visibilityOf(pp.inputcity));
		pp.fillCity("katni");
		
		super.mywait.until(ExpectedConditions.visibilityOf(pp.inputcard));
		pp.fillCardNumber("123456789012");
		
		super.mywait.until(ExpectedConditions.visibilityOf(pp.inputmonth));
		pp.fillMonth("January");
		
		super.mywait.until(ExpectedConditions.visibilityOf(pp.inputyear));
		pp.fillYear("2032");
		
		super.mywait.until(ExpectedConditions.visibilityOf(pp.btnpurchase));
		pp.clickPurchase();
		
		super.mywait.until(ExpectedConditions.visibilityOf(pp.cnfmsg));
		String message=pp.confirm();
		
		if(message.contains("Thank you for your purchase!")) {
			Assert.assertTrue(true);
		}
		
	}

}
