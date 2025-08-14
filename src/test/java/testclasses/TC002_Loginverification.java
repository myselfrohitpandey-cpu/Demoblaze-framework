package testclasses;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageobjects.Dashboardpage;
import pageobjects.Homepage;
import pageobjects.Loginpage;
import testbase.Basetest;

public class TC002_Loginverification extends Basetest {
	
	@Test(groups={"master","regression"})
	public void loginTest() throws InterruptedException {
		
		Homepage hp=new Homepage(driver);
		hp.clickLogin();
	
		Loginpage lp=new Loginpage(driver);	
		
		super.mywait.until(ExpectedConditions.visibilityOf(lp.luname));
		lp.fillLuname(super.email);
		Thread.sleep(500);
		
		super.mywait.until(ExpectedConditions.visibilityOf(lp.lpwd));
		lp.fillLpwd(super.password);
		
		super.mywait.until(ExpectedConditions.visibilityOf(lp.loginbtn));
		lp.clickLlogin();
		
		Dashboardpage dp=new Dashboardpage(driver);
		
		super.mywait.until(ExpectedConditions.visibilityOf(dp.btnlogout));
		
//		System.out.println(dp.displaybutton());
		Assert.assertTrue(dp.displaybutton());		

	}

}
