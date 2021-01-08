package Framework.project;


import java.io.IOException;
import java.lang.reflect.Array;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import resources.base;


public class VerifyNav extends base {
	public static Logger log = LogManager.getLogger(base.class.getName());
	
	public WebDriver driver;
	@BeforeTest
	public void initialize() throws IOException {
		driver=Initialize();		
		driver.get(prop.getProperty("URL"));
		log.error("Verify nav initialized");
	}
	
	@Test
	public void validateNav ()throws IOException {
	//public void home() throws IOException {
		
		LandingPage lp=new LandingPage(driver);
		
		
		log.warn("vverify nav");
		Assert.assertTrue(lp.navigation().isDisplayed());
	
		
	}
	
	@AfterTest
	public void finish() {
		log.debug("finished verify nav");
		driver.close();
	}
		
		
}