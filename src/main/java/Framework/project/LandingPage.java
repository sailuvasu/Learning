package Framework.project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	public WebDriver driver;
	
	By signin= By.xpath("//span[text()='Login']");
	By homeTitle=By.xpath("//h2[text()='Featured Courses']");
	By nav_bar=By.xpath("//nav[@class='navbar-collapse collapse']/ul");
	
	
	public LandingPage(WebDriver driver) {
	
		this.driver = driver;
	}



	public WebElement login() {
		
		return driver.findElement(signin);
	}
	
	public WebElement title() {
		return driver.findElement(homeTitle);
	}
	
	
	public WebElement navigation() {
		return driver.findElement(nav_bar);
	}
	
	
	
	

}
