package Framework.project;



import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.lang.reflect.Array;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import resources.base;


public class HomePage extends base {
	public static Logger log = LogManager.getLogger(base.class.getName());
	public WebDriver driver;
	
	@BeforeTest
	public void start() throws IOException {
		driver=Initialize();		
		driver.get(prop.getProperty("URL"));
		log.info("Home page initialized");
	}
	
	@Test
	//(dataProvider="getData")
	public void Home() throws IOException {
	//public void home() throws IOException {
		LandingPage lp=new LandingPage(driver);
		
		lp.login().click();
		LoginPage lp1=new LoginPage(driver);
		lp1.email().sendKeys("abc");
		lp1.password().sendKeys("123");
		log.warn("invalid cred");
		lp1.login().click();	
		log.info("good");
		
	}
	
	@AfterTest
	public void finish() {
		log.debug("finished homepage");
		driver.close();
	}
	
	
	@DataProvider
	
	public Object[][] getData() {
		Object[][] data =new Object[2][3];
		
		data[0][0]="abc@gmail.com";
		data[0][1]="12345";
		data[0][2]="good";
		
		data[1][0]="def@gmailcom";
		data[1][1]="67899";
		data[1][2]="bad";
		
		return data;
		
	}

}
