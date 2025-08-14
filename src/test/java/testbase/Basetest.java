package testbase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import org.apache.logging.log4j.LogManager;//log4j


public class Basetest{


	static public WebDriver driver;
	public Logger logger;
	 public WebDriverWait mywait;
	 public String email;
	 public String url;
	 public String password;

@BeforeClass(groups= {"sanity","regression","master"})
@Parameters("browser")
public void setup(@Optional("chrome")String br) {
	
	 logger= LogManager.getLogger(this.getClass());	
	 
	 WebDriverManager.chromedriver().setup();
	 
	 try{
			FileInputStream file=new FileInputStream("C:\\Users\\RPG\\eclipse-workspace\\HybridFramework2\\src\\test\\resources\\config.properties");
			
			Properties p=new Properties();
			p.load(file);
			email= p.getProperty("email");
			password= p.getProperty("password");
			url= p.getProperty("url");
			}
			catch(IOException e) {
				e.printStackTrace();
			}

	  
	  switch(br.toLowerCase()){
		  case "chrome": driver=new ChromeDriver();break;
	      case "firefox":driver=new FirefoxDriver();break;
		  case "edge": driver=new EdgeDriver();break;
		  default: System.out.println("Invalid browser");
		  return;
	  }
	 
	 driver.get(url);
	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	 mywait=new WebDriverWait(driver, Duration.ofSeconds(10));
	 driver.manage().window().maximize();
	
}

@AfterClass(groups= {"sanity","regression","master"})
public void teardown() {
	driver.quit();
}

public String randomString() {
String randomstring= RandomStringUtils.randomAlphabetic(8);
return randomstring;
}

public String randomNumber() {
	String randomstring= RandomStringUtils.randomNumeric(8);
	return randomstring;
	}

public String randoAlphamNumeric() {
	String randomstring= RandomStringUtils.randomAlphanumeric(8);
	return randomstring;
	}

public String ruser=randomString()+ "@gmail.com";
public String rpwd=randoAlphamNumeric();

public String captureScreen(String name) {
	String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
	
	TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
	File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
	
	String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + name + "_" + timeStamp + ".png";
	File targetFile=new File(targetFilePath);
	
	sourceFile.renameTo(targetFile);
		
	return targetFilePath;
}

}
