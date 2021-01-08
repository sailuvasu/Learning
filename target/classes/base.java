package resources;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class base {
	public WebDriver driver;
	public Properties prop;
	

	
	public WebDriver Initialize() throws IOException {
	
		
		String path=System.getProperty("user.dir")+"\\src\\main\\java\\resources\\data.properties";		
		 prop=new Properties();
		FileInputStream fis=new FileInputStream(path);
		prop.load(fis);
		//String browserName=System.getProperty("browser");
		String browserName=prop.getProperty("browser");
		if(browserName.contains("chrome"))
		{
			
			System.setProperty("webdriver.chrome.driver", "C://Program Files//chromedriver_win32//chromedriver.exe");
			
			if(browserName.contains("headless"))
			{
			ChromeOptions options=new ChromeOptions();
			options.addArguments("headless");
			 driver=new ChromeDriver(options);
			}
			else
			 driver=new ChromeDriver();
			
		}
		
		else if(browserName.equals("fireFox"))
		{
			//
		}
		else if(browserName.equals("ie"))
		{
			//
		}
		//String url =prop.getProperty("URL");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		return driver;
	}
	
	public String Screenshot(String testCaseName,WebDriver driver) throws IOException {
		
		TakesScreenshot ss=(TakesScreenshot)driver;
		File source=ss.getScreenshotAs(OutputType.FILE);
		String dest=System.getProperty("user.dir")+"\\Reports\\Screenshots\\"+testCaseName+".png";
		File destFile=new File(dest);
		FileUtils.copyFile(source, destFile);
		return dest;
		
		
	}

}
