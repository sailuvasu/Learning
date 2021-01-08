package Framework.project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	
	public WebDriver driver;

	By email=By.id("user_email");
	By paswd=By.id("user_password");
	By submit=By.xpath("//input[@value='Log In']");
	
	
	public LoginPage(WebDriver driver) {
		
		this.driver = driver;
	}
	public WebElement email() {
		return driver.findElement(email);
	}
	public WebElement password() {
		return driver.findElement(paswd);
	}

	public WebElement login() {
		return driver.findElement(submit);
	}

	
}
