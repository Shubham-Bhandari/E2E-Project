package store;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import pageObjects.LandingPage;
import resources.Base;

public class ValidateTitle extends Base {


	ExtentTest logger;

	@BeforeTest
	public void initialize() throws Throwable {
		logger2=extent.createTest("Validata Title Test");
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
	}

	@Test
	public void validating() throws Throwable {
		
		/*
		 * LandingPage lp = PageFactory.initElements(driver, LandingPage.class);
		 * Assert.assertEquals(lp.gettitle().getText(),
		 * "Automation Practice Website123"); logger.log(Status.PASS,
		 * "Title Verification Done");
		 */
		//WebElement title=driver.findElement(By.xpath("//*[@id='editorial_block_center']/h1"));
		String titleText=driver.getTitle();
		System.out.println(titleText);
		logger2.log(Status.PASS, "Text Captured");
		
	}

	@AfterMethod
	public void teardown(ITestResult result) throws IOException {
		if (ITestResult.FAILURE == result.getStatus()) 
		{
			String temp = Base.getScreenShotPath(result.getName(), driver);
			logger.fail(result.getThrowable().getMessage(),MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
		}

	}

	@AfterTest
	public void teardown() {
		extent.flush();
		driver.close();
	}

}
