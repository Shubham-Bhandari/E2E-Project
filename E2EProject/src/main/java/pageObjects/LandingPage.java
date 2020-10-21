package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.aventstack.extentreports.Status;

import resources.Base;

public class LandingPage extends Base {
	
	public WebDriver driver;
	
	
	@FindBy(xpath = "//a[@class='login']")
	WebElement signin;

	@FindBy(name = "email")
	WebElement email;

	@FindBy(name = "passwd")
	WebElement password;

	@FindBy(name = "SubmitLogin")
	WebElement submit;

	By Title = By.xpath("//*[@id=\\\"editorial_block_center\\\"]/h1");
	
	
	

	public void loginTest() throws Throwable {

		Thread.sleep(3000);
		signin.click();
		Thread.sleep(2000);
		logger1.log(Status.PASS, "Sigin button clicked");
		email.sendKeys("shubhambhandari003@gmail.com");

		logger1.log(Status.PASS, "Email Entered Successfully");
		password.sendKeys("shubham@123");

		logger1.log(Status.PASS, "Password entered successfully");
		submit.click();

		logger1.log(Status.PASS, "Submit button clicked");

	}

	/*
	 * public WebElement getLogin() { return driver.findElement(signin); }
	 * 
	 * 
	 * public WebElement getEmail() { return driver.findElement(email); }
	 * 
	 * 
	 * public WebElement getPass() { return driver.findElement(Password); }
	 * 
	 * 
	 * public WebElement getloggedin() { return driver.findElement(submit); }
	 */

	public WebElement gettitle() {
		return driver.findElement(Title);
	}

}
