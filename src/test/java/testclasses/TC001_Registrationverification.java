package testclasses;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageobjects.Homepage;
import pageobjects.Registrationpage;
import testbase.Basetest;

public class TC001_Registrationverification extends Basetest {
		
		
		@Test(groups={"master","sanity"})
		public void testrun() throws InterruptedException {
			
			//logger.debug("This is starting of TC001_Registrationverification ");
			//logger.debug("This is debug message");
		

			
			Homepage hp=new Homepage(driver);
			hp.clickSignup();
			
			Registrationpage rp=new Registrationpage(driver);
			
			
			super.mywait.until(ExpectedConditions.visibilityOf(rp.uname));
			rp.fillUname(ruser);
			super.mywait.until(ExpectedConditions.visibilityOf(rp.uname));
			rp.fillPwd(rpwd);
			
			rp.clickSignup();
			
			Alert signupal= super.mywait.until(ExpectedConditions.alertIsPresent());
			
			 
			String confirmation=signupal.getText();
			
			if(confirmation.equals("Sign up successful.")) {
			
				Assert.assertTrue(true);
			}
			else {
				Assert.assertTrue(false);
				}			

		}}			
