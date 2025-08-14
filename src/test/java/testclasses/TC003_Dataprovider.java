package testclasses;

import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageobjects.Dashboardpage;
import pageobjects.Homepage;
import pageobjects.Loginpage;
import testbase.Basetest;
import utilities.DataProviders;

public class TC003_Dataprovider extends Basetest {

	@Test(dataProvider="LoginData", dataProviderClass= DataProviders.class)
	
public void loginTest(String email, String password, String exp) throws Exception   {
		
		System.out.println("Starting test with: " + email + " | " + password + " | Expected: " + exp);
		Homepage hp=new Homepage(driver);
		hp.clickLogin();
	
		Loginpage lp=new Loginpage(driver);	
		
		super.mywait.until(ExpectedConditions.visibilityOf(lp.luname));
		lp.fillLuname(email);
		Thread.sleep(500);
		
		super.mywait.until(ExpectedConditions.visibilityOf(lp.lpwd));
		lp.fillLpwd(password);
		
		super.mywait.until(ExpectedConditions.visibilityOf(lp.loginbtn));
		lp.clickLlogin();
		
		Dashboardpage dp=new Dashboardpage(driver);
		
	    if (exp.equalsIgnoreCase("Valid")) {
	       
	        try {
	            mywait.until(ExpectedConditions.visibilityOf(dp.btnlogout));
	            if (dp.displaybutton()) {
	                dp.clickLogout();
	                Assert.assertTrue(true);
	            } else {
	                Assert.fail("Login successful but logout button not displayed");
	            }
	        } catch (Exception e) {
	            if (ExpectedConditions.alertIsPresent() != null) {
	                Alert alert = driver.switchTo().alert();
	                System.out.println("Unexpected alert during valid login: " + alert.getText());
	                alert.accept();
	            }
	            Assert.fail("Valid login failed unexpectedly.");
	        }

	    } else if (exp.equalsIgnoreCase("Invalid")) {
	        try {
	            mywait.until(ExpectedConditions.alertIsPresent());
	            Alert alert = driver.switchTo().alert();
	            System.out.println("Alert appeared: " + alert.getText());
	            alert.accept();
	            lp.luname.clear();
	            lp.lpwd.clear();
	            lp.clickClose();
	            Assert.assertTrue(true);
	        } catch (Exception e) {
	            if (dp.displaybutton()) {
	                dp.clickLogout();
	                Assert.fail("Invalid login succeeded unexpectedly.");
	            } else {
	                Assert.assertTrue(true);
	            }
	        }
	    } else {
	        Assert.fail("Unexpected 'exp' value: " + exp);
	    }
}}
